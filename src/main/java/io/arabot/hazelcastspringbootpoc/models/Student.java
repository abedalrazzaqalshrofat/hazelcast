package io.arabot.hazelcastspringbootpoc.models;

import java.io.Serializable;

public class Student implements Serializable {


    public static final int serialVersionUID = 154;

    private Integer id;
    private String firstname;
    private String lastname;

    public Student() {
    }

    public Student(Integer id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
