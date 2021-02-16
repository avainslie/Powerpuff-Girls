package com.example.powerpuffgirls;

import android.net.Uri;

public class ProfileImage {

    private static byte[] imgbytes;
    public static Uri imgUri;

    public void ProfileImage(){

    }

    public void ProfileImage(Uri uri){
        this.imgUri = uri;
    }

    public byte[] getImgbytes() {
        return imgbytes;
    }

    public void setImgbytes(byte[] imgbytes) {
        this.imgbytes = imgbytes;
    }

    public Uri getImgUri(){ return imgUri; }

    public void setImgUri(Uri imgUri){ this.imgUri = imgUri;}
}
