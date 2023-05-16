package ss7_abstract_class_and_interface.bai_tap.bai_1_trien_khai_interface_resizeable;

public class Circle extends Shape implements Resizeable {
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
    public void resize(double percent) {
        setRadius(getRadius()*percent/100);
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + " Area of this circle is: "
                + getArea();
    }
}
