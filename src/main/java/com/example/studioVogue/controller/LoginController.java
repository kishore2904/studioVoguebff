package com.example.studioVogue.controller;

import com.example.studioVogue.bo.Login;
import com.example.studioVogue.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class LoginController {


    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/test")
    public String test() {
        return "test is working";
    }

    @GetMapping("/getFirestore/{id}")
    public List<Login> getLoginUser(@PathVariable String id) throws ExecutionException, InterruptedException {
        return loginService.getLoginService(id);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> createUserAccount(@RequestBody Login login) {
        return loginService.createUserAccount(login);
    }
}
