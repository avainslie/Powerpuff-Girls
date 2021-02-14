package com.example.powerpuffgirls;

import android.widget.ImageView;

public class ProfileImage {

    private static byte[] imgbytes;

    public void ProfileImage(){

    }

    public static byte[] getImgbytes() {
        return imgbytes;
    }

    public static void setImgbytes(byte[] imgbytes) {
        ProfileImage.imgbytes = imgbytes;
    }
}
