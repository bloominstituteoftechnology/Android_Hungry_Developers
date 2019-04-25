package com.example.israel.android_hungry_developers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int spoonsNum = 5;
        ArrayList<Spoon> spoons = new ArrayList<>();
        for (int i = 0; i < spoonsNum; ++i) {
            spoons.add(new Spoon(i));
        }

        ArrayList<Developer> devs = new ArrayList<>(spoonsNum);
        for (int i = 0; i < spoonsNum - 1; ++i) { // stop before the last spoon
            // give developer the current and next spoon
            devs.add(new Developer(i, spoons.get(i), spoons.get(i + 1)));
        }
        // give the last developer the last and first spoon
        devs.add(new Developer(spoons.size() - 1, spoons.get(spoons.size() - 1), spoons.get(0)));

        for (int i = 0; i < devs.size(); ++i) {
            new Thread(devs.get(i)).start();
        }
    }
}
