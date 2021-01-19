package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        FloatingActionButton buttonToAboutYou = (FloatingActionButton) findViewById(R.id.buttonToAboutYou);
        buttonToAboutYou.setOnClickListener(createProfileView->openAboutYouActivity());
        //To be continued
        EditText passwordInput =findViewById(R.id.confirmPassword);

    }
    public void openAboutYouActivity(){
        Intent aboutYouIntent=new Intent( this , AboutYouActivity.class);
        startActivity(aboutYouIntent);
    }
    //To be continued
    public void passwordConfirmation(String p, String pC){
        p= String.valueOf(R.id.password);
        pC=String.valueOf(R.id.confirmPassword);
        String errorMessage= "Password does not match, please try again";
        if (p!=pC){
            System.out.println(errorMessage);
        }
    }

}