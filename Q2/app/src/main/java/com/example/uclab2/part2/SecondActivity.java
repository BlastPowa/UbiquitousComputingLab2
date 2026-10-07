package com.example.uclab2.part2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private int validationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String name = getIntent().getStringExtra("name");
        TextView messageText = findViewById(R.id.messageText);
        messageText.setText(getString(R.string.thank_you, name));

        validationCode = new Random().nextInt(30) + 1;
    }

    public void sendEmail(View view) {
        String email = getIntent().getStringExtra("email");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_body, validationCode));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void validateCode(View view) {
        EditText codeInput = findViewById(R.id.codeInput);
        String enteredCode = codeInput.getText().toString().trim();
        TextView statusText = findViewById(R.id.statusText);

        if (enteredCode.equals(String.valueOf(validationCode))) {
            statusText.setText(R.string.account_validated);
        } else {
            statusText.setText(R.string.code_error);
        }
    }

}
