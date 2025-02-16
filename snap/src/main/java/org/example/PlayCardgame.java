package org.example;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class PlayCardgame {
    public static void main(String[] args){
        Snap newGame = new Snap();
        newGame.snapIntro();
        newGame.playSnap();

    }
}
