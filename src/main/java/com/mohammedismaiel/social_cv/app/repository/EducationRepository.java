package com.mohammedismaiel.social_cv.app.repository;

import com.mohammedismaiel.social_cv.app.domain.Education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "education")
public interface EducationRepository extends JpaRepository<Education, Long>{
    
}
