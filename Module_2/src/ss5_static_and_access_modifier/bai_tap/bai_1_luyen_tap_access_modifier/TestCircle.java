package ss5_static_and_access_modifier.bai_tap.bai_1_luyen_tap_access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(10, "Green");
        circle1.setRadius(8);
        circle1.setColour("Yellow");
        System.out.println(circle1.toString());
        System.out.println(circle2.toString());
    }
}
