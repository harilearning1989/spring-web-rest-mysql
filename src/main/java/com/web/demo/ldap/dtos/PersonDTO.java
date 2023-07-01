package com.web.demo.ldap.dtos;

public class PersonDTO {

    private String userId;
    private String fullName;
    private String lastName;
    private String description;

    public String userId() {
        return userId;
    }

    public PersonDTO setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String fullName() {
        return fullName;
    }

    public PersonDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String lastName() {
        return lastName;
    }

    public PersonDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String description() {
        return description;
    }

    public PersonDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
