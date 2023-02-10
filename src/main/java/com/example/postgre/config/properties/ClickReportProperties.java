package com.example.postgre.config.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("report")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClickReportProperties {
    String lastName;
    String recipient;
    String subject;
}
