package com.mrll.manda.hackathon.q3.client;

import com.mrll.javelin.common.security.service.JavelinJwtService;
import com.mrll.manda.hackathon.q3.model.SimpleEmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmailClient {
    public static final String EMAIL_URL = "http://email-service/api/email";

    private RestTemplate restTemplate;
    private JavelinJwtService javelinJwtService;

    @Autowired
    public EmailClient(RestTemplate compositeRestTemplate,JavelinJwtService javelinJwtService) {
        this.restTemplate = compositeRestTemplate;
        this.javelinJwtService = javelinJwtService;
    }

    public void sendSingleEmail(SimpleEmailMessage request) {
        javelinJwtService.loginAsCurrentService();
        restTemplate.postForObject(EMAIL_URL, request, SimpleEmailMessage.class);
    }
}
