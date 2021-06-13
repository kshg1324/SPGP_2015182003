package kr.ac.kpu.game.s2015182003.termproject;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

public class Ball implements GameObject{

    public static final int[] RESOURCE_IDS = {
            R.mipmap.red_ball,R.mipmap.blue_ball,R.mipmap.green_ball,R.mipmap.yellow_ball,
    };
    private float time;

    private GameBitmap bitmap;
    private float x;
    private float y;
    private int type;

    public Ball(int type, float x, float y) {
        this.x = x;
        this.y = y;
        this.type = type;

        if(type == 0){
            this.bitmap = new GameBitmap(R.mipmap.red_ball);
        }
        else if(type == 1){
            this.bitmap = new GameBitmap(R.mipmap.blue_ball);
        }
        else if(type == 2){
            this.bitmap = new GameBitmap(R.mipmap.green_ball);
        }
        else if(type == 3){
            this.bitmap = new GameBitmap(R.mipmap.yellow_ball);
        }
    }

    public static Ball get(int type, float x, float y) {
        MainGame game = MainGame.get();
        Ball ball = (Ball) game.get(Ball.class);
        if (ball == null) {
            return new Ball(type, x, y);
        }
        ball.init(type, x, y);
        return ball;
    }

    public void init(int type, float x, float y){
        this.x = x;
        this.y = y;
        this.type = type;
    }

    @Override
    public void update() {
        MainGame game = MainGame.get();
        if(game.touch_x != 0 && game.touch_y != 0) {
            if((game.touch_x > x - 100 && game.touch_x < x + 100) && (game.touch_y > y - 100 && game.touch_y < y + 100)) {
                x = game.touch_x;
                y = game.touch_y;
                game.touch_x = 0;
                game.touch_y = 0;
            }
        }


//        if(type == 0)
//        {
//            y += 100 * game.frameTime;
//        }
//        else if(type == 1)
//        {
//            y -= 100 * game.frameTime;
//        }
//        else if(type == 2)
//        {
//            x += 100 * game.frameTime;
//        }
//        else if(type == 3)
//        {
//            x -= 100 * game.frameTime;
//        }
//        switch (type)
//        {
//            case 0:
//                y += 100 * game.frameTime;
//            case 1:
//                y -= 100 * game.frameTime;
//            default:
//                y += 100 * game.frameTime;
////            case 2:
////                x += 100 * game.frameTime;
////            case 3:
////                x -= 100 * game.frameTime;
//        }

        switch (type)
        {
            case 0:
                if(y > GameView.view.getHeight()){
                    game.remove(this);
                }
            case 1:
                if(y < 0){
                    game.remove(this);
                }
            case 2:
                if(x > GameView.view.getWidth()){
                    game.remove(this);
                }
            case 3:
                if(x < 0){
                    game.remove(this);
                }
        }


    }



    @Override
    public void draw(Canvas canvas) {
        bitmap.draw(canvas, x, y);
    }
}
