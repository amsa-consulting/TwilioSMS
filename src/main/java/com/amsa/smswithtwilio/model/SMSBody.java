package com.amsa.smswithtwilio.model;

import lombok.Data;

@Data
public class SMSBody {

    private String destinationNumber;
    private String messageBody;
}
