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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private EditText sEmailAddress, sPassword, sFirstname, sLastname, sBirthdate;
    private FirebaseFirestore fstore = FirebaseFirestore.getInstance();
    private FirebaseAuth fAuth;
    private String userID;
    public User newUser;
    public static HashMap<String, String> userMap =new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        sFirstname=findViewById(R.id.firstname);
        sLastname=findViewById(R.id.lastname);
        sBirthdate=findViewById(R.id.birthDate);
        registerFirstStep();
//        Intent aboutYouIntent=new Intent( this , AboutYouActivity.class);
//        startActivity(aboutYouIntent);

    }


    public void registerFirstStep() {
        //String email =
        //newUser.setEmail(sEmailAddress.getText().toString().trim());
        String password = sPassword.getText().toString().trim();
        String firstname=sFirstname.getText().toString().trim();
        String lastname=sLastname.getText().toString().trim();
        String birthdate=sBirthdate.getText().toString().trim();

        /*if (TextUtils.isEmpty((email))) {
            sEmailAddress.setError("Email is Required");
            return;
        }*/

        if (TextUtils.isEmpty(password)) {
            sPassword.setError("Password is Required");
        }

            //userID = fAuth.getCurrentUser().getUid();
        
            userMap.put( "firstname", firstname);
            userMap.put( "lastname", lastname);
            userMap.put( "birthdate", birthdate);


            Intent aboutYouIntent=new Intent( this , AboutYouActivity.class);
            aboutYouIntent.putExtra("message_key", firstname);
            aboutYouIntent.putExtra("message_key", lastname);
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
    public HashMap<String, String> getHashmap() {
        return userMap;
    }

    public void setHashmap(HashMap<String, String> map) {
        this.userMap = userMap;
    }




}