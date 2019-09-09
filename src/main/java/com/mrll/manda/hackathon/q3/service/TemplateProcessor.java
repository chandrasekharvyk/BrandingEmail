package com.mrll.manda.hackathon.q3.service;


import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

@Component
public class TemplateProcessor {

    private SpringTemplateEngine springTemplateEngine;

    public TemplateProcessor(SpringTemplateEngine springTemplateEngine){
        this.springTemplateEngine = springTemplateEngine;
    }

    public String process(String templateName, Context context) {
        return springTemplateEngine.process(templateName, context);
    }
}
