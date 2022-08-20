package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.intent.R;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText theme;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message=findViewById(R.id.messege);
        email=findViewById(R.id.mail);
        theme=findViewById(R.id.theme);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL,email.getText().toString() );
                intent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, message.getText());
                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });
    }
}