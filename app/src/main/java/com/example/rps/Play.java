package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class Play extends AppCompatActivity {
    int gameCount = 0;
    int winScore = 0;
    int tieScore = 0;
    int loseScore = 0;
    TextView text1;
    TextView text2;
    TextView name;
    Button btnRock;
    Button btnScissor;
    Button btnPaper;
    ImageView userImg;
    ImageView compImg;
    String result;
    int score = 0;
    Intent intent;
    ImageButton setting1;
    Button endGame;

    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        text1 = findViewById(R.id.score);
        text2 = findViewById(R.id.gameCount);
        btnRock = findViewById(R.id.rock);
        btnScissor = findViewById(R.id.scissor);
        btnPaper = findViewById(R.id.paper);
        userImg = findViewById(R.id.userImg);
        compImg = findViewById(R.id.compImg);
        name = findViewById(R.id.userName);
        intent = getIntent();
        String userName = intent.getStringExtra("name");
        name.setText(userName);
        setting1 = findViewById(R.id.setting2);
        endGame = findViewById(R.id.endGame);
    }
    @Override
    protected void onStart() {
        super.onStart();
        text2.setText(String.valueOf(gameCount));
    }
    public void comp_num(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        num = random.nextInt(3);
    }
    @Override
    protected void onResume() {
        super.onResume();
        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImg.setImageResource(R.drawable.rock_rev);
                comp_num();
                if(num==0){
                    compImg.setImageResource(R.drawable.rock);
                    result = "tie";
                    tieScore++;
                }
                if(num==1){
                    compImg.setImageResource(R.drawable.paper);
                    result = "lose";
                    score -= 10;
                    loseScore++;
                }
                if(num==2){
                    compImg.setImageResource(R.drawable.scissor);
                    result = "win";
                    score +=10;
                    winScore++;
                }
                gameCount+=1;
                text2.setText(String.valueOf(gameCount));
                text1.setText(String.valueOf(score));
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImg.setImageResource(R.drawable.paper_rev);
                comp_num();
                if(num==0){
                    compImg.setImageResource(R.drawable.rock);
                    result = "win";
                    score += 10;
                    winScore++;
                }
                if(num==1){
                    compImg.setImageResource(R.drawable.paper);
                    result = "tie";
                    tieScore++;
                }
                if(num==2){
                    compImg.setImageResource(R.drawable.scissor);
                    result = "lose";
                    score -= 10;
                    loseScore++;
                }
                gameCount+=1;
                text2.setText(String.valueOf(gameCount));
                text1.setText(String.valueOf(score));
            }
        });
        btnScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImg.setImageResource(R.drawable.scissor_rev);
                comp_num();
                if(num==0){
                    compImg.setImageResource(R.drawable.rock);
                    result = "lose";
                    score -= 10;
                    loseScore++;
                }
                if(num==1){
                    compImg.setImageResource(R.drawable.paper);
                    result = "win";
                    score += 10;
                    winScore++;
                }
                if(num==2){
                    compImg.setImageResource(R.drawable.scissor);
                    result = "tie";
                    tieScore++;
                }
                gameCount+=1;
                text2.setText(String.valueOf(gameCount));
                text1.setText(String.valueOf(score));
            }
        });
        setting1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                //여기에 이어서 작성
                //부분화면 표시
                //계속하기
                //처음화면
                //게임종료
                finish();
            }
        });
        endGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Play.this, Result.class);
                intent.putExtra("gameCount",gameCount);
                intent.putExtra("winScore", winScore);
                intent.putExtra("loseScore", loseScore);
                intent.putExtra("tieScore",tieScore);
                startActivity(intent);
            }
        });
    }
}