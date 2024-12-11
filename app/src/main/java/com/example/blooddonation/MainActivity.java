package com.example.blooddonation;



import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        TextView registerTextView = findViewById(R.id.registertext);
        registerTextView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, register.class);
            startActivity(intent);
        });
    }
}