package com.mrll.manda.hackathon.q3.service;

import com.mrll.manda.hackathon.q3.client.BrandingColorClient;
import com.mrll.manda.hackathon.q3.model.BrandingColors;
import com.mrll.manda.hackathon.q3.model.BrandingEmailResponse;
import com.mrll.manda.hackathon.q3.model.Message;
import com.mrll.manda.hackathon.q3.model.ProjectUser;
import com.mrll.manda.hackathon.q3.util.EmailHelper;
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

    private static final String FROM_EMAIL_DO_NOT_REPLY = "Merrill DatasiteOne <DatasiteOne-noreply@merrillcorp.com>";
    private static final String RECIPIENT_USER = "chandra.sekhar@merrillcorp.com";
    //private static final String RECIPIENT_USER = "Ehren.kluge@merrillcorp.com";
    private static final String SUBJECT = "Project Invitation";

    private TemplateProcessor templateProcessor;
    private EmailHelper emailHelper;
    private BrandingColorClient brandingColorClient;

    public BrandingEmailService(TemplateProcessor templateProcessor, EmailHelper emailHelper, BrandingColorClient brandingColorClient) {
        this.templateProcessor = templateProcessor;
        this.emailHelper = emailHelper;
        this.brandingColorClient = brandingColorClient;
    }

    public BrandingEmailResponse sendBrandingEmail(Map<String, Object> parameters, String templateName) throws Exception {
        logger.info("message=mergingTemplate parameters={}", parameters);
        BrandingColors brandingColors = null;
        try {
            brandingColors = brandingColorClient.getBrandingColors((String) parameters.get("projectName"));
        } catch (Exception ex) {
            logger.error("Error getting branded colorss");
        }

        if (brandingColors == null) {
            parameters.put(brandingColors.getPrimaryColorText(), "02294e");
            parameters.put(brandingColors.getSecondaryColorText(), "1aae4b");
        } else {
            parameters.put(brandingColors.getPrimaryColorText(), brandingColors.getPrimaryColor());
            parameters.put(brandingColors.getSecondaryColorText(), brandingColors.getSecondaryColor());
        }

        Context context = constructContext(parameters);
        String template = getMessageTemplateLocation(templateName);
        String mergedTemplate = templateProcessor.process(template, context);
        ProjectUser projectUser = new ProjectUser();
        projectUser.setEmail(RECIPIENT_USER);
        Message message = new Message(SUBJECT, mergedTemplate);


        emailHelper.sendMessageToUser("", projectUser, message, FROM_EMAIL_DO_NOT_REPLY);
        return new BrandingEmailResponse(RECIPIENT_USER, templateName);
    }

    private String getMessageTemplateLocation(String templateName) throws Exception {
        String template;
        StringBuilder builder = new StringBuilder().append(templateName).append(".html");
        URL templateResource = getClass().getResource(new StringBuilder("/templates/").append(templateName).append(".html").toString());
        if (templateResource != null) {
            template = templateResource.toString();
        } else {
            template = builder.toString();
        }
        if (templateName == null) {
            logger.error("Template name can't be null");
            throw new Exception();
        }
        return templateName;
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
