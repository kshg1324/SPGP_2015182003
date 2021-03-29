package kr.ac.kpu.game.s2015182003.samplegame;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View
{
    private static final String TAG = GameView.class.getSimpleName();
    private Bitmap bitmap;

    private float x = 0;
    private float y = 0;

    public GameView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initResource();
        StartUpdating();
    }

    private void StartUpdating()
    {
        doGameFrame();
    }


    private void doGameFrame()
    {
        x += 1;
        y += 2;

        invalidate();

        postDelayed(new Runnable() {
            @Override
            public void run() {
                doGameFrame();
            }
        }, 15);
    }
    private void initResource() {
        Resources res = getResources();
        bitmap = BitmapFactory.decodeResource(res, R.mipmap.soccer_ball_240);
        x = 100;
        y = 100;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap, x, y,null);
        Log.d(TAG, "Drawing at " + x + ", " + y);
    }
}
