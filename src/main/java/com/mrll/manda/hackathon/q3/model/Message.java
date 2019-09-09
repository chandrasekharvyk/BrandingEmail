package com.mrll.manda.hackathon.q3.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Message {

    private final String subject;
    private final String body;

    @JsonCreator
    public Message(@JsonProperty("subject") String subject, @JsonProperty("body") String body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof Message)) {
            return false;
        }

        Message message = (Message) o;

        return new EqualsBuilder()
                .append(subject, message.subject)
                .append(body, message.body)
                .isEquals();
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(subject)
                .append(body)
                .toHashCode();
    }
}
