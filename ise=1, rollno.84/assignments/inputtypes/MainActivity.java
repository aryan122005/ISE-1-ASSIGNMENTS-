package com.example.inputtypes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvResult;

    String correctUsername = "admin";
    String correctPassword = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvResult = findViewById(R.id.tvResult);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if(username.isEmpty() || password.isEmpty()){
                    tvResult.setText("Please enter all fields");
                }
                else if(username.equals(correctUsername) && password.equals(correctPassword)){

                    tvResult.setText("Login Successful ");


                    Intent intent = new Intent(MainActivity.this, options.class);
                    startActivity(intent);

                }
                else{
                    tvResult.setText("Invalid Username or Password ");
                }
            }
        });
    }
}