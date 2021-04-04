package kr.ac.kpu.game.s2015182003.samplegame;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class GameView extends View
{
    private static final String TAG = GameView.class.getSimpleName();
    public static final int BALL_COUNT = 10;

    Player player;
    //ArrayList<Ball> balls = new ArrayList<>();
    ArrayList<GameObject> objects = new ArrayList<>();
    private Object b1;
    private Object b2;

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
        for(GameObject o: objects)
        {
            o.update();
        }
     //   b1.update();
     //   b2.update();

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
        player = new Player(100, 100, 0, 0);
        Random rand = new Random();
        for(int i = 0; i < BALL_COUNT; ++i)
        {
            float x = rand.nextInt(1000);
            float y = rand.nextInt(1000);
            float dx = rand.nextFloat() * 1000 - 500;
            float dy = rand.nextFloat() * 1000 - 500;
            Ball b = new Ball(x, y, dx, dy);
            objects.add(b);
        }
        objects.add(player);
        //b1 = new Ball(100, 100, 100, 200);
        //b2 = new Ball(900, 100, -50, 150);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        for(GameObject o: objects)
        {
            o.draw(canvas);
        }
        player.draw(canvas);
        //b1.draw(canvas);
        //b2.draw(canvas);
        //canvas.drawBitmap(bitmap, b1.x, b1.y,null);
        //canvas.drawBitmap(bitmap, b2.x, b2.y,null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE)
        {
            player.moveTo(event.getX(), event.getY());
            return true;
        }
        return false;
    }
}
