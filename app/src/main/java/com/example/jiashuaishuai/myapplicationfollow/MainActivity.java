package com.example.jiashuaishuai.myapplicationfollow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WeltView img;
    int l, b, r, t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (WeltView) findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"dianji",Toast.LENGTH_SHORT).show();
            }
        });
//        img.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int ea = event.getAction();
//                DisplayMetrics dm = getResources().getDisplayMetrics();
//                int screenWidth = dm.widthPixels;
//                int screenHeight = dm.heightPixels - (img.getHeight() / 2);//需要减掉图片的高度
//                switch (ea) {
//                    case MotionEvent.ACTION_DOWN:
//                        lastX = (int) event.getRawX();//获取触摸事件触摸位置的原始X坐标
//                        lastY = (int) event.getRawY();
//
//
//                    case MotionEvent.ACTION_MOVE:
//                        //event.getRawX();获得移动的位置
//                        int dx = (int) event.getRawX() - lastX;
//                        int dy = (int) event.getRawY() - lastY;
//                        l = img.getLeft() + dx;
//                        b = img.getBottom() + dy;
//                        r = img.getRight() + dx;
//                        t = img.getTop() + dy;
//
////下面判断移动是否超出屏幕
//                        if (l < 0) {
//                            l = 0;
//                            r = l + img.getWidth();
//                        }
//                        if (t < 0) {
//                            t = 0;
//                            b = t + img.getHeight();
//                        }
//                        if (r > screenWidth) {
//                            r = screenWidth;
//                            l = r - img.getWidth();
//                        }
//                        if (b > screenHeight) {
//                            b = screenHeight;
//                            t = b - img.getHeight();
//                        }
////                        if(event.getRawX()<screenWidth/2){
////                            Log.i("TAG", "左边");
////                        }else{ Log.i("TAG","右边");}
//
//                        img.layout(l, t, r, b);
//                        lastX = (int) event.getRawX();
//                        lastY = (int) event.getRawY();
//                        img.postInvalidate();
//
//
//                        break;
//                    case MotionEvent.ACTION_UP:
//
//                        if (event.getRawX() < screenWidth / 2) {
//
//
//                            ValueAnimator animator = ValueAnimator.ofFloat(lastX, 0);
//                            animator.setTarget(img);
//                            animator.setDuration(400).start();
//                            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
//                            {
//                                @Override
//                                public void onAnimationUpdate(ValueAnimator animation)
//                                {
//                                    img.setX((Float) animation.getAnimatedValue());
//                                }
//                            });
//
//
//                        } else {
//
//                            ValueAnimator animator = ValueAnimator.ofFloat(lastX, screenWidth
//                                    - img.getWidth());
//                            animator.setTarget(img);
//                            animator.setDuration(400).start();
//                            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
//                            {
//                                @Override
//                                public void onAnimationUpdate(ValueAnimator animation)
//                                {
//                                    img.setX((Float) animation.getAnimatedValue());
//                                }
//                            });
//                        }
//                        lastX = (int) event.getRawX();
//                        lastY = (int) event.getRawY();
//                        break;
//                }
//                return true;
//            }
//        });
//    }
//
//    int lastX, lastY;
    }

}
