package com.renrennet.timer;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by leiguorui on 11/24/14.
 */
public class BlackScreen {
    public void runTask(final long timeInterval){
        Runnable runnable = new Runnable() {

            public void run() {
                while (true) {
                    // ------- code for task to run
                    System.out.println("Task start "+new Date());
                    task();
                    // ------- ends here
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void task(){
        String command = "gnome-screensaver-command -l";
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // run in a second
        final long timeInterval = 45*60*1000;
        new BlackScreen().runTask(timeInterval);
    }
}
