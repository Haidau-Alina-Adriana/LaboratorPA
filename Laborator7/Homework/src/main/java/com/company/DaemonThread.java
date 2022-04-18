package com.company;

public class DaemonThread extends Thread implements Runnable {
    private float time = 0;
    private boolean running = false;

    public void run() {
        while (running) {
            time += (float) 1 / 10000000.f;
            if (time > 180000) {
                System.out.println("Time exceeded!");
            }
        }
    }

    public float getTime() {
        return time;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
