package com.example.navigationdrawerdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;

class DownloadImage extends AsyncTask<String,String, Bitmap> {
    ImageView imageView;
    public DownloadImage(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected Bitmap doInBackground(String... URL) {
        String imageURL = URL[0];
        Bitmap bitmap = null;
        try {
            // Download Image from URL
            InputStream input = new java.net.URL(imageURL).openStream();
            // Decode Bitmap
            bitmap = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    @Override
    protected void onPostExecute(Bitmap result) {
        // Set the bitmap into ImageView
        imageView.setImageBitmap(result);
        // Close progressdialog

    }
}