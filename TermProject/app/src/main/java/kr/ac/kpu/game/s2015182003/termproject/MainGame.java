package kr.ac.kpu.game.s2015182003.termproject;

import android.graphics.Canvas;
import android.nfc.Tag;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;

public class MainGame {
    private static final String TAG = MainGame.class.getSimpleName();

    private static MainGame instance;
    public float frameTime;
    private boolean initialized;

    public static MainGame get() {
        if (instance == null) {
            instance = new MainGame();
        }
        return instance;
    }

    ArrayList<ArrayList<GameObject>> layers;

    public GameObject get(Class<Ball> ballsClass) {
        return null;
    }

    private void initLayers(int layerCount) {
        layers = new ArrayList<>();
        for(int i = 0; i < layerCount; ++i) {
            layers.add(new ArrayList<>());
        }
    }

    public void update() {
        for (ArrayList<GameObject> objects : layers) {
            for (GameObject o : objects) {
                o.update();
            }
        }

    }
    public enum Layer{
        ball,controller,ENEMY_COUNT;
    }

    public boolean initResources() {
        if (initialized) {
            return false;
        }

        initLayers(Layer.ENEMY_COUNT.ordinal());
        add(Layer.controller, new BallGenerator());
        initialized = true;
        return true;
    }

    public void draw(Canvas canvas){
        for(ArrayList<GameObject> objects: layers){
            for (GameObject o: objects) {
                o.draw(canvas);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "ACTION_DOWN: " + event.getRawX() + event.getRawY());
                return true;

            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "ACTION_MOVE: ");
                return true;

            case MotionEvent.ACTION_UP:
                Log.d(TAG, "ACTION_UP: ");
                return false;
        }
        return false;
    }

    public void add(Layer layer, GameObject gameObject) {
        GameView.view.post(new Runnable() {
            @Override
            public void run() {
                ArrayList<GameObject> objects = layers.get(layer.ordinal());
                objects.add(gameObject);
            }
        });
    }

    public void remove(GameObject gameObject) {
        remove(gameObject, true);
    }

    public void remove(GameObject gameObject, boolean delayed) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (ArrayList<GameObject> objects: layers) {
                    boolean removed = objects.remove(gameObject);
                }
            }
        };
        if (delayed) {
            GameView.view.post(runnable);
        } else {
            runnable.run();
        }
    }


}
