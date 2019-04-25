package com.jakeesveld.android_hungry_developers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spoon spoon1 = new Spoon(1);
        Spoon spoon2 = new Spoon(2);
        Spoon spoon3 = new Spoon(3);
        Spoon spoon4 = new Spoon(4);
        Spoon spoon5 = new Spoon(5);

        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer(spoon1, spoon5, 1));
        developers.add(new Developer(spoon2, spoon1, 2));
        developers.add(new Developer(spoon3, spoon2, 3));
        developers.add(new Developer(spoon4, spoon3, 4));
        developers.add(new Developer(spoon5, spoon4, 5));

        for(Developer developer: developers) {
            new Thread(developer).start();
        }

    }
}
