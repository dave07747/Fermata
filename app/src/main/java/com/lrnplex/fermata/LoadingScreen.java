package com.lrnplex.fermata;

/**
 * Created by David on 7/4/2016.
 */
import android.util.Log;

import com.lrnplex.framework.Game;
import com.lrnplex.framework.Graphics;
import com.lrnplex.framework.Screen;

public class LoadingScreen extends Screen {
    private float timeTotal = 0f;
    private boolean once = true;

    public LoadingScreen(Game game){
        super(game);
    }

    public void update(float deltaTime) {
        if (once) {
            Graphics g = game.getGraphics();
            game.load();
            /**
             * Load all the assets here
             */
            Assets.setSoundOn(g.newPixmap("soundOn.png", Graphics.PixmapFormat.ARGB4444));
            Assets.setSoundOff(g.newPixmap("soundOff.png", Graphics.PixmapFormat.ARGB4444));
            Assets.setTitle(g.newPixmap("Title2.png", Graphics.PixmapFormat.ARGB4444));
            Assets.setStart(g.newPixmap("Start.png", Graphics.PixmapFormat.ARGB4444));
            Assets.setScore(g.newPixmap("Score.png", Graphics.PixmapFormat.ARGB4444));
            Assets.setThemeScreen(g.newPixmap("themeScreen.png", Graphics.PixmapFormat.ARGB4444));
            Assets.setPause(g.newPixmap("pause.png", Graphics.PixmapFormat.ARGB4444));
            Assets.setQuit(g.newPixmap("Quit.png", Graphics.PixmapFormat.ARGB4444));
            Assets.setResume(g.newPixmap("Resume.png", Graphics.PixmapFormat.ARGB4444));
            Assets.setGameOver(g.newPixmap("GameOver.png", Graphics.PixmapFormat.ARGB4444));
            Assets.setReady(g.newPixmap("Ready.png", Graphics.PixmapFormat.ARGB4444));
            Assets.setNumbers(g.newPixmap("Numbers.png", Graphics.PixmapFormat.ARGB4444));

            switch (Settings.theme) {
                case 1:
                    Assets.setBall(g.newPixmap("ball1.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setArc1(g.newPixmap("arc1.1.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setArc2(g.newPixmap("arc1.2.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setArc3(g.newPixmap("arc1.3.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setBackground(g.newPixmap("background.jpg", Graphics.PixmapFormat.ARGB4444));
                    Log.d("Loading screen", "READ SAVED DATA");
                    break;
                default:
                    Assets.setBall(g.newPixmap("ball1.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setArc1(g.newPixmap("arc1.1.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setArc2(g.newPixmap("arc1.2.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setArc3(g.newPixmap("arc1.3.png", Graphics.PixmapFormat.ARGB4444));
                    Assets.setBackground(g.newPixmap("background.jpg", Graphics.PixmapFormat.ARGB4444));
                    Log.d("Loading screen", "No saved settings read");
            }

            Assets.setClick(game.getAudio().newSound("click.ogg"));
            Assets.setFall(game.getAudio().newSound("fall.mp3"));
            //End loading assets

            once = false;
        }
    }

    public void present(float deltaTime){
        Graphics g = game.getGraphics();
        timeTotal += deltaTime;
        g.drawPixmap(g.newPixmap("splash_img.png", Graphics.PixmapFormat.ARGB4444), 0, 0);

        if(timeTotal > 0)
            game.setScreen(new MainMenuScreen(game));

       // Log.d("Time splash screen", "present: " + timeTotal);
    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
