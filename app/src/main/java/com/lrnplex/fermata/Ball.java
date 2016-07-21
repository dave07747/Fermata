package com.lrnplex.fermata;

import android.util.Log;

/**
 * Created by David on 7/8/2016.
 */
public class Ball {
    private double x = 200;
    private double y = 500;

    public Ball(){
    }

    public void setY(double pos){
        y = pos;
    }

    public void jump(int iterator){
        y = (Math.pow(20 - iterator, 2)/(4*.25) -00);
        Log.d("Fermata", "jump: " + y);
    }

    public void fall(){
        y += 50;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
