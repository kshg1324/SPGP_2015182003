package kr.ac.kpu.game.s2015182003.termproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;


public class GameView extends View {
    public static GameView view;
    public Paint paint = new Paint();
    public Rect rect = new Rect();
    public static float MULTIPLIER = 2;

    LinearLayout layout;
    private long lastFrame;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        GameView.view = this;
    }

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        //super.onSizeChanged(w, h, oldw, oldh);
//        MainGame game = MainGame.get();
//        boolean justInitialized = game.initResources();
//        if (justInitialized) {
//            requestCallback();
//        }
//    }

    private void update() {
        MainGame game = MainGame.get();
        game.update();

        invalidate();
    }

    private void requestCallback() {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long time) {
                if (lastFrame == 0) {
                    lastFrame = time;
                }
                MainGame game = MainGame.get();
                game.frameTime = (float) (time - lastFrame) / 1_000_000_000;
                update();
                lastFrame = time;
                requestCallback();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        MainGame game = MainGame.get();
        game.draw(canvas);
    }

}
