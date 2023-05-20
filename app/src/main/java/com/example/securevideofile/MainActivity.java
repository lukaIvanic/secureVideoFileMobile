package com.example.securevideofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.net.Authenticator;

public class MainActivity extends AppCompatActivity {

    Button buttonFilip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFilip = findViewById(R.id.buttonFilip);

        buttonFilip.setOnClickListener(v -> {
            handleFilipButtonClick();
        });


    }

    void handleFilipButtonClick(){
        new NetworkManager.getTodosAsyncTask().execute(NetworkManager.GET_TODOS_PATH);
    }


}