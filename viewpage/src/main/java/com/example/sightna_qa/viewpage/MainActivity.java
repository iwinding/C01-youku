package com.example.sightna_qa.viewpage;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView imageDesc;
    private LinearLayout ll_point_group;
    private final int[] imageIds = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e};

    private final String[] imageDescriptions = {
            "巩俐不低俗，我就不能低俗",
            "扑树又回来啦！再唱经典老歌引万人大合唱",
            "揭秘北京电影如何升级",
            "乐视网TV版大派送",
            "热血屌丝的反杀"};
    private ArrayList<ImageView> imageList;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ll_point_group = (LinearLayout) findViewById(R.id.ll_point_group);
        imageDesc = (TextView) findViewById(R.id.tv_image_desc);

        imageList = new ArrayList<ImageView>();

        for (int i=0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            imageList.add(imageView);
        }

        viewPager.setAdapter(new MyPagerAdapter());

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                imageDesc.setText(imageDescriptions[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imageList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            System.out.println("instantiateItem ::position::"+position);

            View view = imageList.get(position % imageList.size());
            container.addView(view);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            System.out.println("destroyItem ::position::" + position);
            container.removeView((View)object);
        }
    }
}
