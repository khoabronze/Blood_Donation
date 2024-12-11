package com.example.blooddonation;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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



        Button registerButton = findViewById(R.id.button2);

        registerButton.setOnClickListener(v -> {
            String name = ((EditText) findViewById(R.id.editTextText2)).getText().toString();
            String email = ((EditText) findViewById(R.id.editTextTextEmailAddress)).getText().toString();
            String phone = ((EditText) findViewById(R.id.editTextText4)).getText().toString();
            String password = ((EditText) findViewById(R.id.editTextTextPassword2)).getText().toString();
            String bloodType = spinnerBloodType.getSelectedItem().toString();

            // Perform validation (if necessary)

            // Save data to Firestore
            FirestoreManager firestoreManager = new FirestoreManager();
            firestoreManager.saveUserData(name, email, phone,password, bloodType);
        });





    }
}