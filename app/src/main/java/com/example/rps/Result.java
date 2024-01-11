package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    Button btn1;
    TextView gameCt;
    TextView result;
    TextView odds;
    Intent intent;
    int gameCount;
    int loseScore;
    int winScore;
    int tieScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        gameCt = findViewById(R.id.gameCt);
        result = findViewById(R.id.result);
        odds = findViewById(R.id.odds);
        intent = getIntent();
        gameCount = intent.getIntExtra("gameCount", 0);
        loseScore = intent.getIntExtra("loseScore", 0);
        winScore = intent.getIntExtra("winScore", 0);
        tieScore = intent.getIntExtra("tieScore", 0);
        btn1 = findViewById(R.id.goMain);
    }
    protected void onStart(){
        super.onStart();
        String result1;
        result1 = String.valueOf(winScore)+"승 "+String.valueOf(loseScore)+"패 "+String.valueOf(tieScore)+"무";
        float odds1 = Float.valueOf(winScore)/Float.valueOf(gameCount)*100;

        String odds2 = String.format("%.1f", odds1);
        gameCt.setText(String.valueOf(gameCount));
        result.setText(result1);
        odds.setText(odds2);

    }
    protected void onResume(){
        super.onResume();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Result.this, MainActivity.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mainIntent);
                finish();
            }
        });
    }

}