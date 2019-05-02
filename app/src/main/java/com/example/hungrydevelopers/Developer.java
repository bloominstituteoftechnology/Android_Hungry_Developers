package com.example.hungrydevelopers;

import android.util.Log;

public class Developer implements Runnable {
	private String name;
	Spoon leftSpoon;
	Spoon rightSpoon;
	Boolean isRunning;
	
	public Developer(Spoon leftSpoon, Spoon rightSpoon, String name) {
		this.leftSpoon = leftSpoon;
		this.rightSpoon = rightSpoon;
		this.name = name;
	}
	
	public void think() {
		Log.i(name, name + " is thinking.");
		
		if (leftSpoon.getIndex() < rightSpoon.getIndex()) {
			leftSpoon.pickUp();
			rightSpoon.pickUp();
		} else {
			rightSpoon.pickUp();
			leftSpoon.pickUp();
		}
	}
	
	public void eat() {
		Log.i(name, name + " is eating.");
		try {
			Thread.sleep((long) (Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		leftSpoon.putDown();
		rightSpoon.putDown();
	}
	
	public void run() {
		isRunning = true;
		while (isRunning) {
			think();
			eat();
		}
	}
}
