package yargs.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class iCirecle extends View {
    public iCirecle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(0x99880000); // 设置颜色
        paint.setStyle(Paint.Style.FILL); // FILL 实心 STROKE空心 FILL_AND_STROKE两种模式一起
        paint.setStrokeWidth(0); // 设置线条宽度或点的宽度 上一个模式设为空心或者FILL_AND_STROKE才有用
        paint.setTextSize(18); // 设置文字大小
        paint.setAntiAlias(true);  // 设置抗锯齿开关 这个几乎可以说默认就得开着，不然图形很难看
        canvas.drawColor(0x00ffffff); // 设置前景色
        // 绘制一个圆
        Log.e("onDraw: ",getWidth()+"");
        Log.e("onDraw: ",getHeight()+"");
        canvas.drawCircle(getWidth()-100, 0, 200, paint);
        canvas.drawCircle(getWidth()-200, 200, 50, paint);
        // 绘制一个正方形
                // 这里上下左右的意思是每个点在屏幕的位置，相减得到的才是正方形的宽
        canvas.drawRect(getWidth()-200, 250, getWidth()-10, 500, paint);
        // 绘制一个点
        paint.setStrokeWidth(50); // 点的大小
        paint.setStrokeCap(Paint.Cap.ROUND); // 圆头ROUND  平头BUTT  方头SQUARE
        canvas.drawPoint(getWidth()-100, 550,paint);

        // 绘制一群点
        float[] pointsA = {0, 0, getWidth()-200, 600,getWidth()-50, 600, getWidth()-200, 700, getWidth()-50, 700}; // 两个是一个点 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
        canvas.drawPoints(pointsA, 2 /* 跳过两个数，即前两个 0 */, 8 /* 一共绘制 8 个数（4 个点）*/, paint);

        // 绘制一个椭圆 只能画横着的或竖着的
        canvas.drawOval(getWidth()-200, 800, getWidth()-50, 900, paint);

        // 绘制一条线
        paint.setStrokeWidth(10);
        canvas.drawLine(getWidth()-200, 1000, getWidth()-50, 1050, paint);

        // 绘制一条折线
            //这的折线不是每个点连起来，这里还是两组两组画一条线
        float[] pointsB = {getWidth()-200, 1100, getWidth()-50, 1100, getWidth()-50, 1100, getWidth()-50, 1200,getWidth()-50, 1200, getWidth()-200, 1150, getWidth()-50, 1150};
        canvas.drawLines(pointsB, paint);

        // 绘制一个圆角矩形 left , top , right , bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向 半径。
        canvas.drawRoundRect(50, 500, 250, 600, 50, 50, paint);

        // 绘制扇
        canvas.drawArc(50, 700, 250, 900, -110, 110, true, paint);
        paint.setColor(0x99ff4f02); // 设置颜色
        canvas.drawArc(50, 700, 250, 900, 0, 90, true, paint);
        paint.setColor(0x99ff0000); // 设置颜色
        canvas.drawArc(50, 700, 250, 900, 90, 160, true, paint);

        // 绘制弧形
        paint.setColor(0x99880000); // 设置颜色
        canvas.drawArc(50, 800, 250, 1050, 20, 140, false, paint);
        paint.setStyle(Paint.Style.STROKE); // 画线模式
        canvas.drawArc(50, 800, 250, 1050, 140, 80, false, paint);



        //绘制自定义形状 心形
        paint.setStyle(Paint.Style.FILL); // 画线模式
        Path pathA = new Path();
        pathA.addArc(200, 200, 400, 400, -225, 225);
        pathA.arcTo(400, 200, 600, 400, -180, 225, false);
        pathA.lineTo(400, 542);
        canvas.drawPath(pathA,paint);

        //绘制自文字
        paint.setTextSize(50);
        canvas.drawText("大家好，我是张三", 50, 400, paint);

        //绘制直线 且闭合
        Path pathB = new Path();
        pathB.moveTo(50, 1300); // 由于这种绘制方法，下一个点永远是以上一个点为相对中心，moveTo,虽然是移动起点，也相当于是移动整个形状
        pathB.lineTo(200, 1200); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
        pathB.rLineTo(-200, 0); // 由当前位置 (100, 100) 向正右方 100 像素的位置画一
        pathB.close();
        canvas.drawPath(pathB,paint);

        //绘制贝塞尔曲线 且闭合
        paint.setStyle(Paint.Style.STROKE); // 画线模式
        Path pathC = new Path();
        pathC.moveTo(100, 500);
        pathC.quadTo(300, 100, 600, 500);
        pathC.rQuadTo(350, 350,100,100); // 由当前位置 (100, 100) 向正右方 100 像素的位置画一
//        pathC.close();
        canvas.drawPath(pathC,paint);

    }
}
