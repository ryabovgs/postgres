package com.example.postgre.service.report;

import com.example.postgre.repository.CustomerRepository;
import com.example.postgre.service.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Component
public class ReportJob {

    CustomerRepository customerRepository;
    EmailService emailService;

    @Scheduled(fixedDelay = 10000, initialDelay = 1000)
    public void scheduleFixedDelayTask() {
        System.out.println("Starting Job!!!");
        customerRepository.findTop10("Doe2")
                .collectList()
                .subscribe(customers -> {
                    System.out.println(customers);
                    emailService.sendSimpleMessage("ryabovgs@gmail.com", "Great Job", customers.toString());
                });
    }
}
