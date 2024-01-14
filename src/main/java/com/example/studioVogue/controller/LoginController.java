package com.example.studioVogue.controller;

import com.example.studioVogue.bo.Login;
import com.example.studioVogue.entity.Users;
import com.example.studioVogue.repository.LoginRepository;
import com.example.studioVogue.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class LoginController {


    private final LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

  /*  @GetMapping("/admin")
    public List<Users> getLogin(){
        return loginRepository.findAll();
    }*/

    @GetMapping("/test")
    public String test(){
        return "test is working";
    }

    @GetMapping("/getFirestore/{id}")
    public List<Login> getLoginUser(@PathVariable String id) throws ExecutionException, InterruptedException {
        return loginService.getLoginService(id);
    }
}
