package com.shusheng1978.yushuliang.learnview20150821;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn, rbtn, tbtn, sbtn, btnS, btnP;

    private AnimationSet animationSet;
    private  PrivateAnimation pri;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.alphaAnim);
        rbtn = (Button) findViewById(R.id.RotateAnimation);
        tbtn = (Button) findViewById(R.id.translateAnimation);
        sbtn = (Button) findViewById(R.id.scaleAnimation);
        btnS = (Button) findViewById(R.id.animationSet);
        btnP = (Button) findViewById(R.id.priAnima);



        animationSet = new AnimationSet(true);

        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(1000);
        animationSet.addAnimation(alpha);

        TranslateAnimation translate = new TranslateAnimation(0, 200, 0, 200);
        translate.setDuration(1000);
        animationSet.addAnimation(translate);

        pri = new PrivateAnimation();
        pri.setDuration(3000);


        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(pri);

            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationSet.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //动画结束是启动
                        Toast.makeText(MainActivity.this, "I am Happy", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                v.startAnimation(animationSet);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                AlphaAnimation animation = new AlphaAnimation(0, 1); //新建一个透明效果的AlphaAnimation；
                animation.setDuration(3000);      //透明时间1S
                v.startAnimation(animation);      //开始透明
                */

                v.startAnimation(AnimationUtils.loadAnimation(getApplication(),R.anim.aa));//里面的context到底是什么
            }
        });

        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                //RotateAnimation rotateAnimation = new RotateAnimation(0, 680, 200, 200);//新建一个旋转动画RotateAnimation
                RotateAnimation rotateAnimation = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(3000);
                v.startAnimation(rotateAnimation);
                */
                v.startAnimation(AnimationUtils.loadAnimation(getApplication(),R.anim.ratate));
            }
        });

        tbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建一个移动动画
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, 300);//里面是起始X，末尾X，起始Y，末尾Y,起始都是以自身到一个增量的位置
                translateAnimation.setDuration(3000);
                v.startAnimation(translateAnimation);
            }
        });

        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建一个缩放动画
                //ScaleAnimation scaleAnimation = new ScaleAnimation(1, 5, 1, 5);//里面是起始X，末尾X，起始Y，末尾Y

                //以那个点缩放，xy轴
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
                scaleAnimation.setDuration(3000);
                v.startAnimation(scaleAnimation);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
