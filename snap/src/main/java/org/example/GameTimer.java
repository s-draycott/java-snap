package org.example;
import java.util.Timer;
import java.util.TimerTask;


public class GameTimer {
    public GameTimer() {}

    public void startTimer(int timerSeconds){
        Timer newTimer = new Timer();
        TimerTask task = new TimerTask() {
            int timerCount = timerSeconds;
            @Override
            public void run() {
                System.out.println(timerCount);
                timerCount--;
                if(timerCount < 0) {
                    System.out.println("⌛ TIME'S UP ⌛");
                    newTimer.cancel();
                }
            }
        };
        newTimer.schedule(task, 0, 1000);

    }

}
