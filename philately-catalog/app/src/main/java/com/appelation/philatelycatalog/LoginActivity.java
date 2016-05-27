package com.appelation.philatelycatalog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton ibFacebookIcon;
    Button bLogin, bSignUp, bForgot;
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        bSignUp = (Button) findViewById(R.id.bSignUp);
        bForgot = (Button) findViewById(R.id.bForgot);

        bLogin.setOnClickListener(this);
        bSignUp.setOnClickListener(this);
        bForgot.setOnClickListener(this);

        ibFacebookIcon =(ImageButton)findViewById(R.id.ibFacebookIcon);
        ibFacebookIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"facebook login feature yet to be implemented!", Toast.LENGTH_LONG).show();
            }

        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:
                Toast.makeText(getApplicationContext(),"you have clicked the login button!", Toast.LENGTH_LONG).show();
                break;
            case R.id.bSignUp:
//                Toast.makeText(getApplicationContext(),"you have clicked sign up button!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.bForgot:
                Toast.makeText(getApplicationContext(),"you have clicked forgot password button!", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
