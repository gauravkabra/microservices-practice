package com.charbhujatechnologies.microservices.limitsservice.bean;

import lombok.Data;

@Data
public class Limits {
    private int minimum;
    private int maximum;

    public Limits() {
        super();
    }

    public Limits(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
