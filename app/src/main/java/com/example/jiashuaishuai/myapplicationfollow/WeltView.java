package com.example.jiashuaishuai.myapplicationfollow;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.ImageView;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MASK;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

/**
 * Created by jiashuaishuai on 2016/3/17.
 * 永远贴这两边
 */
public class WeltView extends ImageView {
    /**
     * 屏幕宽高
     */
    private final int screenWidth;
    private final int screenHeight;

    /**
     * view 左下右上坐标
     */
    int l, b, r, t;
    /**
     * 记录滑动坐标
     */
    private Point point = new Point();
    /**
     * 偏移量
     */
    private static final int tag = 5;
    /**
     * 记录按下时的坐标
     */
    private int startX, startY;
    /**
     * 判断是否滑动没有
     */
    private boolean isMove;


    public WeltView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**
         * 获取屏幕宽高
         */
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels - (this.getHeight() / 2);//需要减掉图片的高度
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case ACTION_DOWN:
                point.x = (int) event.getRawX();//获取触摸事件触摸位置的原始X坐标
                point.y = (int) event.getRawY();

                startX = (int) event.getRawX();
                startY = (int) event.getRawY();
                super.onTouchEvent(event);
            case ACTION_MOVE:
                /**
                 * 计算偏移量
                 */
                int dx = (int) event.getRawX() - point.x;
                int dy = (int) event.getRawY() - point.y;
                l = this.getLeft() + dx;
                b = this.getBottom() + dy;
                r = this.getRight() + dx;
                t = this.getTop() + dy;


                //下面判断移动是否超出屏幕
                if (l < 0) {
                    l = 0;
                    r = l + this.getWidth();
                }
                if (t < 0) {
                    t = 0;
                    b = t + this.getHeight();
                }
                if (r > screenWidth) {
                    r = screenWidth;
                    l = r - this.getWidth();
                }
                if (b > screenHeight) {
                    b = screenHeight;
                    t = b - this.getHeight();
                }
                /**
                 * 更改view位置
                 */
                this.layout(l, t, r, b);
                point.x = (int) event.getRawX();
                point.y = (int) event.getRawY();
                this.postInvalidate();
                super.onTouchEvent(event);
                break;
            case ACTION_UP:
            case ACTION_CANCEL:
            case ACTION_MASK:

                point.x = (int) event.getRawX();
                point.y = (int) event.getRawY();

                int endx = Math.abs(point.x - startX);
                int endy = Math.abs(point.y - startY);
/**
 * up坐标减去down坐标，移动距离，大于偏移量则判定移动，佛则，交给系统处理
 */
                if (endx >= tag || endy >= tag) {
                    isMove = true;
                    /**
                     * 如果当前位置大于屏幕一般那么就是左边佛则右边
                     */
                    if (event.getRawX() < screenWidth / 2) {


                        ValueAnimator animator = ValueAnimator.ofFloat(point.x, 0);
                        animator.setTarget(this);
                        animator.setDuration(300).start();
                        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                setX((Float) animation.getAnimatedValue());
                            }
                        });


                    } else {
/**
 * 动画
 */
                        ValueAnimator animator = ValueAnimator.ofFloat(point.x, screenWidth
                                - this.getWidth());
                        animator.setTarget(this);
                        animator.setDuration(300).start();
                        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                setX((Float) animation.getAnimatedValue());
                            }
                        });
                    }

                } else {
                    isMove = false;
                }
                break;
        }
        if (isMove) {
            /**
             * 滑动返回true
             */
            return true;
        } else {
            /**
             * 其他则交给系统处理
             */
            return super.onTouchEvent(event);
        }
    }

}
