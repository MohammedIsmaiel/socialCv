package com.mohammedismaiel.social_cv.app.repository;

import com.mohammedismaiel.social_cv.app.domain.PersonalInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "personalInfo")
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo,Long>{
    
}
