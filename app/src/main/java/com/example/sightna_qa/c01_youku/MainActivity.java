package com.example.sightna_qa.c01_youku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout level1;
    private RelativeLayout level2;
    private RelativeLayout level3;

    private ImageView icon_home;
    private ImageView icon_menu;

    private boolean isLevel3Show = true;
    private boolean isLevel2Show = true;
    private boolean isLevel1Show = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        level1 = (RelativeLayout) findViewById(R.id.level1);
        level2 = (RelativeLayout) findViewById(R.id.level2);
        level3 = (RelativeLayout) findViewById(R.id.level3);

        icon_home = (ImageView) findViewById(R.id.icon_home);
        icon_menu= (ImageView) findViewById(R.id.icon_menu);

        icon_home.setOnClickListener(this);
        icon_menu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icon_home:
                if (!isLevel2Show) {
                    Tools.showView(level2);
                    isLevel2Show = true;
                } else {
                    Tools.hideView(level2);
                    isLevel2Show = false;
                    if (isLevel3Show) {
                        Tools.hideView(level3);
                        isLevel3Show = false;
                    }
                }
                break;

            case R.id.icon_menu:
                if (isLevel3Show) {
                    Tools.hideView(level3);
                    isLevel3Show = false;
                } else {
                    Tools.showView(level3);
                    isLevel3Show = true;
                }

                break;

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            if (isLevel1Show) {
                Tools.hideView(level1);
                isLevel1Show = false;
                if (isLevel2Show) {
                    Tools.hideView(level2, 200);
                    isLevel2Show = false;
                    if (isLevel3Show) {
                        Tools.hideView(level3, 300);
                        isLevel3Show = false;
                    }
                }
            } else {
                Tools.showView(level1);
                isLevel1Show = true;
                Tools.showView(level2,200);
                isLevel2Show = true;
            }
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
