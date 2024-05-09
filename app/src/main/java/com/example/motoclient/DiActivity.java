package com.example.motoclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.motoclient.di.DaggerMyComponent;
import com.example.motoclient.di.MyComponent;
import com.example.motoclient.di.SharedPrefModule;

import javax.inject.Inject;

//CONSUMER
public class DiActivity extends AppCompatActivity {

    @Inject
    SharedPreferences sharedPreferences;

    //im not going instantiate  sharedprefs instead sharedprefmodule will provide the instance
    private MyComponent myComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di);
        myComponent = DaggerMyComponent.builder()
                .sharedPrefModule(new SharedPrefModule(this))
                .build();
        myComponent.inject(this);


        Button saveButton = findViewById(R.id.btnSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    private void saveData() {
        EditText nameEditText = findViewById(R.id.inUsername);
        EditText phnoText = findViewById(R.id.inNumber);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("un",nameEditText.getText().toString());
        editor.putString("no",phnoText.getText().toString());
        editor.apply();

    }
}