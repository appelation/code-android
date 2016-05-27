package com.appleation.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by DELL7537 on 02-03-2016.
 */
public class DrawLine extends View {
    Paint paint = new Paint();

    public DrawLine(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(0, 0, 20, 20, paint);
        canvas.drawLine(20, 0, 0, 20, paint);
    }
}

//******* Usage ********
//drawView = new DrawView(this);
//drawView.setBackgroundColor(Color.WHITE);
//setContentView(drawView);