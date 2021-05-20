package kr.ac.kpu.game.s2015182003.termproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import kr.ac.kpu.game.s2015182003.termproject.GameObject;

public class Background implements GameObject {
    private final Bitmap bitmap;
    private float scroll;

    private Rect srcRect = new Rect();
    private RectF dstRect = new RectF();

    public Background(int resId){
        bitmap = GameBitmap.load(resId);
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        srcRect.set(0, 0, w, h);
        float l = 0;
        float t = 0;
        float b = GameView.view.getHeight();
        float r = b*w/h;

        dstRect.set(l,t,r,b);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Canvas canvas) {
        int vw = GameView.view.getWidth();
        int vh = GameView.view.getHeight();
        int iw = bitmap.getWidth();
        int ih = bitmap.getHeight();
        int dw = vh * iw / ih;
        int curr = (int)scroll % dw;
        if (curr>0) curr -= dw;

        while (curr < vh){
            dstRect.set(0, 0, iw, ih);
            canvas.drawBitmap(bitmap, srcRect, dstRect, null);
            curr += dw;
        }
    }
}