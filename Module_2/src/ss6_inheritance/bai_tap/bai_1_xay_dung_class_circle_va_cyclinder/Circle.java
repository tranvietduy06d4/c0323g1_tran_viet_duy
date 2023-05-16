package ss6_inheritance.bai_tap.bai_1_xay_dung_class_circle_va_cyclinder;

public class Circle {
    private double radius;
    private String colour;
    protected static final double PI = 3.14;

    public Circle(double radius, String colour) {
        this.radius = radius;
        this.colour = colour;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getAcreage(double radius) {
        this.setRadius(radius);
        double acreage = PI * this.getRadius() * this.getRadius();
        return acreage;
    }

    @Override
    public String toString() {
        return "Radius: " +this.getRadius() +" Colour: " +this.getColour() +" Acreage: " + this.getAcreage(this.getRadius());
    }
}
