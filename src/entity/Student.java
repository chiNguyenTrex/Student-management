/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ChiNguyen
 */
public class Student {
    private String studentId;
    private String studentName;
    private String studentBirth;
    private String studentGender;
    private String studentPhone;
    private String studentEmail;
    private String studentAddress;
    private String imageUrl;

    public Student() {
    }

    public Student(String studentId, String studentName, String studentBirth, String studentGender, String studentPhone, String studentEmail, String studentAddress, String imageUrl) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentBirth = studentBirth;
        this.studentGender = studentGender;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
        this.imageUrl = imageUrl;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentBirth() {
        return studentBirth;
    }

    public void setStudentBirth(String studentBirth) {
        this.studentBirth = studentBirth;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

   
    
   
}
