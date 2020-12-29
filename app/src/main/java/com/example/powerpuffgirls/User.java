package com.example.powerpuffgirls;
/*
User class, just for testing
 */

public class User {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String school;
    private String bonusInfo;


    public User(int id, String name, int age, String gender, String school, String bonusInfo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.school = school;
        this.bonusInfo = bonusInfo;
    }


    public User(int id, String name, int age, String gender, String school) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getBonusInfo() {
        return bonusInfo;
    }

    public void setBonusInfo(String bonusInfo) {
        this.bonusInfo = bonusInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", school='" + school + '\'' +
                ", bonusInfo='" + bonusInfo + '\'' +
                '}';
    }
}
