package com.mrll.manda.hackathon.q3.client;

import com.mrll.manda.hackathon.q3.model.SimpleEmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmailClient {
    public static final String EMAIL_URL = "http://email-service/api/email";

    private RestTemplate restTemplate;

    @Autowired
    public EmailClient(@Qualifier("javelinRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendSingleEmail(SimpleEmailMessage request) {
        restTemplate.postForObject(EMAIL_URL, request, SimpleEmailMessage.class);
    }
}
