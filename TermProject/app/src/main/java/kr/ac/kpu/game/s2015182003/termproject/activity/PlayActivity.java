package kr.ac.kpu.game.s2015182003.termproject.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;


import java.util.ArrayList;
import java.util.Random;

import kr.ac.kpu.game.s2015182003.termproject.GameObject;
import kr.ac.kpu.game.s2015182003.termproject.GameView;
import kr.ac.kpu.game.s2015182003.termproject.MainGame;
import kr.ac.kpu.game.s2015182003.termproject.R;

public class PlayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }

    public void askRestart() {
        String title = "restart";
        String message = "do you want restart?";
        String yes = "yes";
        String no = "no";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startGame();
            }
        });
        builder.setNegativeButton(no, null);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void startGame() {
        MainGame game = MainGame.get();
        game.timer.setTimer(60);
        game.score.setScore(0);

    }
}