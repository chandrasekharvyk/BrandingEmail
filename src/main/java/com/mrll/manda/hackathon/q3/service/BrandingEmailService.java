package com.mrll.manda.hackathon.q3.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.net.URL;
import java.util.Map;

@Service
public class BrandingEmailService {
    protected Logger logger = LoggerFactory.getLogger(BrandingEmailService.class);

    public String getMessageTemplate(Map<String, Object> parameters) {

        logger.info("message=mergingTemplate parameters={}", parameters);
        Context context = constructContext(parameters);
        return "";
    }

    private String getMessageTemplateLocation(String templateName) {
        String template;
        StringBuilder builder = new StringBuilder().append(templateName).append(".html");
        URL templateResource = getClass().getResource(new StringBuilder("/templates/").append(builder.toString()).append(".html").toString());
        if(templateResource != null) {
            template = builder.toString();
        } else {
            template = templateType.getPath();
        }
        return template;
    }

    private Context constructContext(Map<String, Object> parameterMap) {
        Context context = new Context();
        if (null != parameterMap) {
            parameterMap.forEach((k, v) -> {
                if (null != k) {
                    context.setVariable(k.replaceAll("\\.", ""), v);
                }
            });
        }
        return context;
    }
}
