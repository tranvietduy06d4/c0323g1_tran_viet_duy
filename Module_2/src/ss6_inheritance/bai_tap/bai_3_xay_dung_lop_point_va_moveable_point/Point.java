package ss6_inheritance.bai_tap.bai_3_xay_dung_lop_point_va_moveable_point;

import java.util.Arrays;

public class Point {
    private float x;
    private float y;

    public Point() {

    }

    public Point(float x, float y) {
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
        arrayXY[0] = x;
        arrayXY[1] = y;
        return arrayXY;
    }

    @Override
    public String toString() {
        return "Point{" +
                "arrayXY=" + Arrays.toString(getXY()) +
                '}';
    }
}
