package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AboutYouActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 1;
    private String ethnicity;
    private RadioGroup radioGroup;
    private RadioButton Gender;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference usersRef = db.collection("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_you);

        Button uploadImage = (Button) findViewById(R.id.uploadImageButton);
        uploadImage.setOnClickListener(UploadImageView -> {
            Intent i = new Intent(
                    Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, RESULT_LOAD_IMAGE);
        });
        FloatingActionButton toEducationInfo= (FloatingActionButton) findViewById(R.id.buttonToEducationInfo);
        toEducationInfo.setOnClickListener(EducationInfoView-> openEducationInfoActivity());
    }
    public void openEducationInfoActivity(){


        radioGroup = (RadioGroup) findViewById(R.id.genderOptions);
        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        Gender = (RadioButton) findViewById(selectedId);
        String gender = Gender.toString();



//     TODO: Grab the id sent over by the previous activity
//      String id = getIntent().getStringExtra("Document ID");
        String email = getIntent().getStringExtra("email");


//       TODO: this should send the gender to the newly created firestore doc of the previous activity. Just need the document ID
//        doc userDoc = CollectionReference.document("insert ID of document here");
//        userDoc.updateData({"Gender":gender});


        Intent educationInfoIntent= new Intent(this, EducationInfoActivity.class);
        startActivity(educationInfoIntent);
        educationInfoIntent.putExtra("email",email);
        educationInfoIntent.putExtra("gender",gender);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            // String picturePath contains the path of selected Image
            ImageView imageView = (ImageView) findViewById(R.id.profilePicture);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}