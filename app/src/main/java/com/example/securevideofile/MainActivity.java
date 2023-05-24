package com.example.securevideofile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button buttonListOfFilesActivity;
    Button buttonRetrieveFileActivity;
    Button buttonUploadFileActivity;
    Button buttonRetrieveFile;
    EditText decryptPasswordText;
    EditText videoNameText;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonListOfFilesActivity = findViewById(R.id.buttonListOfFilesActivity);
        buttonRetrieveFileActivity = findViewById(R.id.buttonRetrieveFileActivity);
        buttonUploadFileActivity = findViewById(R.id.buttonUploadFileActivity);

        decryptPasswordText = findViewById(R.id.decryptPasswordText);
        videoNameText = findViewById(R.id.videoNameText);

        buttonRetrieveFileActivity.setOnClickListener(v -> {
            gotoRetrieveFileActivity();
        });
        buttonUploadFileActivity.setOnClickListener(v -> {
            gotoUploadFileActivity();
        });

    }

    void handleReadClick(String createInput, String createInput2){
        printMessage("Reading todos");

        new NetworkManager.getTodosAsyncTask().execute(createInput, createInput2, "POST", "retrieve");

    }

    void printMessage(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }


    void gotoRetrieveFileActivity(){
        Intent intent = new Intent(MainActivity.this, RetrieveFileActivity.class);
        startActivity(intent);
    }

    void gotoUploadFileActivity(){
        Intent intent = new Intent(MainActivity.this, RetrieveFileActivity.class);
        startActivity(intent);
    }




}