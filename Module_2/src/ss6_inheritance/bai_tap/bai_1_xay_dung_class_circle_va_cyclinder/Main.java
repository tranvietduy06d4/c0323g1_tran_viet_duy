package ss6_inheritance.bai_tap.bai_1_xay_dung_class_circle_va_cyclinder;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(10, "Blue");
        System.out.println(circle1.toString());
        Cylinder cylinder1 = new Cylinder(15, "Red", 20);
        System.out.println(cylinder1.toString());
    }
}
