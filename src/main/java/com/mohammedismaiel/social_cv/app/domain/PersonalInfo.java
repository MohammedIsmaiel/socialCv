package com.mohammedismaiel.social_cv.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "personal_info")
public class PersonalInfo {

    // TODO #3 add validations and base class for ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String role;
    private String photo;
    private String roleSumary;
    private Date birthDate;
    private int age;
    private String phone;
    private String about;
    private String militaryStatus;
    private String email;
    private String website;
    private String[] socialMedia;
    private String hoppy;
    private String socialStatus;
    private String skillSumary;
    private String briefInfo;
    @OneToOne
    private Adress adress;
}
