package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {
    Integer[] percents = new Integer[]{2, 12, 12, 50, 70, 90, 40};
    String[] strings = new String[]{"Froyo", "GB", "ICS", "JB", "Kitkat", "L", "M"};
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    int intervalLength = 20;
    int histogramHeight;
    int histogramWidth;
    int histogramItemWidth;

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        int height = getHeight();
        int width = getWidth();
        histogramHeight = height - 220;
        histogramWidth = width - 180;
        histogramItemWidth = (histogramWidth - (percents.length + 1) * intervalLength) / percents.length;
        paint.setStrokeWidth(3);
        paint.setColor(Color.WHITE);
        canvas.drawLine(80, 20, 80, height - 200, paint);
        canvas.drawLine(80, height - 200, width - 100, height - 200, paint);
        for (int i = 0; i < percents.length; i++) {
            drawHistogram(canvas, i);
        }
    }

    private void drawHistogram(Canvas canvas, int position) {
        RectF rectF = new RectF();
        rectF.left = intervalLength + (intervalLength + histogramItemWidth) * position + 80;
        rectF.top = getHeight() - 200 - histogramHeight * percents[position] / 100;
        rectF.bottom = getHeight() - 200;
        rectF.right = intervalLength + (intervalLength + histogramItemWidth) * position + histogramItemWidth + 80;
        System.out.println(rectF.toString());
        paint.setColor(Color.GREEN);
        canvas.drawRect(rectF, paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        RectF targetRect = new RectF(rectF.left, getHeight() - 200, rectF.right, getHeight() - 140);
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        float baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(strings[position], targetRect.centerX(), baseline, paint);
    }

}
