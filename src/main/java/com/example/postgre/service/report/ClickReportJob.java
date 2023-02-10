package com.example.postgre.service.report;

import com.example.postgre.config.properties.ClickReportProperties;
import com.example.postgre.repository.ClickRepository;
import com.example.postgre.service.email.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Component
@Slf4j
public class ClickReportJob {

    ClickRepository clickRepository;
    EmailService emailService;
    ClickReportProperties clickReportProperties;

    @Scheduled(fixedDelay = 1000000, initialDelay = 1000)
    public void schedule() {
        log.info("Starting ClickReportJob...");
        clickRepository.findTop10()
                .collectList()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(clickReports -> {
                    log.info("ClickReport: {}", clickReports);
                    emailService.sendSimpleMessage(clickReportProperties.getRecipient(),
                            clickReportProperties.getSubject(),
                            clickReports.toString());
                });
    }
}
