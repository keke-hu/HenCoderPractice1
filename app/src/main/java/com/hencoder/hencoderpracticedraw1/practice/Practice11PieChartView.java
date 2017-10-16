package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {
    Integer[] percents = new Integer[]{20, 12, 12, 50, 70, 72, 40};
    Integer[] colors = new Integer[]{Color.RED, Color.BLACK, Color.BLUE, Color.WHITE, Color.YELLOW, Color.LTGRAY, Color.GREEN};
    int total = 276;
    String[] strings = new String[]{"Froyo", "GB", "ICS", "JB", "Kitkat", "L", "M"};
    RectF rectF = new RectF();
    float radius;
    int angel = 0;

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;
        radius = getHeight() / 3;
        rectF.left = centerX - radius;
        rectF.top = centerY - radius;
        rectF.right = centerX + radius;
        rectF.bottom = centerY + radius;
        for (int i = 0; i < percents.length; i++) {
            drawArc(canvas, i);
        }
    }

    private void drawArc(Canvas canvas, int position) {
        paint.setColor(colors[position]);
        paint.setStyle(Paint.Style.FILL);
        float sweepAngel = (360 * percents[position]) / total;
        canvas.drawArc(rectF, angel, sweepAngel, true, paint);
        angel += sweepAngel;

    }
}
