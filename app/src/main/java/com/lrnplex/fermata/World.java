package com.lrnplex.fermata;

/**
 * Created by David on 7/8/2016.
 */
public class World {
    static final int WORLD_WIDTH = 160;
    static final int WORLD_HEIGHT = 90;
    static final int SCORE_INCREMENT = 1;
    static final float TICK_INITIAL = 0.5f;
    static final float TICK_DECREMENT = 0.05f;
    final int BALL_BUFFER = -15;

    public ArcControl arcControl;
    public Ball ball;
    public boolean gameOver = false;
    public int score = 0;
    boolean jump = false;
    int iterator = 0;
    boolean fall = false;
    boolean oneTouch = false;

    //boolean fields[][] = new boolean[WORLD_WIDTH][WORLD_HEIGHT];
    //Random random = new Random();
    float tickTime = 0;
    float tick = TICK_INITIAL;

    public World(){
        arcControl = new ArcControl();
        ball = new Ball();
    }

    public void update(float deltaTime){
        if(gameOver)
            return;

        tickTime += deltaTime;

        while(tickTime > tick){
            tickTime -= tick;
            arcControl.moveArc();
            //Log.d("World", "update: moved Arc");
            arcControl.checkArc();
            if(arcControl.checkLastArc())
                arcControl.addArc();

            /**
             * Do something to check if ball not dead and update ball
             */

            if(ball.getY() == 720)
                gameOver = true;        // Ball dead

            if(jump == true){
                if(iterator < 13)
                    ball.jumpStart();
                if(iterator >= 13 && iterator < 18)
                    ball.jump();
                if(iterator >= 18)
                    ball.jumpEnd();
                iterator++;
                if(iterator == 20){
                    jump = false;
                    fall = true;
                }
            }

            if(fall == true){
                // Log.d("fall", "updateRunning: Falling");
                if(iterator > 10)
                    ball.fallStart();
                if(iterator <= 8 && iterator > 6)
                    ball.fall();
                if(iterator <= 6)
                    ball.fallEnd();
                if(iterator != 0)
                    iterator--;
                if(ball.getY() + 10 < arcControl.ballCheck())
                    ball.fallEnd();
                else
                    ball.move(1);
               /* if(iterator == 0){
                    fall = false;
                    oneTouch = false;
                }*/
                /**
                 * TODO: iterator won't work here. Instead check if ball is 15px above arc
                 */
            }

            if(!fall && !jump)
            {

            }



            if(score % 10 == 0 && tick - TICK_DECREMENT > 0)
                tick -= TICK_DECREMENT;
        }
    }
}
