package com.gzeinnumer.swipeviewviewpager;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        models = new ArrayList<>();
        models.add(new Model(R.drawable._1, "M. Fadli Zein", getString(R.string.long_text)));
        models.add(new Model(R.drawable._2, "Dewan Kehormatan", getString(R.string.long_text)));
        models.add(new Model(R.drawable._3, "Cybertech", getString(R.string.long_text)));

        adapter = new Adapter(this, models);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 130, 130, 0);

        Integer[] colorTemp = {
            getResources().getColor(R.color.colorAccent),
            getResources().getColor(R.color.colorPrimary),
            getResources().getColor(R.color.colorPrimaryDark)
        };

        colors = colorTemp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (i <(adapter.getCount()-1)&& i <(colors.length-1)){
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(v, colors[i], colors[i+1]));
                }
                else {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
