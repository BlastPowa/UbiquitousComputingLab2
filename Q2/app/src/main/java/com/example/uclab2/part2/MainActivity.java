package com.example.uclab2.part2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitForm(View view) {
        EditText nameInput = findViewById(R.id.nameInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        EditText telephoneInput = findViewById(R.id.telephoneInput);
        EditText emailInput = findViewById(R.id.emailInput);

        String name = nameInput.getText().toString().trim();
        String password = passwordInput.getText().toString();
        String telephone = telephoneInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();

        nameInput.setError(null);
        passwordInput.setError(null);
        telephoneInput.setError(null);
        emailInput.setError(null);

        if (name.isEmpty()) {
            nameInput.setError(getString(R.string.name_error));
            nameInput.requestFocus();
            return;
        }
        for (int i = 0; i < name.length(); i++) {
            char letter = name.charAt(i);
            if (!Character.isLetter(letter) && letter != ' ') {
                nameInput.setError(getString(R.string.name_error));
                nameInput.requestFocus();
                return;
            }
        }

        if (password.trim().isEmpty()) {
            passwordInput.setError(getString(R.string.password_error));
            passwordInput.requestFocus();
            return;
        }

        if (telephone.isEmpty()) {
            telephoneInput.setError(getString(R.string.telephone_error));
            telephoneInput.requestFocus();
            return;
        }
        for (int i = 0; i < telephone.length(); i++) {
            char digit = telephone.charAt(i);
            if (digit < '0' || digit > '9') {
                telephoneInput.setError(getString(R.string.telephone_error));
                telephoneInput.requestFocus();
                return;
            }
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError(getString(R.string.email_error));
            emailInput.requestFocus();
            return;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        startActivity(intent);
    }
}
