package com.example.sisapp;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class Lock extends AppCompatActivity {

    EditText passwordField;

    String passwordText;

    Button unlockBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lock);


        passwordField = findViewById(R.id.passwordTextField);
        unlockBtn = findViewById(R.id.unlockButton);

        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        passwordText = sharedPreferences.getString("password", "");


        if (passwordText.isEmpty()){
            Intent intent = new Intent(Lock.this, ShowStudentsActivity.class);
            startActivity(intent);
            finish();
        }


        unlockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passwordField.getText().toString().equals(passwordText)){
                    Intent intent = new Intent(Lock.this, ShowStudentsActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}