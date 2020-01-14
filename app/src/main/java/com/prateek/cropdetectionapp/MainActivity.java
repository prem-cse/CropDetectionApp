package com.prateek.cropdetectionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    Button loginButton, acceptButton;
    TextView tac;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.login);
        acceptButton = findViewById(R.id.accept);
        
        tac = findViewById(R.id.tac);
        tac.setHighlightColor(getResources().getColor(R.color.transparent));

        String text = "I read and accept the terms of use and the privacy policy.";

        SpannableString string = new SpannableString(text);

        ClickableSpan c1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(MainActivity.this, "Terms of use", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getResources().getColor(R.color.green));
                ds.setUnderlineText(false);

            }
        };

        ClickableSpan c2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(MainActivity.this, "Privacy Policy", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getResources().getColor(R.color.green));
                ds.setUnderlineText(false);

            }

        };

        string.setSpan(c1, 22, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        string.setSpan(c2, 43, 57, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );

        tac.setText(string);
        tac.setMovementMethod(LinkMovementMethod.getInstance());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, loginPage.class));
            }
        });

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Great! You can now proceed to login or sign up", Toast.LENGTH_SHORT).show();
            }
        });

        
    }
}
