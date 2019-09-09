package com.mrll.manda.hackathon.q3.util;

import com.mrll.manda.hackathon.q3.client.EmailClient;
import com.mrll.manda.hackathon.q3.model.Message;
import com.mrll.manda.hackathon.q3.model.ProjectUser;
import com.mrll.manda.hackathon.q3.model.SimpleEmailMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailHelper {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private EmailClient emailClient;

    @Autowired
    public EmailHelper(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void sendMessageToUser(String projectId, ProjectUser user, Message message, String fromEmailAddress) {
        emailClient.sendSingleEmail(new SimpleEmailMessage(projectId, user.getEmail(),
                fromEmailAddress, fromEmailAddress, message.getSubject(), message.getBody()));
    }

    public String getValidFromEmailAddress(String emailAddress, String validDefaultAddress) {
        if (StringUtils.isBlank(emailAddress)) {
            return validDefaultAddress;
        }
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress);
        return matcher.find() ? emailAddress : validDefaultAddress;
    }
}
