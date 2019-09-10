package com.mrll.manda.hackathon.q3.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mrll.manda.hackathon.q3.model.BrandingColors;
import com.mrll.manda.hackathon.q3.model.SimpleEmailMessage;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

@Component
public class BrandingColorClient {

    public static final String AWS_URL = "https://branding-ds1.apps.us2.devg.foundry.mrll.com/api/projects/branding/{projectId}";

    private RestTemplate restTemplate;

    @Autowired
    public BrandingColorClient(RestTemplate compositeRestTemplate) {
        this.restTemplate = compositeRestTemplate;
    }

    public BrandingColors getBrandingColors(String projectId) {
        String responseString = restTemplate.getForObject(AWS_URL, String.class, projectId);
        String justString = StringUtils.substringBetween(responseString, "{", "}");
        String[] strings  = justString.split(",");
        BrandingColors brandingColors=new BrandingColors();
        for(int i=0;i<strings.length;i++) {
            String[] keyVal = strings[i].split("=");
            if(keyVal[0].trim().equals(brandingColors.getPrimaryColorText()) && keyVal[1].contains("\'")){
                brandingColors.setPrimaryColor(StringUtils.substringBetween(keyVal[1],"\'","\'"));
            }
            if(keyVal[0].trim().equals(brandingColors.getSecondaryColorText()) && keyVal[1].contains("\'")){
                brandingColors.setSecondaryColor(StringUtils.substringBetween(keyVal[1],"\'","\'"));
            }
            if(keyVal[0].trim().equals(brandingColors.getProjectIdText()) && keyVal[1].contains("\'")){
                brandingColors.setProjectId(StringUtils.substringBetween(keyVal[1],"\'","\'"));
            }
        }
        return brandingColors;
    }
}
