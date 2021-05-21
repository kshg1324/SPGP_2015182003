package kr.ac.kpu.game.s2015182003.termproject;

import android.graphics.Canvas;

import java.util.ArrayList;

public class MainGame {

    private static MainGame instance;
    public float frameTime;
    private boolean initialized;

    public static MainGame get() {
        if (instance == null) {
            instance = new MainGame();
        }
        return instance;
    }

    ArrayList<ArrayList<GameObject>> layers = new ArrayList<>();

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

    public void add(Layer layer, GameObject gameObject) {
        GameView.view.post(new Runnable() {
            @Override
            public void run() {
                ArrayList<GameObject> objects = layers.get(layer.ordinal());
                objects.add(gameObject);
            }
        });
    }
}
