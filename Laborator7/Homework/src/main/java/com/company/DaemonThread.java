package com.company;

import java.util.Date;

public class DaemonThread extends Thread implements Runnable {
    private boolean running = false;
    private Date startingTime;
    private Date endTime;

    public DaemonThread() {
        this.startingTime = new Date();
    }

    public void run() {
        while (running) {
            Date currentTime = new Date();
            if ((currentTime.getTime() - startingTime.getTime()) > 6000000)
                System.out.println("Time exceeded!");
        }
    }

    public long getDuration() {
        return (endTime.getTime() - startingTime.getTime());
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
