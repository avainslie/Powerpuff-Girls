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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AboutYouActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 1;

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
        Intent educationInfoIntent= new Intent(this, EducationInfoActivity.class);
        startActivity(educationInfoIntent);
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