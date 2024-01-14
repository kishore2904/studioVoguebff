package com.example.studioVogue;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.studioVogue")
public class StudioVogueApplication {

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = StudioVogueApplication.class.getClassLoader();
		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
		FileInputStream serviceAccount =
				new FileInputStream(file.getAbsoluteFile());

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://studio-vogue-sprinboot-default-rtdb.asia-southeast1.firebasedatabase.app")
				.build();

		FirebaseApp.initializeApp(options);

		SpringApplication.run(StudioVogueApplication.class, args);
	}

}
