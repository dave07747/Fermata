package com.lrnplex.fermata;

/**
 * Created by David on 7/5/2016.
 */

import android.util.Log;

import com.lrnplex.framework.Game;
import com.lrnplex.framework.Graphics;
import com.lrnplex.framework.Input.TouchEvent;
import com.lrnplex.framework.Music;
import com.lrnplex.framework.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainMenuScreen extends Screen {
    private List <Arc> arcList = new ArrayList<Arc>();
    //private int color = 0x808080;
    private Random rand;

    private Music music;

    public MainMenuScreen(Game game){
        super(game);

        music = game.getMusic();
        rand = new Random();

    }

    public void update(float deltaTime){
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        int len = touchEvents.size();

        for(int i = 0; i < len; ++i){
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP){
                if(inBounds(event, 430, 540, 120 , 120)){   // Check for touch on sound
                    Settings.soundEnabled = !Settings.soundEnabled;
                    Log.d("Update: ", "Toggled Sound");
                    music = game.getMusic();
                    if(Settings.soundEnabled) {
                        Assets.getClick().play(1);
                        music.play();
                    }
                    else {
                        music.pause();
                    }
                }

                if(inBounds(event, 530, 290, 215, 215)){  // Check for touch on start
                    Log.d("Update: ", "Touched start");
                    game.setScreen(new GameScreen(game));
                    if(Settings.soundEnabled)
                        Assets.getClick().play(1);
                    return;
                }

                if(inBounds(event, 580, 540, 120, 120)){    // Check for touch on Play scoring
                    // instruction for score screen goes here
                    Log.d("Update: ", "Touched scoring");
                    if(Settings.soundEnabled)
                        Assets.getClick().play(1);
                    return;
                }

                if(inBounds(event, 740, 540, 120, 120)){    // Check for touch on theme
                    Log.d("Update: ", "Touched theme");
                    game.setScreen(new ThemeScreen(game));
                    if(Settings.soundEnabled)
                        Assets.getClick().play(1);
                    return;
                }
            }
        }
    }

    private boolean inBounds(TouchEvent event, int x, int y, int width, int height){
        if(event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + width -1)
            return true;
        else
            return false;
    }

    @Override
    public void present(float deltaTime){
        Graphics g = game.getGraphics();



        //g.clear(color); //Temp background color

        g.drawPixmap(Assets.getBackground(), 0, 0);

        g.drawPixmap(Assets.getTitle(), 250, 20 ); // Display title
        g.drawPixmap(Assets.getStart(), 540, 300); // Display start button
        g.drawPixmap(Assets.getScore(), 590, 550); // Display score button / connect with google play
        g.drawPixmap(Assets.getThemeScreen(),740, 550); // Display theme screen
        if(Settings.soundEnabled)                        // Display sound icon
            g.drawPixmap(Assets.getSoundOn(), 440, 550);
        else
            g.drawPixmap(Assets.getSoundOff(), 440, 550);

        /*if(direction) {
            color += colorAddition;
            if(color == 0x0000ff)
                colorAddition = 0x000101;
            if(color == 0x00ffff)
                colorAddition = 0x010101;

        }
        else {
            color -= colorAddition;
            if(color == 0xffff00)
                colorAddition = 0x000101;
            if(color == 0xff00ff)
                colorAddition = 0x010101;
        }

        if(color > 0xf0f0f0) {
            direction = false;
            //colorAddition = 0x000001;
        }
        if(color < 0x1f1f1f) {
            direction = true;
            //colorAddition = 0x000001;
        }*/

    }

    public void pause(){

    }

    public void resume(){
        present(1);
    }

    public void dispose() {
    }
}
