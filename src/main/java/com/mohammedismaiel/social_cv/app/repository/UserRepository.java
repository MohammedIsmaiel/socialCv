package com.mohammedismaiel.social_cv.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mohammedismaiel.social_cv.app.domain.User;

@RepositoryRestResource(exported = true,path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

}
