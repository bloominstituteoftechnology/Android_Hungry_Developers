package com.example.hungrydevelopers;

public class Developer implements Runnable {
	Spoon leftSpoon;
	Spoon rightSpoon;
	Boolean isRunning;
	
	public Developer(Spoon leftSpoon, Spoon rightSpoon) {
		this.leftSpoon = leftSpoon;
		this.rightSpoon = rightSpoon;
	}
	
	public void think() {
		leftSpoon.pickUp();
		rightSpoon.pickUp();
	}
	
	public void eat() {
		try {
			Thread.sleep((long) (Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		leftSpoon.putDown();
		rightSpoon.pickUp();
	}
	
	public void run() {
		isRunning = true;
		while (isRunning) {
			think();
			eat();
		}
	}
}
