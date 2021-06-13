package kr.ac.kpu.game.s2015182003.termproject;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

public class Ball implements GameObject{
    private static final String TAG = MainGame.class.getSimpleName();

    public static final int[] RESOURCE_IDS = {
            R.mipmap.red_ball,R.mipmap.blue_ball,R.mipmap.purple_ball,R.mipmap.yellow_ball,
    };
    private float time;

    private GameBitmap bitmap;
    private float x;
    private float y;
    private int type;
    public float speed_x;
    public float speed_y;

    public Score score;

    public Ball(int type, float x, float y, float speed_x, float speed_y) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.speed_x = speed_x;
        this.speed_y = speed_y;

        if(type == 0){
            this.bitmap = new GameBitmap(R.mipmap.red_ball);
        }
        else if(type == 1){
            this.bitmap = new GameBitmap(R.mipmap.blue_ball);
        }
        else if(type == 2){
            this.bitmap = new GameBitmap(R.mipmap.purple_ball);
        }
        else if(type == 3){
            this.bitmap = new GameBitmap(R.mipmap.yellow_ball);
        }
    }

    public static Ball get(int type, float x, float y, float speed_x, float speed_y) {
        MainGame game = MainGame.get();
        Ball ball = (Ball) game.get(Ball.class);
        if (ball == null) {
            return new Ball(type, x, y, speed_x, speed_y);
        }
        ball.init(type, x, y, speed_x, speed_y);
        return ball;
    }

    public void init(int type, float x, float y, float speed_x, float speed_y){
        this.x = x;
        this.y = y;
        this.type = type;
        this.speed_x = speed_x;
        this.speed_y = speed_y;
    }

    @Override
    public void update() {
        MainGame game = MainGame.get();

        if((game.touch_x != 0 && game.touch_y != 0)) {
            if ((game.touch_x > x - 100 && game.touch_x < x + 100) && (game.touch_y > y - 100 && game.touch_y < y + 100)) {
                speed_x = 0;
                speed_y = 0;

                x = game.touch_x;
                y = game.touch_y;
                game.touch_x = 0;
                game.touch_y = 0;

                if ((game.touch_up_x != 0)) {
                    speed_x = ((game.touch_up_x - game.touch_down_x));

                    game.touch_down_x = 0;
                    game.touch_up_x = 0;
                }
                if ((game.touch_up_y != 0)) {
                    speed_y = ((game.touch_up_y - game.touch_down_y));

                    game.touch_down_y = 0;
                    game.touch_up_y = 0;
                }
            }
//            else {
//                game.touch_up_x = 0;
//                game.touch_down_x = 0;
//                game.touch_up_y = 0;
//                game.touch_down_y = 0;
//            }
        }


        if(speed_x > 0)
        {
            x += speed_x * game.frameTime;
            //speed_x -= 1;
        }
        else if(speed_x < 0)
        {
            x += speed_x * game.frameTime;
            //speed_x += 1;
        }
        if(speed_y > 0)
        {
            y += speed_y * game.frameTime;
            //speed_y -= 1;
        }
        else if(speed_y < 0)
        {
            y += speed_y * game.frameTime;
            //speed_y += 1;
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


            if(type == 0) {
                if (y > GameView.view.getHeight()) {
                    Log.d(TAG, "Red ball goal");
                    game.remove(this);
                    //score.addScore(10);
                    game.addscore_count += 1;
                } else if (y < 0 || x > GameView.view.getWidth() || x < 0) {
                    Log.d(TAG, "Red ball out");
                    game.remove(this);
                    speed_x = 0;
                    speed_y = 0;
                }
            }
            else if(type == 1) {
                if (y < 0) {
                    Log.d(TAG, "Blue ball goal");
                    game.remove(this);
                    //score.addScore(10);
                    game.addscore_count += 1;
                } else if (y > GameView.view.getHeight() || x > GameView.view.getWidth() || x < 0) {
                    Log.d(TAG, "Blue ball out");
                    game.remove(this);
                }
            }
            else if(type == 2) {
                if (x > GameView.view.getWidth()) {
                    Log.d(TAG, "Purple ball goal");
                    game.remove(this);
                    //score.addScore(10);
                    game.addscore_count += 1;
                } else if (y > GameView.view.getHeight() || y < 0 || x < 0) {
                    Log.d(TAG, "Purple ball out");
                    game.remove(this);
                }
            }
            else if(type == 3) {
                if (x < 0) {
                    Log.d(TAG, "Yellow ball goal");
                    game.remove(this);
                    //score.addScore(10);
                    game.addscore_count += 1;
                } else if (y > GameView.view.getHeight() || y < 0 || x > GameView.view.getWidth()) {
                    Log.d(TAG, "Yellow ball out");
                    game.remove(this);
                }
            }



    }



    @Override
    public void draw(Canvas canvas) {
        bitmap.draw(canvas, x, y);
    }
}
