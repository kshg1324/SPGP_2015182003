package kr.ac.kpu.game.s2015182003.termproject;

import android.graphics.Canvas;
import android.util.Log;

import java.util.Random;

public class BallGenerator implements GameObject {
    private static final String TAG = MainGame.class.getSimpleName();
    private static final float INITIAL_SPAWN_INTERVAL = 2.0f;
    private float time;
    private float spawnInterval;

    public BallGenerator() {
        time = INITIAL_SPAWN_INTERVAL;
        spawnInterval = INITIAL_SPAWN_INTERVAL;
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

        Ball ball = Ball.get(type, x, y, 0, 0);
        game.add(MainGame.Layer.ball, ball);
    }

    @Override
    public void draw(Canvas canvas) {
        // does nothing
    }
}
