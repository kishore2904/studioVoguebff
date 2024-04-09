package com.example.studioVogue.service;

import com.example.studioVogue.bo.Login;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface LoginService {

    List<Login> getLoginService(String id) throws ExecutionException, InterruptedException;

    ResponseEntity<String> createUserAccount(Login login);

    ResponseEntity<Login> getLoginDetails(Login login) throws FirebaseAuthException;
}
