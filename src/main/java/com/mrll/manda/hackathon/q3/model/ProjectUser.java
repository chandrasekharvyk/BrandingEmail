package com.mrll.manda.hackathon.q3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.mrll.javelin.common.security.model.UserType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ProjectUser {
    public static final String ACTIVE_STATUS = "ACTIVE";
    public static final String CONTENT_PERMISSION_GROUP = "CONTENT_PERMISSION_GROUP";

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private String userType;
    private String languageCode;
    /*@JsonProperty("userGroups")
    private List<ProjectUserGroup> userGroups = new ArrayList<>();*/

    public String getUserId() {
        return userId;
    }

    public ProjectUser setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ProjectUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ProjectUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ProjectUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ProjectUser setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getUserType() {
        return userType;
    }

    public ProjectUser setUserType(String userType) {
        this.userType = userType;
        return this;
    }

    /*public List<ProjectUserGroup> getUserGroups() {
        return userGroups;
    }

    public ProjectUser setUserGroups(List<ProjectUserGroup> userGroups) {
        this.userGroups = userGroups;
        return this;
    }

    public boolean isProjectAdmin() {
        return UserType.isAdmin(userType);
    }

    public String getPermissionGroupId() {
        if(CollectionUtils.isEmpty(userGroups)){
            return null;
        }
        return userGroups.stream()
                .filter(g -> CONTENT_PERMISSION_GROUP.equals(g.getUserGroupType()))
                .map(ProjectUserGroup::getUserGroupId)
                .findFirst()
                .orElse(null);
    }*/

    public boolean isActive() {
        return ACTIVE_STATUS.equals(status);
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public ProjectUser setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("userId", userId)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("email", email)
                .add("status", status)
                .add("userType", userType)
                .add("languageCode", languageCode)
                .toString();
    }
}
