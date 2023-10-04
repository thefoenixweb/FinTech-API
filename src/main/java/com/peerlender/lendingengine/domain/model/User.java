package com.peerlender.lendingengine.domain.model;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Objects;


@Entity
public  class User implements Serializable {

    @Id
    private String username;
    private  String firstname;
    private  String lastName;
    private  int age;
    private  String occupation;
    @OneToOne(cascade = CascadeType.ALL)
    private Balance balance;

    public User(){}
    public User(String username, String firstname, String lastName, int age, String occupation,Balance balance) {
        this.username = username;
        this.firstname = firstname;
        this.lastName = lastName;
        this.age = age;
        this.occupation = occupation;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public Balance getBalance() {
        return balance;
    }

    public void topUp(final Money money) {
        balance.topUp(money);
    }

    public void withDraw(final Money money){
        balance.withdraw(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(username, user.username) && Objects.equals(firstname, user.firstname) && Objects.equals(lastName, user.lastName) && Objects.equals(occupation, user.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstname, lastName, age, occupation);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
