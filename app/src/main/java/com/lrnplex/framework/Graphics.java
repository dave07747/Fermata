package com.lrnplex.framework;

import com.lrnplex.fermata.Arc;

/**
 * Created by David on 6/23/2016.
 */
public interface Graphics {
    enum PixmapFormat{
        ARGB8888, ARGB4444, RGB565
    }

    Pixmap newPixmap(String fileName, PixmapFormat format);

    void clear(int color);

   // void drawCircle(int cx, int cy, int radius, int color);

    //void drawArc(int x, int y, int x1, int y1, int radius, int sweepAngle, boolean useCenter, int color);

    void drawPixel(int x, int y, int color);

    void drawLine(int x, int y, int x2, int y2, int color);

    void drawRect(int x, int y, int width, int height, int color);

    void drawArc(int x, int y, int width, int height, int startAngle, int sweepAngle, int color);

    void drawArc(Arc arc);

    //void drawArc(Arc arc, int x, int y, int width, int height);

    void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight);

    void drawPixmap(Pixmap pixmap, int x, int y);

    int getWidth();

    int getHeight();
}
