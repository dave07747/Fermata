package com.lrnplex.fermata;

/**
 * Created by David on 7/6/2016.
 */
public class Arc {
    private float x;
    private float y;
    private float width;
    private float height;
    private int color;
    private float startAngle;
    private float sweepAngle;
    public float scalar = 8;
    private int colorChoice;

    private float trueX;
    private float trueY;
    private float a;
    private float b;

    public Arc(float x, float y, float width, float height, float startAngle, float sweepAngle, int choice){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.colorChoice = choice;
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
        setColor();

        this.trueX = x+(width/2);
        this.trueY = y+(height/2);
        this.a = width/2;
        this.b = height/2;
    }

    public void moveArc(){
        x-=1;
    }

    public float getStartAngle() {
        return startAngle;
    }

    public float getSweepAngle() {
        return sweepAngle;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public int getColor() {
        return color;
    }

    public void setColor(){
        switch (colorChoice){
            case 0:
                color = BackgroundColor.nextColorBlue();
                break;
            case 1:
                color = BackgroundColor.nextColorGreen();
                break;
            case 2:
                color = BackgroundColor.nextColorRed();
                break;
        }
    }
}
