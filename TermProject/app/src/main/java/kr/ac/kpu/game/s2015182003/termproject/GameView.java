package kr.ac.kpu.game.s2015182003.termproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;


public class GameView extends View {
    public static GameView view;
    public Paint paint = new Paint();
    public Rect rect = new Rect();

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        GameView.view = this;
        paint.setColor(0xff0044ff);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        int l = 0 + getPaddingLeft();
        int t = 0 + getPaddingTop();
        int w = getWidth() - getPaddingRight();
        int h = getHeight() - getPaddingBottom();
        rect.set(l, t, w, h);
        canvas.drawRect(rect, paint);
    }
}
