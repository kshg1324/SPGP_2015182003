package kr.ac.kpu.game.s2015182003.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mainTextView;
    private ImageView mainImageView;
    private int pageIndex;
    private static int[] resIds = {
            R.mipmap.cat1,
            R.mipmap.cat2,
            R.mipmap.cat3,
            R.mipmap.cat4,
            R.mipmap.cat5,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageIndex = 0;

        mainTextView = findViewById(R.id.mainTextView);

        mainImageView = findViewById(R.id.mainImageView);
        showImage();
//        Button helloButton = findViewById(R.id.helloButton);
//        helloButton.setOnClickListener(this);
//
//        Button worldButton = findViewById(R.id.worldButton);
//        worldButton.setOnClickListener(this);
    }

    public void onBtnPrev(View view) {
        if(pageIndex == 0)
        {
            return;
        }

        pageIndex--;
        showImage();
    }

    public void onBtnNext(View view) {
        if(pageIndex == resIds.length - 1)
        {
            return;
        }

        pageIndex++;
        showImage();
    }

    private void showImage() {
        mainTextView.setText((pageIndex + 1) + " / " + resIds.length);
        int resId = resIds[pageIndex];
        mainImageView.setImageResource(resId);
    }
}









