package kr.ac.kpu.game.s2015182003.termproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;


public class GameView extends View {
    public static GameView view;
    public Paint paint = new Paint();
    public Rect rect = new Rect();
    public static float MULTIPLIER = 2;

    LinearLayout layout;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        GameView.view = this;
    }
}
