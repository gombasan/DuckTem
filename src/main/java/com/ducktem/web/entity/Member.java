package com.ducktem.web.entity;

public class Member {

    private String userId;
    private String name;
    private String pwd;
    private String phoneNumber;
    private String email;
    private String img;
    private String intro;
    private Role role;
    private float level;



    public Member(String userId, String name, String pwd, String phoneNumber, String email, Role role) {
        this.userId = userId;
        this.name = name;
        this.pwd = pwd;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.img = null;
        this.intro = null;
        this.role = role;
        this.level = 0;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", img='" + img + '\'' +
                ", intro='" + intro + '\'' +
                ", role=" + role +
                ", level=" + level +
                '}';
    }
}
