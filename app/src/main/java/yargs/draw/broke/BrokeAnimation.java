package yargs.draw.broke;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

public class BrokeAnimation extends ValueAnimator {
    private static final int DEFAULT_DURATION = 1500;
    private BrokeModel[][] mParticles;
    private Paint mPaint;
    private View mContainer;

    public BrokeAnimation(View view, Bitmap bitmap, Rect bound) {
        setFloatValues(0.0f, 1.0f);
        setDuration(DEFAULT_DURATION);

        mPaint = new Paint();
        mContainer = view;
        mParticles = generateParticles(bitmap, bound);
    }

    // 生成粒子，按行按列生成全部粒子
    private BrokeModel[][] generateParticles(Bitmap bitmap, Rect bound) {
        int w = bound.width();
        int h = bound.height();

        // 横向粒子的个数
        int horizontalCount = w / BrokeModel.PART_WH;
        // 竖向粒子的个数
        int verticalCount = h / BrokeModel.PART_WH;

        // 粒子宽度
        int bitmapPartWidth = bitmap.getWidth() / horizontalCount;
        // 粒子高度
        int bitmapPartHeight = bitmap.getHeight() / verticalCount;

        BrokeModel[][] particles = new BrokeModel[verticalCount][horizontalCount];
        for (int row = 0; row < verticalCount; row++) {
            for (int column = 0; column < horizontalCount; column++) {
                //取得当前粒子所在位置的颜色
                int color = bitmap.getPixel(column * bitmapPartWidth, row * bitmapPartHeight);

                Point point = new Point(column, row);
                particles[row][column] = new BrokeModel(color, bound, point);
            }
        }
        return particles;
    }

    // 由view调用，在View上绘制全部的粒子
    void draw(Canvas canvas) {
        // 动画结束时停止
        if (!isStarted()) {
            return;
        }
        // 遍历粒子，并绘制在View上
        for (BrokeModel[] particle : mParticles) {
            for (BrokeModel p : particle) {
                p.advance((Float) getAnimatedValue());
                mPaint.setColor(p.color);
                // 错误的设置方式只是这样设置，透明色会显示为黑色
                // mPaint.setAlpha((int) (255 * p.alpha));
                // 正确的设置方式，这样透明颜色就不是黑色了
                mPaint.setAlpha((int) (Color.alpha(p.color) * p.alpha));
                canvas.drawCircle(p.cx, p.cy, p.radius, mPaint);
            }
        }
        mContainer.invalidate();
    }

    @Override
    public void start() {
        super.start();
        mContainer.invalidate();
    }
}
