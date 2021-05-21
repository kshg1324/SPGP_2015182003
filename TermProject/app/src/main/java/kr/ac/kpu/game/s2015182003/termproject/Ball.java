package kr.ac.kpu.game.s2015182003.termproject;

import android.graphics.Canvas;

public class Ball implements GameObject{

    private  static final int[] RESOURCE_IDS = {
            R.mipmap.red_ball,R.mipmap.blue_ball,R.mipmap.green_ball,R.mipmap.yellow_ball,
    };
    private float time;

    private GameBitmap bitmap;
    private float x;
    private float y;
    private int type;

    public Ball() {
    }

    public static Ball get(int type, int x, int y) {
        MainGame game = MainGame.get();
        Ball ball = (Ball) game.get(Ball.class);
        if (ball == null) {
            ball = new Ball();
        }
        ball.init(type, x, y);
        return ball;
    }
    public void init(int type, int x, int y){
        this.x = x;
        this.y = y;
        this.type = type;
    }

    @Override
    public void update() {
        MainGame game = MainGame.get();
    }



    @Override
    public void draw(Canvas canvas) {
        bitmap.draw(canvas, x, y);
    }
}
