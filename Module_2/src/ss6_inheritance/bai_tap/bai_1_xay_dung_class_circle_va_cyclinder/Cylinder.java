package ss6_inheritance.bai_tap.bai_1_xay_dung_class_circle_va_cyclinder;

public class Cylinder extends Circle {

    private double height;

    public Cylinder(double radius, String colour, double height) {
        super(radius, colour);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(double radius, double height) {
        double volume = PI * this.getRadius() * this.getRadius() * this.getHeight();
        return volume;
    }

    @Override
    public double getAcreage(double radius) {
        double acreage = 2 * PI * this.getRadius() * (this.getRadius() * this.getHeight());
        return acreage;
    }

    @Override
    public String toString() {
        return "Radius: " + this.getRadius() + " Colour: " + this.getColour() + " Height: " + this.getHeight() + " Acreage: " + this.getAcreage(this.getRadius());
    }

}
