package com.runshop.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class User {

    private Long id;

    private String name;

    private String surname;

    private Timestamp dateBirth;

    private Double weight;

    private Double height;

    public User() {
    }

    public User(Long id, String name, String surname, Timestamp dateBirth, Double weight, Double height) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
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

    public Timestamp getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Timestamp dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
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
        result = 31 * result + (dateBirth != null ? dateBirth.hashCode() : 0);
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
                ", birthDate=" + dateBirth +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    //    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
//    }

}
