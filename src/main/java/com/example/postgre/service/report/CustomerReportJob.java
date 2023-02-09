package com.example.postgre.service.report;

import com.example.postgre.config.properties.CustomerReportProperties;
import com.example.postgre.repository.CustomerRepository;
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
public class CustomerReportJob {

    CustomerRepository customerRepository;
    EmailService emailService;
    CustomerReportProperties customerReportProperties;

    @Scheduled(fixedDelay = 10000, initialDelay = 1000)
    public void schedule() {
        log.info("Starting CustomerReportJob!!!");
        customerRepository.findTop10(customerReportProperties.getLastName())
                .collectList()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(customers -> {
                    log.info("CustomerReport: {}", customers);
                    emailService.sendSimpleMessage(customerReportProperties.getRecipient(),
                            customerReportProperties.getSubject(),
                            customers.toString());
                });
    }
}
