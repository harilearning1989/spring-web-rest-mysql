package com.web.demo.batch.models;

import com.web.demo.batch.utils.CommonUtils;
import jakarta.persistence.*;

import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "STUDENT_ID")
    private long studentId;
    @Column(name = "STUDENT_NAME")
    private String studentName;
    @Column(name = "FATHER_NAME")
    private String fatherName;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "MOBILE")
    private long mobile;
    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "CREATED_DATE")
    private String createdDate;
    @Column(name = "UPDATED_DATE")
    private String updatedDate;

    public Student(long studentId, String studentName, String fatherName, String gender, long mobile, String category) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.gender = gender;
        this.mobile = mobile;
        this.category = category;
        this.createdDate = CommonUtils.currentDateTime();
        this.updatedDate = CommonUtils.currentDateTime();
    }

    public Student() {

    }

    public int id() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public long studentId() {
        return studentId;
    }

    public Student setStudentId(long studentId) {
        this.studentId = studentId;
        return this;
    }

    public String studentName() {
        return studentName;
    }

    public Student setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public String fatherName() {
        return fatherName;
    }

    public Student setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String gender() {
        return gender;
    }

    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public long mobile() {
        return mobile;
    }

    public Student setMobile(long mobile) {
        this.mobile = mobile;
        return this;
    }

    public String category() {
        return category;
    }

    public Student setCategory(String category) {
        this.category = category;
        return this;
    }

    public String createdDate() {
        return createdDate;
    }

    public Student setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public String updatedDate() {
        return updatedDate;
    }

    public Student setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }
}
