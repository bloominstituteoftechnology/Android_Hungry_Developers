package com.example.hungrydevelopers;

import java.util.concurrent.Semaphore;

public class Spoon {
	
	private Semaphore spoonLock;
	private int index;
	
	public Spoon(int index) {
		spoonLock = new Semaphore(1);
		this.index = index;
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
	
	public int getIndex() {
		return index;
	}
}
