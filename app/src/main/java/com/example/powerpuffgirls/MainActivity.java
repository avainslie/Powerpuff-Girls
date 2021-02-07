package com.example.powerpuffgirls;
import com.example.powerpuffgirls.ui.login.LoginActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button signUp= findViewById(R.id.signUpButton);
        signUp.setOnClickListener(signUpView -> openSignUpActivity());

        Button logIn = findViewById(R.id.logInButton);
        logIn.setOnClickListener(logInView -> openLogInActivity());
//        ActionBar actionBar = getSupportActionBar();
//        //actionBar.setTitle(getString(R.string.titolo));
//        actionBar.setIcon(R.drawable.comeuptrans);
//        actionBar.setDisplayShowHomeEnabled(true);
    }

    public void openLogInActivity() {
        Intent logInIntent = new Intent(this, LoginActivity.class);
        startActivity(logInIntent);
    }
    public void openSignUpActivity(){
        Intent signUpIntent = new Intent(this, SignUpActivity.class );
        startActivity(signUpIntent);
    }



}