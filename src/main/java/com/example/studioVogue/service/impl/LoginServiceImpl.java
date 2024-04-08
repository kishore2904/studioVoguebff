package com.example.studioVogue.service.impl;

import com.example.studioVogue.bo.Login;
import com.example.studioVogue.service.LoginService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class LoginServiceImpl implements LoginService {

    private final FirebaseAuth firebaseAuth;

    public LoginServiceImpl(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public List<Login> getLoginService(String id) throws ExecutionException, InterruptedException {
        List<Login> loginList = new ArrayList<>();
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("studio_vogue").document(id);
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();
        Login login;
        if (documentSnapshot.exists()) {
            login = documentSnapshot.toObject(Login.class);
            loginList.add(login);
            return loginList;
        }
        return loginList;
    }

    @Override
    public ResponseEntity<String> createUserAccount(Login login) {
        try {
            UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest().setEmail(login.getEmail()).setPassword(login.getPassword());
            firebaseAuth.createUser(createRequest);
            return ResponseEntity.ok("User account created successfully");
        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error signing up user: " + e.getMessage());
        }

    }
}
