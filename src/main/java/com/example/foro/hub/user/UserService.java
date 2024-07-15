package com.example.foro.hub.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> listUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }
}
