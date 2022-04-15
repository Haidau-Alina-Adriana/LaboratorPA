package com.company;

public class DaemonThread extends Thread implements Runnable {
    private float time = 0;
    private boolean running = false;

    public void run() {
//        while (running) {
            time += (float) 1 / 1000.0f;
//            display();
            if (time > 100) {
                System.out.println("Time exceeded!");
            }
//        }
    }

    public void display() {
        System.out.println(time);
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
