package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    Path path1=new Path();
    float radius = 120;

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        paint.setStyle(Paint.Style.FILL);
        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;
        path.addArc(centerX - radius * 2, centerY - radius, centerX, centerY + radius, 130, 230);
        path.lineTo(centerX, centerY + 300);
//        double temp = Math.sqrt(7200);
//        double x = centerX - radius - temp;
//        double y = centerY + temp;
//        path.lineTo((float) x, (float) y);
        canvas.drawPath(path, paint);
        path1.addArc(centerX, centerY - radius, centerX + 2 * radius, centerY + radius, 180, 215);
        path1.lineTo(centerX, centerY + 300);
        canvas.drawPath(path1,paint);
    }
}
