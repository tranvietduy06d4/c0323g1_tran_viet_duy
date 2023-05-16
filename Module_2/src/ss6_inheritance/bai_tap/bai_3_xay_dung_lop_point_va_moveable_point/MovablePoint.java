package ss6_inheritance.bai_tap.bai_3_xay_dung_lop_point_va_moveable_point;

import java.util.Arrays;

public class MovablePoint extends Point {
    private float xSpeed;
    private float ySpeed;
    float[] arraySpeed = new float[2];

    public MovablePoint() {

    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
    }

    public float[] getSpeed() {
        arraySpeed[0] = getXSpeed();
        arraySpeed[1] = getYSpeed();
        return arraySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" + '(' + getX() + ',' + getY() + ')' +
                "Speed=" + Arrays.toString(getSpeed()) +
                '}';
    }
    public String move() {
        setX(getX()+getXSpeed());
        setY(getY()+getYSpeed());
        return this.toString();
    }
}
