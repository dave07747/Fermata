package com.lrnplex.fermata;

import android.util.Log;

/**
 * Created by David on 7/8/2016.
 */
public class World {
    static final float TICK_INITIAL = 0.05f;


    public ArcControl arcControl;
    public Ball ball;
    public boolean gameOver = false;
    public int score = 0;
    boolean jump = false;
    int iterator = 0;  //50
    boolean fall = false;
    boolean oneTouch = false;
    int miniIterator = 0;

    //boolean fields[][] = new boolean[WORLD_WIDTH][WORLD_HEIGHT];
    //Random random = new Random();
    float tickTime = 0f;
    float tick = TICK_INITIAL;

    public World() {
        arcControl = new ArcControl();
        ball = new Ball();
    }

    public void update(float deltaTime) {
        if (gameOver)
            return;

        tickTime += deltaTime;

        while (tickTime > tick) {
            tickTime -= tick;
            arcControl.moveArc();
            //Log.d("World", "update: moved Arc");
            arcControl.checkArc();
            if (arcControl.checkLastArc())
                arcControl.addArc();


            if (ball.getY() > 720) {
                gameOver = true;        // uncomment for gameover
            }


            if (jump) {
                // Log.d("World", "Jumping");
                iterator++;
                if (iterator <= 100) {//&& arcControl.ballCheck() > ball.getY()-100
                    double ballPos = arcControl.ballCheck();
                    Log.d("Ball position on arc", "update: " + ballPos);
                    if (ball.getY() < ballPos + 100 || ballPos == 840)
                        ball.jump(iterator);
                    else {
                        if (miniIterator < 3) {
                            ball.jump(iterator++);
                            miniIterator++;
                        }
                        else {
                            jump = false;
                            oneTouch = false;
                        }
                    }
                }
                //Log.d("fermata", "update: " + iterator);
            } else if (fall) {
                if (arcControl.ballCheck() > ball.getY())
                    ball.fall();
                else
                    fall = false;
            } else {
                double ballPos = arcControl.ballCheck();
                if (ballPos < 840)
                    ball.setY(ballPos);
                else {
                    ball.fall();
                }
                iterator = 0;
                miniIterator = 0;
            }


            if (arcControl.scoreArc()) {
                score++;
            }
            //}

            if (score % 5 == 0)//&& tick - TICK_DECREMENT > 0)
                arcControl.arcMove += 0.01;
            //tick -= TICK_DECREMENT;
        }
    }
}
