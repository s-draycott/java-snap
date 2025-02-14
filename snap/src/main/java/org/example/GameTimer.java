package org.example;
import java.util.Timer;
import java.util.TimerTask;


public class GameTimer {
    public void startTimer(){
        Timer newTimer = new Timer();
        TimerTask task = new TimerTask() {
            int count = 5;
            @Override
            public void run() {
                System.out.println(count);
                count--;
                if(count < 0) {
                    System.out.println("⌛ TIME'S UP ⌛");
                    newTimer.cancel();
                }
            }
        };
        newTimer.schedule(task, 0, 1000);

    }

}
