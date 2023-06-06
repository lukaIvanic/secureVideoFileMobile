package com.example.securevideofile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button buttonListOfFilesActivity;
    Button buttonGotoRetrieveFile;
    Button buttonGotoUploadFile;
    Button buttonHelloTest;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonListOfFilesActivity = findViewById(R.id.buttonListOfFilesActivity);
        buttonGotoRetrieveFile = findViewById(R.id.buttonGotoRetrieveFile);
        buttonGotoUploadFile = findViewById(R.id.buttonGotoUploadFile);
        buttonHelloTest = findViewById(R.id.buttonHelloTest);


        buttonGotoRetrieveFile.setOnClickListener(v -> {
            gotoRetrieveFileActivity();
        });
        buttonGotoUploadFile.setOnClickListener(v -> {
            gotoUploadFileActivity();
        });

        buttonHelloTest.setOnClickListener(v -> {
            testConnect();
        });
    }

    void handleReadClick(String createInput, String createInput2) {
        printMessage("Reading todos");


    }

    void printMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }


    void gotoRetrieveFileActivity() {
        Intent intent = new Intent(MainActivity.this, RetrieveFileActivity.class);
        startActivity(intent);
    }

    void gotoUploadFileActivity() {
        Intent intent = new Intent(MainActivity.this, UploadFileActivity.class);
        startActivity(intent);
    }

    void testConnect() {
        Toast.makeText(this, "Requesting hello..", Toast.LENGTH_SHORT).show();


    }


}