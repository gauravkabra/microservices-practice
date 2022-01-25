package com.charbhujatechnologies.microservices.limitsservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(value = "limits-service")
public class Configuration {
    private int minimum;
    private int maximum;

    public Configuration() {
        super();
    }
}
