package com.anshutiwari.hostelapp.Model;

public class Student {
    private String student_fid;
    private String student_phone;
    private String student_email;
    private String student_name;
    private String imageURL;
    private String id_imageURL;

    public Student() {
    }

    public Student(String student_fid, String student_phone, String student_email, String student_name, String imageURL, String id_imageURL) {
        this.student_fid = student_fid;
        this.student_phone = student_phone;
        this.student_email = student_email;
        this.student_name = student_name;
        this.imageURL = imageURL;
        this.id_imageURL = id_imageURL;
    }

    public String getStudent_fid() {
        return student_fid;
    }

    public void setStudent_fid(String student_fid) {
        this.student_fid = student_fid;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getId_imageURL() {
        return id_imageURL;
    }

    public void setId_imageURL(String id_imageURL) {
        this.id_imageURL = id_imageURL;
    }
}
