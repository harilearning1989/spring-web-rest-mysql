package com.web.demo.batch.models;

import com.web.demo.batch.utils.CommonUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String county;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIP")
    private int zip;
    @Column(name = "CREATED_DATE")
    private String createdDate;
    @Column(name = "UPDATED_DATE")
    private String updatedDate;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String companyName, String address, String city, String county, String state, int zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.county = county;
        this.state = state;
        this.zip = zip;
        this.createdDate = CommonUtils.currentDateTime();
        this.updatedDate = CommonUtils.currentDateTime();
    }

    public int id() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public String firstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String lastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String companyName() {
        return companyName;
    }

    public Employee setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String address() {
        return address;
    }

    public Employee setAddress(String address) {
        this.address = address;
        return this;
    }

    public String city() {
        return city;
    }

    public Employee setCity(String city) {
        this.city = city;
        return this;
    }

    public String county() {
        return county;
    }

    public Employee setCounty(String county) {
        this.county = county;
        return this;
    }

    public String state() {
        return state;
    }

    public Employee setState(String state) {
        this.state = state;
        return this;
    }

    public int zip() {
        return zip;
    }

    public Employee setZip(int zip) {
        this.zip = zip;
        return this;
    }

    public String createdDate() {
        return createdDate;
    }

    public Employee setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public String updatedDate() {
        return updatedDate;
    }

    public Employee setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", createdDate='" + createdDate + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                '}';
    }
}

