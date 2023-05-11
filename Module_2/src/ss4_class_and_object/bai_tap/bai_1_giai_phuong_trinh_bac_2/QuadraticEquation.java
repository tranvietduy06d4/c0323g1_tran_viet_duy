package ss4_class_and_object.bai_tap.bai_1_giai_phuong_trinh_bac_2;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public double getRoot1() {
        return (getDiscriminant() - b) / 2 * a;
    }

    public double getRoot2() {
        return (-getDiscriminant() - b) / 2 * a;
    }
}
