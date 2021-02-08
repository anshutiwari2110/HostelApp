package com.anshutiwari.hostelapp.Model;

public class Admin {
    private String admin_fid;
    private String admin_phone;
    private String admin_email;
    private String admin_name;
    private String admin_role;
    private String admin_imageURL;

    public Admin() {
    }

    public Admin(String admin_fid, String admin_phone, String admin_email, String admin_name, String admin_role, String admin_imageURL) {
        this.admin_fid = admin_fid;
        this.admin_phone = admin_phone;
        this.admin_email = admin_email;
        this.admin_name = admin_name;
        this.admin_role = admin_role;
        this.admin_imageURL = admin_imageURL;
    }

    public String getAdmin_fid() {
        return admin_fid;
    }

    public void setAdmin_fid(String admin_fid) {
        this.admin_fid = admin_fid;
    }

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_role() {
        return admin_role;
    }

    public void setAdmin_role(String admin_role) {
        this.admin_role = admin_role;
    }

    public String getAdmin_imageURL() {
        return admin_imageURL;
    }

    public void setAdmin_imageURL(String admin_imageURL) {
        this.admin_imageURL = admin_imageURL;
    }
}
