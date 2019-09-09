package com.mrll.manda.hackathon.q3.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class SimpleEmailMessage {
    private final String projectId;
    private final String to;
    private final String from;
    private final String replyTo;
    private final String subject;
    private final String message;

    @JsonCreator
    public SimpleEmailMessage(@JsonProperty("projectId") String projectId,
                              @JsonProperty("to") String to,
                              @JsonProperty("from") String from,
                              @JsonProperty("replyTo") String replyTo,
                              @JsonProperty("subject") String subject,
                              @JsonProperty("message") String message) {
        this.projectId = projectId;
        this.to = to;
        this.from = from;
        this.replyTo = replyTo;
        this.subject = subject;
        this.message = message;
    }


    public String getProjectId() {
        return projectId;
    }

    public String getFrom() {
        return from;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getTo() {
        return to;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof SimpleEmailMessage)) {
            return false;
        }

        SimpleEmailMessage that = (SimpleEmailMessage) o;

        return new EqualsBuilder()
                .append(projectId, that.projectId)
                .append(to, that.to)
                .append(from, that.from)
                .append(replyTo, that.replyTo)
                .append(subject, that.subject)
                .append(message, that.message)
                .isEquals();
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(projectId)
                .append(to)
                .append(from)
                .append(replyTo)
                .append(subject)
                .append(message)
                .toHashCode();
    }
}
