
package com.jerryliu.rem;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView mlv;

    private int[] mColors;
    private int[] COLORS = new int[] {

            android.R.color.holo_blue_bright,
            android.R.color.holo_green_dark,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light,

            android.R.color.holo_blue_dark,
            android.R.color.holo_green_dark,
            android.R.color.holo_red_dark,
            android.R.color.holo_purple
    };

    private String[] MEMO = new String[] {
            "A day is a miniature of eternity.",
            "Miracles sometimes occur, but one has to work terribly for them.",
            "It takes two to make a quarrel.",
            "single spark can start a prairie fire.",
            "If you do not learn to think when you are young, you may never learn. ",
            "Anger begins with folly, and ends in repentance.",
            "If there were less sympathy in the world, there would be less trouble in the world. ",
            "世界上只有一种英雄主义，那就是了解生命而且热爱生命的人",
            "我们既到世上走了一道，就得珍惜生命的价值。在某种意义上说，生要比死更难。死，只需要一时的勇气，生，却需要一世的胆识。",
            "能将自己的生命寄托在他人记忆中，生命仿佛就加长了一些；光荣是我们获得的新生命，其可珍可贵，实不下于天赋的生命。",
            "我总觉得，生命本身应该有一种意义，我们绝不是白白来一场的。",
            "生命是有限的，但为人民服务是无限的，我要把有限的生命投入到无限的为人民服务之中去。",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initColors();

        mlv = (ListView) findViewById(R.id.main_listview);

        ArrayAdapter<String> la = new ArrayAdapter<String>(this, R.layout.listitem);

        for (int i = 0; i < MEMO.length; i++) {
            la.add(MEMO[i]);
        }

        mlv.setAdapter(la);
        mlv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int pos, long arg3) {
                setbg(v);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        hide();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        hide();
    }

    private void initColors() {
        mColors = new int[COLORS.length];
        for (int i = 0; i < mColors.length; i++) {
            mColors[i] = getResources().getColor(COLORS[i]);
        }
    }

    private void setbg(View v) {
        Random r = new Random();
        v.setBackgroundColor(mColors[r.nextInt(mColors.length)]);
    }

    private void hide() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
