package com.example.blooddonation;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Spinner spinnerBloodType = findViewById(R.id.spinnerBloodType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.blood_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBloodType.setAdapter(adapter);

        Spinner spinnerRole = findViewById(R.id.spinnerRole);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.roles, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRole.setAdapter(adapter1);

        Button registerButton = findViewById(R.id.button2);

        registerButton.setOnClickListener(v -> {
            String name = ((EditText) findViewById(R.id.editTextText2)).getText().toString();
            String email = ((EditText) findViewById(R.id.editTextTextEmailAddress)).getText().toString();
            String phone = ((EditText) findViewById(R.id.editTextText4)).getText().toString();
            String password = ((EditText) findViewById(R.id.editTextTextPassword2)).getText().toString();
            String bloodType = spinnerBloodType.getSelectedItem().toString();
            String role = spinnerRole.getSelectedItem().toString();

            if (isValidEmail(email)) {
                // Save data to Firestore
                FirestoreManager firestoreManager = FirestoreManager.getInstance();
                firestoreManager.saveUserData(name, email, phone, password, bloodType, role);
                Toast.makeText(register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(register.this, "Invalid email format", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}