package ss7_abstract_class_and_interface.bai_tap.bai_2_trien_khai_interface_colorable;

import ss7_abstract_class_and_interface.bai_tap.bai_1_trien_khai_interface_resizeable.Resizeable;

public class Circle extends Shape{
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }


    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + " Area of this circle is: "
                + getArea();
    }
}