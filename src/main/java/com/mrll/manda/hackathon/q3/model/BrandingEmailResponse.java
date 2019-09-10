package com.mrll.manda.hackathon.q3.model;

public class BrandingEmailResponse {
    String recipientEmail;
    String templateName;

    public BrandingEmailResponse(String email,String templateName){
        this.recipientEmail = email;
        this.templateName = templateName;
    }
    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
