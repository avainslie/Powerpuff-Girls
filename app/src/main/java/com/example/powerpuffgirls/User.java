package com.example.powerpuffgirls;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String degreeMajor;
    private String degreeMinorOrConcentration;
    private int age;
    private Boolean internationalStudent;
    private List<String> interests; // = new ArrayList<String>();
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public User() {
    }

    public User(String name, String degreeMajor, String degreeMinorOrConcentration, int age,String email, Boolean internationalStudent, List<String> interests) {
        this.name = name;
        this.degreeMajor = degreeMajor;
        this.degreeMinorOrConcentration = degreeMinorOrConcentration;
        this.age = age;
        this.internationalStudent = internationalStudent;
        this.interests = interests;
        this.email=email;
    }

    public User(String name, String degreeMajor) {
        this.name = name;
        this.degreeMajor = degreeMajor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegreeMajor() {
        return degreeMajor;
    }

    public void setDegreeMajor(String degreeMajor) {
        this.degreeMajor = degreeMajor;
    }

    public String getDegreeMinorOrConcentration() {
        return degreeMinorOrConcentration;
    }

    public void setDegreeMinorOrConcentration(String degreeMinorOrConcentration) {
        this.degreeMinorOrConcentration = degreeMinorOrConcentration;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getInternationalStudent() {
        return internationalStudent;
    }

    public void setInternationalStudent(Boolean internationalStudent) {
        this.internationalStudent = internationalStudent;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
