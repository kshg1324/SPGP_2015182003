package kr.ac.kpu.game.s2015182003.customcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        MyView mv = new MyView(this);
        setContentView(mv);
    }
}