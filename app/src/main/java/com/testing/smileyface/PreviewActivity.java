package com.testing.smileyface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class PreviewActivity extends AppCompatActivity {

    private ImageView previewImage;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        previewImage = findViewById(R.id.Preview_Image);

        if (getIntent().hasExtra("BitmapImage")) {
            File myFile = new File(getIntent().getStringExtra("BitmapImage"));

            Bitmap myBitmap = BitmapFactory.decodeFile(myFile.getAbsolutePath());

            previewImage.setImageBitmap(myBitmap);
        }
    }
}