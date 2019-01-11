package com.thadocizn.concurrency;

public class Developer {

    private int id;
    private Spoon leftSpoon;
    private Spoon rightSpoon;

    public Developer(int id, Spoon leftSpoon, Spoon rightSpoon) {
        this.id = id;
        this.leftSpoon = leftSpoon;
        this.rightSpoon = rightSpoon;
    }

    public void think(){
        this.leftSpoon.pickUp();
        this.rightSpoon.pickUp();
    }

    public void eat(){
        try {
            Thread.sleep(250);
            this.leftSpoon.putDown();
            this.rightSpoon.putDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while (true){
            think();
            eat();
        }
    }
}
