package com.example.foro.hub.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ArrayList<UserModel>> listUsers() {
        ArrayList<UserModel> arrayList = (ArrayList<UserModel>) this.userService.listUsers();
        return ResponseEntity.ok(arrayList);
    }
}
