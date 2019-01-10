package com.joshuahalvorson.android_hungry_developers;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView iSpoon1, iSpoon2, iSpoon3, iSpoon4, iSpoon5;
    private ImageView iDeveloper1, iDeveloper2, iDeveloper3, iDeveloper4, iDeveloper5;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;

        iSpoon1 = findViewById(R.id.spoon_1);
        iSpoon2 = findViewById(R.id.spoon_2);
        iSpoon3 = findViewById(R.id.spoon_3);
        iSpoon4 = findViewById(R.id.spoon_4);
        iSpoon5 = findViewById(R.id.spoon_5);

        iDeveloper1 = findViewById(R.id.dev_1);
        iDeveloper2 = findViewById(R.id.dev_2);
        iDeveloper3 = findViewById(R.id.dev_3);
        iDeveloper4 = findViewById(R.id.dev_4);
        iDeveloper5 = findViewById(R.id.dev_5);

        ArrayList<Developer> developers = new ArrayList<>();

        Spoon spoon1 = new Spoon(1, iSpoon1, activity);
        Spoon spoon2 = new Spoon(2, iSpoon2, activity);
        Spoon spoon3 = new Spoon(3, iSpoon3, activity);
        Spoon spoon4 = new Spoon(4, iSpoon4, activity);
        Spoon spoon5 = new Spoon(5, iSpoon5, activity);

        Developer developer1 = new Developer("developer1", spoon1, spoon5, iDeveloper1, activity);
        Developer developer2 = new Developer("developer2", spoon2, spoon1, iDeveloper2, activity);
        Developer developer3 = new Developer("developer3", spoon3, spoon4, iDeveloper3, activity);
        Developer developer4 = new Developer("developer4", spoon4, spoon3, iDeveloper4, activity);
        Developer developer5 = new Developer("developer5", spoon5, spoon4, iDeveloper5, activity);

        developers.add(developer1);
        developers.add(developer2);
        developers.add(developer3);
        developers.add(developer4);
        developers.add(developer5);

        for(Developer developer: developers) {
            new Thread(developer).start();
        }

    }
}
