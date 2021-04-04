package kr.ac.kpu.game.s2015182003.samplegame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Ball implements GameObject {
    private static int imagewidth;
    private static int imageheight;
    private float x, y;
    private float dx, dy;
    private static Bitmap bitmap;

    public Ball(float x, float y, float dx, float dy)
    {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        if(bitmap == null) {
            Resources res = GameView.view.getResources();
            bitmap = BitmapFactory.decodeResource(res, R.mipmap.soccer_ball_240);
            imagewidth = bitmap.getWidth();
            imageheight = bitmap.getHeight();
        }
    }

    public void update()
    {
        this.x += this.dx * GameView.frameTime;
        this.y += this.dy * GameView.frameTime;
        int w = GameView.view.getWidth();
        int h = GameView.view.getHeight();
        if(x < 0 || x > w - imagewidth)
        {
            dx *= -1;
        }

        if(y < 0 || y > h - imageheight)
        {
            dy *= -1;
        }
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap, this.x, this.y, null);
    }
}
