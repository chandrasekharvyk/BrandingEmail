package com.mrll.manda.hackathon.q3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandingColors {
    String primaryColor;
    String primaryColorText = "primaryColor";
    String secondaryColor;
    String secondaryColorText = "secondaryColor";
    String projectIdText = "projectId";
    String image;
    String projectId;

    public String getPrimaryColorText() {
        return primaryColorText;
    }

    public void setPrimaryColorText(String primaryColorText) {
        this.primaryColorText = primaryColorText;
    }

    public String getSecondaryColorText() {
        return secondaryColorText;
    }

    public void setSecondaryColorText(String secondaryColorText) {
        this.secondaryColorText = secondaryColorText;
    }



    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectIdText() {
        return projectIdText;
    }

    public void setProjectIdText(String projectIdText) {
        this.projectIdText = projectIdText;
    }
}
