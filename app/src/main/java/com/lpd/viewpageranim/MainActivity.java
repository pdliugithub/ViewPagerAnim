package com.lpd.viewpageranim;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private List<View> mViewLists;
    private int[] imgs = {
            R.mipmap.car1,
            R.mipmap.car6,
            R.mipmap.car3,
            R.mipmap.car2
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewLists = new ArrayList<>();

        mViewPager = (ViewPager) findViewById(R.id.id_viewPager);

        /**
         * 设置Pager之间的间隔，以及显示图片
         */
        mViewPager.setPageMargin(30);
        mViewPager.setPageMarginDrawable(R.mipmap.ic_launcher);

        ImageView imageView = null;
        for (int i = 0; i < imgs.length; i++) {
            imageView =  new ImageView(getApplicationContext());
            imageView.setImageResource(imgs[i]);

            mViewLists.add(imageView);
        }

        mViewPager.setPageTransformer(true, new ImPagerTransformer());


        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mViewLists.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mViewLists.get(position));
                return mViewLists.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViewLists.get(position));
            }
        });



    }

}
