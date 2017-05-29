package com.kimseak.entity;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.reflect.GenericArrayType;

/**
 * Created by kimseak on 5/27/17.
 */

@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Integer id;

    @NotNull()
    @Column(name = "first_name")
    private String firstName;

    @NotNull()
    @Column(name = "last_name")
    private String lastName;

    @NotNull()
    @Column(name = "age")
    private Integer age;

    @NotNull()
    @Column(name = "gender")
    private String gender;

    public Student(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

