package com.felink.androiddemo.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.felink.androiddemo.R;
import com.felink.androiddemo.arcview.ArcMunuActivity;
import com.felink.androiddemo.dragphoto.WinXinActivity;
import com.felink.androiddemo.utils.ScreenUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drag_photo)
    TextView dragPhoto;
    @BindView(R.id.arc_menu)
    TextView arcMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ScreenUtils.initScreen(this);

    }

    @OnClick(R.id.drag_photo)
    public void onClick() {
        Intent intent = new Intent(this, WinXinActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.arc_menu)
    public void onClick1() {
        Intent intent = new Intent(this, ArcMunuActivity.class);
        startActivity(intent);
    }
}
