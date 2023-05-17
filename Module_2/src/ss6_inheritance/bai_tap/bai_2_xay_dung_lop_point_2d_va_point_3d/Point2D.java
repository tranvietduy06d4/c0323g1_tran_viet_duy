package ss6_inheritance.bai_tap.bai_2_xay_dung_lop_point_2d_va_point_3d;

import java.util.Arrays;

public class Point2D {
    private float x;
    private float y;

    public Point2D() {

    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.setX(x);
        this.setY(y);
    }

    public float[] getXY() {
        float[] arrayXY = new float[2];
        arrayXY[0] = getX();
        arrayXY[1] = getY();
        return arrayXY;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "arrayXY=" + Arrays.toString(this.getXY()) +
                '}';
    }
}
