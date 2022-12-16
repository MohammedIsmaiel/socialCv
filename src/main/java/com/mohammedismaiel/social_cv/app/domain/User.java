package com.mohammedismaiel.social_cv.app.domain;

import java.io.Serializable;
import java.util.UUID;

// import java.util.Date;
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
@Entity(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String userId = new UUID(10, 10).toString();
    private String username;

    @OneToOne
    private PersonalInfo personalInfo;
    // private String password;
    // private String email;
    // private String profileImageUrl;
    // private Date lastLoginDate;
    // private Date lastLoginDateDisplay;
    // private Date joinDate;
    // private String role;
    // private String[] authorities;
    // private boolean isActive;
    // private boolean isNotLocked;
}