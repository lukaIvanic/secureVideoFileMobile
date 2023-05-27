package com.example.securevideofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UploadFileActivity extends AppCompatActivity {

    Button buttonUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_file);

        buttonUpload = findViewById(R.id.buttonUpload);

        buttonUpload.setOnClickListener(view -> {
            handleUploadClick();
        });


    }

    void handleUploadClick(){

    }

}