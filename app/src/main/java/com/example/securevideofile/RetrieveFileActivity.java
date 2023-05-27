package com.example.securevideofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RetrieveFileActivity extends AppCompatActivity {


    EditText editTextEncryptPassword;
    EditText editTextVideoName;

    Button buttonRetrieveFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_file);


        editTextEncryptPassword = findViewById(R.id.decryptPasswordText);
        editTextVideoName = findViewById(R.id.videoNameText);
        buttonRetrieveFile = findViewById(R.id.buttonRetrieveFile);

        buttonRetrieveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleRetrieveFileClick();
            }
        });


    }

    void handleRetrieveFileClick(){

        String decryptPassword = editTextEncryptPassword.getText().toString();
        String videoName = editTextVideoName.getText().toString();


        callNetworkToRetrieveFile(decryptPassword, videoName);
    }

    /**
     * Make a call to a business class.
     * @param decryptPassword
     * @param videoName
     */
    void callNetworkToRetrieveFile(String decryptPassword, String videoName){

    }

}