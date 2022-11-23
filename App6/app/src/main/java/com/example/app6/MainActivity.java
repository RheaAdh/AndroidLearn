package com.example.app6;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout llMainContainer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomView view = new CustomView(this);
//        setContentView(view);

        setContentView(R.layout.activity_main);
        CustomCircle customCircle = new CustomCircle(this);
        llMainContainer=findViewById(R.id.linLayout);
//        llMainContainer.addView(customCircle);
        llMainContainer.addView(view);
    }

    private class CustomCircle extends View{

        public CustomCircle(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            canvas.drawCircle(500,500,100,paint);
        }

    }

    private class CustomView extends View{

        public CustomView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(Color.BLUE);
            canvas.drawRect(500,700,700,1000,paint);

            paint.setColor(Color.BLACK);
            paint.setTextSize(100);

            canvas.rotate(-15);
            canvas.save();
            canvas.rotate(-45);
            canvas.drawText("Graphics Demo",-400,500,paint);
            canvas.restore();
            canvas.drawText("Graphics Demo",0,500,paint);
        }
    }
}