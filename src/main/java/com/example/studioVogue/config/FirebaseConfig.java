package com.example.studioVogue.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {
    private static final String DATABASE_URL = "https://studio-vogue-sprinboot.firebaseio.com";
    private static final String SERVICE_ACCOUNT_FILE_PATH = "/home/kannan/Desktop/MyWebsite/StudioVogue/studioVoguebff/src/main/resources/serviceAccountKey.json";

    @Bean
    public FirebaseAuth firebaseAuth() throws IOException {
        // Check if FirebaseApp is already initialized
        if (FirebaseApp.getApps().isEmpty()) {
            FileInputStream serviceAccount = new FileInputStream(SERVICE_ACCOUNT_FILE_PATH);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(DATABASE_URL)
                    .build();

            FirebaseApp.initializeApp(options);
        }

        return FirebaseAuth.getInstance();
    }
}
