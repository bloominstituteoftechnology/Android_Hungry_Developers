package com.example.hungrydevelopers;

import java.util.concurrent.Semaphore;

public class Spoon {
	
	private final Semaphore spoonLock;
	
	public Spoon() {
		spoonLock = new Semaphore(1);
	}
	
	public void pickUp() {
		try {
			spoonLock.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void putDown() {
		spoonLock.release();
	}
}
