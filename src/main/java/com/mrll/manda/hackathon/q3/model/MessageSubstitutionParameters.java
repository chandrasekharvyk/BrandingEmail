package com.mrll.manda.hackathon.q3.model;


import java.util.HashMap;
import java.util.Map;

public class MessageSubstitutionParameters {
    private Map<String, Object> messageParameters = new HashMap<>();

    public MessageSubstitutionParameters addMessageParameter(String key, Object value) {
        messageParameters.put(key, value);
        return this;
    }

    public Map<String, Object> getMessageParameters() {
        return messageParameters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String,Object> entry : messageParameters.entrySet()) {
            sb.append("\nkey: " + entry.getKey() + " value: " + entry.getValue());
        }
        return sb.toString();
    }
}
