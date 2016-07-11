package com.lrnplex.fermata;

import com.lrnplex.framework.Screen;
import com.lrnplex.framework.impl.AndroidGame;

public class MainActivity extends AndroidGame {

    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
}
