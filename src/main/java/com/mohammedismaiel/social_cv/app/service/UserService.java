package com.mohammedismaiel.social_cv.app.service;

import com.mohammedismaiel.social_cv.app.domain.User;

public interface UserService {

    User findUserByUsername(String username);

}
