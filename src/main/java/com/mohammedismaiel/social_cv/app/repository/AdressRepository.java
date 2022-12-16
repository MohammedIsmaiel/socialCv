package com.mohammedismaiel.social_cv.app.repository;

import com.mohammedismaiel.social_cv.app.domain.Adress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "adresses")
public interface AdressRepository extends JpaRepository<Adress,Long> {
    
}
