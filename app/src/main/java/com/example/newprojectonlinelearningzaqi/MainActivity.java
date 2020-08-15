package com.example.newprojectonlinelearningzaqi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText username;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("login", MODE_PRIVATE);
        username = (EditText)findViewById(R.id.input_username);
        password = (EditText)findViewById(R.id.input_password);
        login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equalsIgnoreCase("Admin")
                        && (password.getText().toString().equalsIgnoreCase("Admin"))){
                    editor = pref.edit();
                    editor.putString("username", username.getText().toString());
                    editor.putString("status", "login");
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(), MainMenu.class));
                }
            }
        });


    }
  }

