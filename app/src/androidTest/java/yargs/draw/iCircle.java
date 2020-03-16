package yargs.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class iCircle extends View {
    public iCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制一个圆
        canvas.drawCircle(300, 300, 200, paint);
    }
}
