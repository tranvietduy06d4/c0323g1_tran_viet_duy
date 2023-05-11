package ss4_class_and_object.bai_tap.bai_3_xay_dung_lop_fan;

public class Fan {

    private final int SLOW = 1;
    private final int MEDIUM = 1;
    private final int FAST = 1;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (isOn() == true) {
            return "Fan is ON. Speed is: " + getSpeed() + " colour: " + getColor() + " radius: " + getRadius();
        } else {
            return "Fan is OFF" + " colour: " + getColor() + " radius: " + getRadius();
        }
    }
}
