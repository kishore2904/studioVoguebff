package com.example.studioVogue.service.impl;

import com.example.studioVogue.bo.Login;
import com.example.studioVogue.service.LoginService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public List<Login> getLoginService(String id) throws ExecutionException, InterruptedException {
        List<Login> loginList = new ArrayList<>();
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("studio_vogue").document(id);
        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = documentSnapshotApiFuture.get();
        Login login;
        if (documentSnapshot.exists()){
            login = documentSnapshot.toObject(Login.class);
            loginList.add(login);
            return loginList;
        }
        return null;
    }
}
