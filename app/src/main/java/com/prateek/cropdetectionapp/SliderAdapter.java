package com.prateek.cropdetectionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public String[] titles = {"Find out what's happening to your plant", "Receive recommendations on how to grow your crop", "Get in touch and exchange with experts"};

    public String[] desc = {"Take a picture of your plant and plantix will provide you with instant solution", "The crop advisory gives you a series of recommendations on how to grow your crops. It will support you in decisions during the crop cycles so that you get the best possible yields.", "The Plantix Community is your doorway to farming experts around the world"};
    public int[] img = {R.drawable.first, R.drawable.second, R.drawable.third};



    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((RelativeLayout)o);

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imgs = (ImageView) view.findViewById(R.id.image);
        TextView title = (TextView) view.findViewById(R.id.head);
        TextView des = (TextView) view.findViewById(R.id.desc);

        imgs.setImageResource(img[position]);
        title.setText(titles[position]);
        des.setText(desc[position]);

        container.addView(view);


        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);

    }
}

