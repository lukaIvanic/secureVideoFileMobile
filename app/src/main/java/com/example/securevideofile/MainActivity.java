package com.example.securevideofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonCreate;
    Button buttonRead;
    Button buttonUpdate;
    Button buttonDelete;

    EditText createEditText;
    EditText updateEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCreate = findViewById(R.id.buttonCreate);
        buttonRead = findViewById(R.id.buttonRead);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);

        createEditText = findViewById(R.id.createEditText);
        updateEditText = findViewById(R.id.createEditText);

        buttonCreate.setOnClickListener(v -> {

            String createInput = createEditText.getText().toString();
            handleCreateClick(createInput);
        });

        buttonRead.setOnClickListener(v -> {

            handleReadClick();
        });

        buttonUpdate.setOnClickListener(v -> {
            String updateInput = updateEditText.getText().toString();
            handleUpdateClick(updateInput);
        });

        buttonDelete.setOnClickListener(v -> {
            handleDeleteClick();
        });



    }

    void handleCreateClick(String createInput){
        printMessage("Creating todo, " + createInput);
    }


    void handleReadClick(){
        printMessage("Reading todos");

        new NetworkManager.getTodosAsyncTask().execute(NetworkManager.GET_TODOS_PATH);
    }


    void handleUpdateClick(String updateInput){
        printMessage("Update todo, " + updateInput);

    }


    void handleDeleteClick(){
        printMessage("Delete todo");

    }


    void printMessage(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }


}