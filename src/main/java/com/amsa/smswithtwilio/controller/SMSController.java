package com.amsa.smswithtwilio.controller;

import com.amsa.smswithtwilio.model.SMSBody;
import com.amsa.smswithtwilio.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    SMSService smsService;

    @PostMapping("/send")
    public String SendSMS(@RequestBody SMSBody smsBody){
         return smsService.SendSMSFromSerive(smsBody.getDestinationNumber(),smsBody.getMessageBody());
    }
}
