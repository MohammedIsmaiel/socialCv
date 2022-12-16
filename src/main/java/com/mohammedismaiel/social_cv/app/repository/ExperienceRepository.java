package com.mohammedismaiel.social_cv.app.repository;

import com.mohammedismaiel.social_cv.app.domain.Experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "experience")
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    
}
