package com.lrnplex.fermata;

/**
 * Created by David on 7/8/2016.
 */
public class Ball {
    private int x = 200;
    private int y = 400;

    public Ball(){
    }

    public void move(int height){
        y += height;
    }

    public void jumpStart(){
        y -= 10;
    }

    public void jump(){
        y -= 7;
    }
    public void jumpEnd(){
        y -= 4;
    }

    public void fallStart(){
        y += 4;
    }

    public void fall(){
        y += 7;
    }

    public void fallEnd(){
        y += 10;
    }


    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
