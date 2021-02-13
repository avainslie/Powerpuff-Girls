package com.example.powerpuffgirls;
import com.example.powerpuffgirls.ui.login.LoginActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAppBar();
        Button signUp= findViewById(R.id.signUpButton);
        signUp.setOnClickListener(signUpView -> openSignUpActivity());

        Button logIn = findViewById(R.id.logInButton);
        logIn.setOnClickListener(logInView -> openLogInActivity());
    }

    public void initAppBar() {
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        //getSupportActionBar().setElevation(0);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        View view = getSupportActionBar().getCustomView();
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