package kr.ac.kpu.game.s2015182003.samplegame;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;

import androidx.annotation.Nullable;

import java.sql.Time;

public class GameView extends View
{
    private static final String TAG = GameView.class.getSimpleName();

    private Ball b1;
    private Ball b2;

    private long lastFrame;
    public static float frameTime;
    public static GameView view;

    public GameView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        GameView.view = this;
        initResource();
        StartUpdating();
    }

    private void StartUpdating()
    {
        doGameFrame();
    }


    private void doGameFrame()
    {
        b1.update();
        b2.update();

     //   b1.x += b1.dx * frameTime;
     //   b1.y += b1.dy * frameTime;

     //   b2.x += b2.x * frameTime;
     //   b2.y += b2.y * frameTime;
        invalidate();

        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long time) {

                if(lastFrame == 0)
                {
                    lastFrame = time;
                }
                frameTime = (float) (time - lastFrame) / 1_000_000_000;
                doGameFrame();
                lastFrame = time;
            }
        });
    }
    private void initResource() {
        b1 = new Ball(100, 100, 100, 200);
        b2 = new Ball(900, 100, -50, 150);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        b1.draw(canvas);
        b2.draw(canvas);
        //canvas.drawBitmap(bitmap, b1.x, b1.y,null);
        //canvas.drawBitmap(bitmap, b2.x, b2.y,null);

    }
}
