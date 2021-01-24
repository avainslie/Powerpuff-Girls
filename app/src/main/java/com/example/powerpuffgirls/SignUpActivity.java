package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private EditText sEmailAddress, sPassword;
    private FirebaseFirestore fstore;
    private FirebaseAuth fAuth;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fstore=FirebaseFirestore.getInstance();
//        fAuth=FirebaseAuth.getInstance();
//
//        if(fAuth.getInstance().getCurrentUser() != null) {
//        }

        setContentView(R.layout.activity_sign_up);
        FloatingActionButton buttonToAboutYou = (FloatingActionButton) findViewById(R.id.buttonToAboutYou);
        buttonToAboutYou.setOnClickListener(createProfileView->openAboutYouActivity());
        //To be continued
        EditText passwordInput =findViewById(R.id.confirmPassword);

    }
    public void openAboutYouActivity(){
        sEmailAddress = findViewById(R.id.emailAddress);
        sPassword = findViewById(R.id.password);
        registerFirstStep();
//        Intent aboutYouIntent=new Intent( this , AboutYouActivity.class);
//        startActivity(aboutYouIntent);

    }

    public void registerFirstStep() {
        String email = sEmailAddress.getText().toString().trim();
        String password = sPassword.getText().toString().trim();

        if (TextUtils.isEmpty((email))) {
            sEmailAddress.setError("Email is Required");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            sPassword.setError("Password is Required");
        }
            //userID = fAuth.getCurrentUser().getUid();

            //DocumentReference documentReference = fstore.collection("Users").document(userID);
            Map<String, String> userMap =new HashMap<>();
            userMap.put( "email", email);
            fstore.collection("Users").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {

                }
            }

            );
            Intent aboutYouIntent=new Intent( this , AboutYouActivity.class);
            startActivity(aboutYouIntent);
    }

        //To be continued
        public void passwordConfirmation (String p, String pC){
            p = String.valueOf(R.id.password);
            pC = String.valueOf(R.id.confirmPassword);
            String errorMessage = "Password does not match, please try again";
            if (p != pC) {
                System.out.println(errorMessage);
            }
        }




}