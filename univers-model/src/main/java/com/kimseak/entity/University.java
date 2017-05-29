package com.kimseak.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kimseak on 5/28/17.
 */
@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "university_name")
    @NotNull(message = "University name must be filled!")
    private String universityName;

    @NotNull(message = "University country must be filled!")
    @Column(name = "university_country")
    private String universityCountry;

    @NotNull(message = "University city must be filled!")
    @Column(name = "university_city")
    private String universityCity;

    public University(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityCountry() {
        return universityCountry;
    }

    public void setUniversityCountry(String universityCountry) {
        this.universityCountry = universityCountry;
    }

    public String getUniversityCity() {
        return universityCity;
    }

    public void setUniversityCity(String universityCity) {
        this.universityCity = universityCity;
    }

    @Override
    public String toString() {
        return this.universityName;
    }
}
