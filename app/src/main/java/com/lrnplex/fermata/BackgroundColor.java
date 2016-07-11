package com.lrnplex.fermata;

import java.util.Random;

/**
 * Created by David on 7/7/2016.
 */
public class BackgroundColor {
    private static int currentColor = 0x7f7f7f;
    private static int r;
    private static int g;
    private static int b;
    private static final double frequency1 = 0.01; //Higher frequency means color is less favored
    private static final double frequency2 = 0.02;
    private static final double frequency3 = 0.03;
    private static final double frequency4 = 0.04;
    private static final double frequency5 = 0.05;
    private static final int width = 50;
    private static final int center = 200;
    private static double iteratorBlue = 0;
    private static double iteratorRed = 0;
    private static double iteratorGreen = 0;
    static Random random;

    static {
       random = new Random();
        iteratorBlue = random.nextInt(100);
        iteratorRed = random.nextInt(100);
        iteratorGreen = random.nextInt(100);

    }

    /*private static double red;
    private static double green;
    private static double blue;
    private static double h;
    private static double s;
    private static double l;*/

    public static int nextColorBlue(){
        //iteratorBlue =random.nextInt(100);
        r = (int)(Math.sin(frequency5*iteratorBlue + 0) * width + center);
        g = (int)(Math.sin(frequency5*iteratorBlue + 2) * width + center);
        b = (int)(Math.sin(frequency5*iteratorBlue + 4) * width + center);
        iteratorBlue += 1;
        currentColor = rgbToHex(r, g, b);
        //Log.d("BackgroundColor", "nextColor: " + iterator);
        return currentColor;
    }

    public static int nextColorGreen(){
        r = (int)(Math.sin(frequency3*iteratorGreen + 0) * width + center);
        g = (int)(Math.sin(frequency3*iteratorGreen + 2) * width + center);
        b = (int)(Math.sin(frequency3*iteratorGreen + 4) * width + center);
        iteratorGreen += 1;
        currentColor = rgbToHex(r, g, b);
        //Log.d("BackgroundColor", "nextColor: " + iterator);
        return currentColor;
    }
    public static int nextColorRed(){
        r = (int)(Math.sin(frequency1*iteratorRed + 0) * width + center);
        g = (int)(Math.sin(frequency1*iteratorRed + 2) * width + center);
        b = (int)(Math.sin(frequency1*iteratorRed + 4) * width + center);
        iteratorRed += 1;
        currentColor = rgbToHex(r, g, b);
        //Log.d("BackgroundColor", "nextColor: " + iterator);
        return currentColor;
    }


    private static int rgbToHex(int r, int g, int b){
        String hexValue = "0x" +  Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
        return Integer.decode(hexValue);
    }


}
