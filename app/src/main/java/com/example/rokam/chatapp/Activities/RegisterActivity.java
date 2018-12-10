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
    private Button button2;
    private Button button3;
    private Button button4;


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

        button2 = (Button) findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome2();
            }
        });
        button3 = (Button) findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome3();
            }
        });
        button4 = (Button) findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome4();
            }
        });
    }
    public void openHome() {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
    public void openHome2() {
        Intent intent2 = new Intent(this, home2.class);
        startActivity(intent2);
    }
    public void openHome3() {
        Intent intent3 = new Intent(this, home3.class);
        startActivity(intent3);
    }
    public void openHome4() {
        Intent intent4 = new Intent(this, home4.class);
        startActivity(intent4);
    }

}
