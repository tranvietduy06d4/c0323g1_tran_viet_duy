package ss5_static_and_access_modifier.bai_tap.bai_1_luyen_tap_access_modifier;

public class Circle {
    private double radius = 1.0;
    private String colour = "red";

    private static double pi = 3.14;

    public Circle() {
    }

    public Circle(double radius, String colour) {
        this.radius = radius;
        this.colour = colour;
    }

    public double getRadius() {
        return radius;
    }

    public String getColour() {
        return colour;
    }

    private double getArea() {
        return pi * this.getRadius() * this.getRadius();
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", colour='" + colour + '\'' +
                ",acreage = " + this.getArea() + '}';
    }
}
