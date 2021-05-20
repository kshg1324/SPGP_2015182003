package kr.ac.kpu.game.s2015182003.termproject;

public class Balls {
    private  static final int[] RESOURCE_IDS = {
            R.mipmap.red_ball,R.mipmap.blue_ball,R.mipmap.green_ball,R.mipmap.yellow_ball,
    };

    public void init(){
        int randomNum = (int)(Math.random() * 4);
        int resId = RESOURCE_IDS[randomNum];
    }
}
