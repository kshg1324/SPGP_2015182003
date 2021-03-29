package kr.ac.kpu.game.s2015182003.customcontrols;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.res.Configuration;
import android.util.Log;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");
//        MyView mv = new MyView(this,);
//        setContentView(mv);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig)
    {
        Log.d(TAG, "onConfigChange:" + newConfig);
        super.onConfigurationChanged(newConfig);
    }
}