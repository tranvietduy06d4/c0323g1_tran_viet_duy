package ss4_class_and_object.bai_tap.bai_3_xay_dung_lop_fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setOn(true);
        fan1.setSpeed(3);
        fan1.setColor("Yellow");
        fan1.setRadius(10);

        fan2.setSpeed(2);
        fan2.setColor("Blue");
        fan2.setRadius(5);

        System.out.println(fan1);
        System.out.println(fan2);
    }
}
