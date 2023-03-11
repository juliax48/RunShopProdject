package com.runshop.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class User {

    private Long id;

    private String name;

    private String surname;

    private Timestamp birthDate;

    private Double weight;

    private Double height;

    public User() {
    }

    public User(Long id, String name, String surname, Timestamp birthDate, Double weight, Double height) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.weight = weight;
        this.height = height;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User user)) return false;
//        return id.equals(user.id) && name.equals(user.name) && surname.equals(user.surname) && birthDate.equals(user.birthDate) && weight.equals(user.weight) && height.equals(user.height);
//    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    //    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
//    }

}
