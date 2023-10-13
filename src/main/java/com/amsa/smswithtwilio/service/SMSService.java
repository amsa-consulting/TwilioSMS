package com.amsa.smswithtwilio.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class SMSService {

    @Value("${account_sid}")
    String account_sid;

    @Value("${auth_token}")
    String auth_token;

    @Value("${outgoing_number}")
    String outgoing_number;

    @PostConstruct
    private void setup(){
        Twilio.init(account_sid,auth_token);
    }
    public String SendSMSFromSerive(String smsNumber, String smsBody){
        Message message = Message.creator(
               new PhoneNumber(smsNumber),
               new PhoneNumber(outgoing_number),
               smsBody).create();

        return message.getStatus().toString();
    }
}
