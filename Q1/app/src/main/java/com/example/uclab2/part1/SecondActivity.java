package com.example.uclab2.part1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String name = getIntent().getExtras().getString("name");
        TextView messageText = findViewById(R.id.messageText);
        messageText.setText(getString(R.string.thank_you, name));
    }
}
