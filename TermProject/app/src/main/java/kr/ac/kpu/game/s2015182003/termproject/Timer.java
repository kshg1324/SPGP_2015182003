package kr.ac.kpu.game.s2015182003.termproject;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import kr.ac.kpu.game.s2015182003.termproject.activity.PlayActivity;
import kr.ac.kpu.game.s2015182003.termproject.activity.MemuActivity;

public class Timer implements GameObject {
    private final Bitmap bitmap;
    private final int right;
    private final int top;
    private PlayActivity playactivity;

    public void setTimer(int timer) {
        this.timer = timer;
        this.displayTimer = timer;
    }

    public int showTimer() {
        return timer;
    }

    public void tickTimer(int amount) {
        this.timer -= amount;
    }

    private int timer, displayTimer;
    private Rect src = new Rect();
    private RectF dst = new RectF();

    public Timer(int right, int top) {
        bitmap = GameBitmap.load(R.mipmap.timer_24x32);
        this.right = right;
        this.top = top;
    }
    @Override
    public void update() {
        MainGame game = MainGame.get();
        if (displayTimer > timer) {
            displayTimer--;
        }

        if(timer == 0){
            playactivity = new PlayActivity();
            playactivity.startGame();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        int value = this.displayTimer;
        int nw = bitmap.getWidth() / 10;
        int nh = bitmap.getHeight();
        int x = right;
        int dw = (int) (nw * GameView.MULTIPLIER);
        int dh = (int) (nh * GameView.MULTIPLIER);
        while (value > 0) {
            int digit = value % 10;
            src.set(digit * nw, 0, (digit + 1) * nw, nh);
            x -= dw;
            dst.set(x, top, x + dw, top + dh);
            canvas.drawBitmap(bitmap, src, dst, null);
            value /= 10;
        }
    }



}
