package com.web.demo.batch.dtos;

public class StudentDTO {

    private String studentId;
    private String studentName;
    private String fatherName;
    private String gender;
    private String mobile;
    private String category;

    public String studentId() {
        return studentId;
    }

    public StudentDTO setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public String studentName() {
        return studentName;
    }

    public StudentDTO setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public String fatherName() {
        return fatherName;
    }

    public StudentDTO setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String gender() {
        return gender;
    }

    public StudentDTO setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String mobile() {
        return mobile;
    }

    public StudentDTO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String category() {
        return category;
    }

    public StudentDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile=" + mobile +
                ", category='" + category + '\'' +
                '}';
    }
}
