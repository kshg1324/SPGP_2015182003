package kr.ac.kpu.game.s2015182003.samplegame.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import kr.ac.kpu.game.s2015182003.samplegame.R;
import kr.ac.kpu.game.s2015182003.samplegame.framework.GameObject;
import kr.ac.kpu.game.s2015182003.samplegame.ui.view.GameView;

public class Bullet implements GameObject {
    private static int imagewidth;
    private static int imageheight;
    private final float radius;
    private float x, y;
    private float dx, dy;

    Paint paint = new Paint();
    public Bullet(float x, float y, float tx, float ty)
    {
        this.x = x;
        this.y = y;
        this.radius = 10.0f;
        float delta_x = tx - this.x;
        float delta_y = ty - this.y;
        float angle = (float)Math.atan2(delta_y, delta_x);
        float move_dist = 1000;
        this.dx = (float) (move_dist * Math.cos(angle));
        this.dy = (float) (move_dist * Math.sin(angle));

        paint.setColor(0xFFFF0000);
    }

    public void update()
    {
        MainGame game = MainGame.get();

        this.x += this.dx * game.frameTime;
        this.y += this.dy * game.frameTime;
        int w = GameView.view.getWidth();
        int h = GameView.view.getHeight();
        boolean toBeDeleted = false;
        if(x < 0 || x > w - imagewidth)
        {
            toBeDeleted = true;
        }

        if(y < 0 || y > h - imageheight)
        {
            toBeDeleted = true;
        }
        if(toBeDeleted)
        {
            game.remove(this);
        }
    }

    public void draw(Canvas canvas)
    {
        canvas.drawCircle(x, y, radius, paint);
    }
}
