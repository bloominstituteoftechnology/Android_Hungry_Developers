package com.example.hungrydevelopers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
	
	Developer dev1, dev2, dev3, dev4, dev5;
	Spoon spoon1,spoon2,spoon3,spoon4,spoon5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spoon1 = new Spoon(1);
		spoon2 = new Spoon(2);
		spoon3 = new Spoon(3);
		spoon4 = new Spoon(4);
		spoon5 = new Spoon(5);
		
		
		dev1 = new Developer(spoon1, spoon2, "dev1");
		dev2 = new Developer(spoon2, spoon3, "dev2");
		dev3 = new Developer(spoon3,spoon4,"dev3");
		dev4 = new Developer(spoon4,spoon5, "dev4");
		dev5 = new Developer(spoon5, spoon1, "dev5");
		
		Thread dev1Thread = new Thread(dev1);
		Thread dev2Thread = new Thread(dev2);
		Thread dev3Thread = new Thread(dev3);
		Thread dev4Thread = new Thread(dev4);
		Thread dev5Thread = new Thread(dev5);
		
		dev1Thread.start();
		dev2Thread.start();
		dev3Thread.start();
		dev4Thread.start();
		dev5Thread.start();
	}
}
