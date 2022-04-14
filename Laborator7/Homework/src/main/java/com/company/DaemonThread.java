package com.company;

public class DaemonThread  extends Thread{
    private float time = 0;

    public void run(){
        time += (float) 1 / 1000.0f;
        display();
        if(time > 100){
            System.out.println("Exceeded time!");
        }
    }

    public void display(){
        System.out.println(time);
    }
}
