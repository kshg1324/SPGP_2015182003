package kr.ac.kpu.game.s2015182003.termproject;

import android.graphics.Canvas;

import java.util.Random;

public class Balls implements GameObject{

    private  static final int[] RESOURCE_IDS = {
            R.mipmap.red_ball,R.mipmap.blue_ball,R.mipmap.green_ball,R.mipmap.yellow_ball,
    };
    private final float INITIAL_SPAWN_INTERVAL = 2.0f;
    private final float spawnInterval;
    private float time;

    private GameBitmap bitmap;
    private float x;
    private float y;
    private int type;

    public Balls() {
        time = INITIAL_SPAWN_INTERVAL;
        spawnInterval = INITIAL_SPAWN_INTERVAL;
    }

    public static Balls get(int type, int x, int y) {
        MainGame game = MainGame.get();
        Balls ball = (Balls) game.get(Balls.class);
        if (ball == null) {
            ball = new Balls();
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
        time += game.frameTime;
        if (time >= spawnInterval) {
            generate();
            time -= spawnInterval;
        }
    }

    private void generate() {
        MainGame game = MainGame.get();
        int random_type = (int)(Math.random() * 4);
        int random_x = (int)((Math.random() * GameView.view.getWidth() / 10 * 2) + (GameView.view.getWidth() / 10 * 4));
        int random_y = (int)((Math.random() * GameView.view.getHeight() / 10 * 2) + (GameView.view.getHeight() / 10 * 4));
        int x = random_x;
        int y = random_y;
        int type = random_type;
        Balls ball = Balls.get(type, x, y);
        game.add(MainGame.Layer.ball, ball);

    }

    @Override
    public void draw(Canvas canvas) {
        bitmap.draw(canvas, x, y);
    }
}
