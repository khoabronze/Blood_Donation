package com.example.blooddonation;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FirestoreManager {

    private static FirestoreManager instance;
    private FirebaseFirestore db;

    private FirestoreManager() {
        db = FirebaseFirestore.getInstance();
    }

    public static synchronized FirestoreManager getInstance() {
        if (instance == null) {
            instance = new FirestoreManager();
        }
        return instance;
    }

    public void login(String email, String password, Context context) {
        db.collection("users")
                .whereEqualTo("email", email)
                .whereEqualTo("password", password)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (queryDocumentSnapshots.isEmpty()) {
                        Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show();
                        Log.d("Firestore", "No such document");
                    } else {
                        Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show();
                        Log.d("Firestore", "Document exists");
                        Intent intent = new Intent(context, Homepage_Donor.class);
                        context.startActivity(intent);
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(context, "Error getting documents", Toast.LENGTH_SHORT).show();
                    Log.w("Firestore", "Error getting documents.", e);
                });
    }

    public void saveUserData(String name, String email, String phone, String password, String bloodType, String role) {
        Map<String, Object> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("email", email);
        userData.put("phone", phone);
        userData.put("password", password);
        userData.put("bloodType", bloodType);
        userData.put("role", role);

        db.collection("users")
                .add(userData)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Firestore", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Firestore", "Error adding document", e);
                    }
                });
    }
}