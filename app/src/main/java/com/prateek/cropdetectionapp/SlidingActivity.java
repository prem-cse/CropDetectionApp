package com.prateek.cropdetectionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.g.ui.Adapters.SliderAdapter;
import com.g.ui.R;

public class SlidingActivity extends AppCompatActivity {

    private ViewPager pager;
    private LinearLayout dots;

    private TextView[] mDots;

    SliderAdapter sliderAdapter;
    int curr;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sliding);

        pager = (ViewPager) findViewById(R.id.viewPager);
        dots = (LinearLayout) findViewById(R.id.dot);

        next = (Button) findViewById(R.id.next);

        sliderAdapter = new SliderAdapter(this);

        pager.setAdapter(sliderAdapter);

        mdotsInit(0);


        pager.addOnPageChangeListener(viewListener);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pager.setCurrentItem(curr + 1);

            }
        });
    }

    public void mdotsInit(final int position){

        mDots = new TextView[3];
        dots.removeAllViews();

        for(int i=0; i<3; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextColor(getResources().getColor(R.color.trans));
            mDots[i].setTextSize(35);

            dots.addView(mDots[i]);
        }

        if(mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor(R.color.white));

        }



    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            mdotsInit(i);

            curr = i;

            if(curr == 0){
                next.setEnabled(true);

                next.setText("Next");
            }

            else if (i == mDots.length-1){
                next.setEnabled(true);

                next.setText("Got it");
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(SlidingActivity.this, CropsSelect.class));
                    }
                });
            }
            else
            {
                next.setEnabled(true);

                next.setText("Next");
            }

        }



        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


}
