package kr.ac.kpu.game.s2015182003.termproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.ac.kpu.game.s2015182003.termproject.R;

public class MemuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memu);

        Button button_1 = (Button) findViewById(R.id.button1);
        Button button_2 = (Button) findViewById(R.id.button2);

        button_1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                startActivity(intent);
            }

        });

        button_2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), RankingActivity.class);
                startActivity(intent);
            }

        });

    }
}