package com.testing.smileyface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaScannerConnection;
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

            if(myBitmap.getHeight() < myBitmap.getWidth()) {
                Matrix matrix = new Matrix();

                matrix.postRotate(-90);

                Bitmap scaledBitmap = Bitmap.createScaledBitmap(myBitmap, myBitmap.getWidth(), myBitmap.getHeight(), true);

                myBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);
            }
            previewImage.setImageBitmap(myBitmap);

            MediaScannerConnection.scanFile(this, new String[]{myFile.getPath()}, new String[]{"image/jpeg"}, null);
        }
    }
}