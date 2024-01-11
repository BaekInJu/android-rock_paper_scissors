package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Button button = findViewById(R.id.btn);
        EditText userName = findViewById(R.id.userId);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String name = userName.getText().toString();
                Intent intent = new Intent(MainActivity.this, Play.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}