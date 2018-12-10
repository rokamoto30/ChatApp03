package com.example.rokam.chatapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.rokam.chatapp.R;

public class RegisterActivity extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        button = (Button) findViewById(R.id.regBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });
    }
    public void openHome() {
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}
