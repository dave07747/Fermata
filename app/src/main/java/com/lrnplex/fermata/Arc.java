package com.lrnplex.fermata;

import com.lrnplex.framework.Pixmap;

/**
 * Created by David on 7/6/2016.
 */
public class Arc {
    private float x;
    private float y;
    float realY;

    public float scalar = 8;
    private int arcType;

    private boolean score = false;

    int iterator = 24;

    public Arc(float x, float y,  int arcType){
        this.x = x;
        this.y = y;
        this.arcType = arcType;

    }

    public void setScore() {
        this.score = true;
    }

    public boolean getScore() {
        return score;
    }

    public void moveArc(double arcMove){
        this.x -= arcMove;
    }

    public Pixmap getArc() {
        switch (arcType){
            case 1:
                return Assets.getArc1();
            case 2:
                return Assets.getArc2();
            case 3:
                return Assets.getArc3();
            default:
                arcType = 1;
                return Assets.getArc1();
        }
    }

    public float getX() {
        return x * scalar;
    }

    public float getY() {
        return y * scalar;
    }
    public int getYPoint(){
        float h = getX() + (getLength()/2) -1;
        float k = getY() + (getHeight()/2) - 1;
        float a = (getLength()/2);
        float b =  (getHeight()/2);
        int num = (int)(k + b * Math.sqrt(1 - Math.pow(((210 - h)/a), 2)))-125;
        if(num < 100)
            realY = y;
        return  num;
    }

    public int getLength(){
        switch (arcType){   //-80
            case 1:
                return 300;
            case 2:
                return 237;
            case 3:
                return 450;
            default:
                return 300;
        }
    }

    public int getHeight(){
        switch (arcType){   //+40
            case 1:
                return 158;
            case 2:
                return 125;
            case 3:
                return 170;
            default:
                return 158;
        }
    }
}
