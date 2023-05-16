package ss7_abstract_class_and_interface.bai_tap.bai_2_trien_khai_interface_colorable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(5);
        shapes[1] = new Square(9);
        shapes[2] = new Circle(15);

        System.out.println(Arrays.toString(shapes));
        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                ((Square) shape).howToColor();
            }
        }


    }
}
