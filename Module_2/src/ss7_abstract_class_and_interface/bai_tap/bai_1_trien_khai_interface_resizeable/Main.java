package ss7_abstract_class_and_interface.bai_tap.bai_1_trien_khai_interface_resizeable;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(6);
        shapes[1] = new Rectangle(6, 18);
        shapes[2] = new Square(9);
        System.out.println("Array before change value: ");
        System.out.println(Arrays.toString(shapes));

        ((Resizeable) shapes[0]).resize(40);
        ((Resizeable) shapes[1]).resize(50);
        ((Resizeable) shapes[2]).resize(60);
        System.out.println("Array after change value: ");
        System.out.println(Arrays.toString(shapes));
    }
}
