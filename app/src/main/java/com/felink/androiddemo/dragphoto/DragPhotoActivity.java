package com.felink.androiddemo.dragphoto;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.felink.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */

public class DragPhotoActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<String> mList;
    private DragPhotoView[] mPhotoViews;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_photo_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.drag_photo_activity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mList = new ArrayList<>();

        mList.add("path");
        mList.add("path");
        mList.add("path");

        mPhotoViews = new DragPhotoView[mList.size()];

        for (int i = 0; i < mPhotoViews.length; i++) {
            mPhotoViews[i] = (DragPhotoView) View.inflate(this, R.layout.item_viewpager, null);
            mPhotoViews[i].setImageResource(R.drawable.wugeng);
            mPhotoViews[i].setOnTapListener(new DragPhotoView.OnTapListener() {
                @Override
                public void onTap(DragPhotoView view) {
                    finishWithAnimation();
                }
            });

            mPhotoViews[i].setOnExitListener(new DragPhotoView.OnExitListener() {
                @Override
                public void onExit(DragPhotoView view, float x, float y, float w, float h) {
                    performExitAnimation(view, x, y, w, h);
                }
            });
        }

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mList.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mPhotoViews[position]);
                return mPhotoViews[position];
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mPhotoViews[position]);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
    }

    private void performExitAnimation(DragPhotoView view, float x, float y, float w, float h) {
    }

    private void finishWithAnimation() {
    }
}
