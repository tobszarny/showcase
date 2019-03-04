package com.flywithus.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserStore userStore;

    public User registerUser(User user) {
        return userStore.save(user);
    }
}
