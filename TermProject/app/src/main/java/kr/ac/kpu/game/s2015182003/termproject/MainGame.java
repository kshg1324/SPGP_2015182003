package kr.ac.kpu.game.s2015182003.termproject;

import android.graphics.Canvas;

import java.util.ArrayList;

import kr.ac.kpu.game.s2015182003.termproject.GameView;

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

    public GameObject get(Class<Balls> ballsClass) {
        return null;
    }

    public void update() {
        for (ArrayList<GameObject> objects : layers) {
            for (GameObject o : objects) {
                o.update();
            }
        }

        ArrayList<GameObject> balls = layers.get(Layer.ball.ordinal());
        for (GameObject o1 : balls) {
            Balls enemy = (Balls) o1;
        }
    }
    public enum Layer{
        ball;
    }

//    public boolean initResources() {
//        if (initialized) {
//            return false;
//        }
//
//        initialized = true;
//        return true;
//    }

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
