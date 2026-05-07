package com.example.hibernatedao.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "PERSONS")
@IdClass(PersonId.class)
public class Person implements Serializable {
    @Id
    private String name;
    @Id
    private String surname;
    @Id
    private Integer age;
    private String phoneNumber;
    @Column(name = "city_of_living")
    private String cityOfLiving;

    public Person() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getCityOfLiving() { return cityOfLiving; }
    public void setCityOfLiving(String cityOfLiving) { this.cityOfLiving = cityOfLiving; }
}