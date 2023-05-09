package ss2_loop_statement.bai_tap.bai_1_hien_thi_cac_hinh;

import java.util.Scanner;

public class ShapesDraw {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the square triangle");
            System.out.println("3. Draw the isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the rectangle");
                    System.out.println("Please enter the width of rectangle:");
                    int width = input.nextInt();
                    System.out.println("Please enter the length of rectangle:");
                    int length = input.nextInt();
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < length; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Draw the square triangle");
                    System.out.println("Please enter the height of square triangle:");
                    int height = input.nextInt();
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }

                    for (int i = 0; i < height; i++) {
                        for (int j = height - 1; j >= i; j--) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }

                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < height; j++) {
                            if (j >= i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }

                    for (int i = 0; i < height; i++) {
                        for (int j = height - 1; j >= 0; j--) {
                            if (j <= i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }

                    break;


                case 3:
                    System.out.println("Draw the isosceles triangle");
                    System.out.println("Please enter the height of square triangle:");
                    int heightOfTriangle = input.nextInt();
                    for (int i = 0; i < heightOfTriangle; i++) {
                        for (int j = -heightOfTriangle; j <= heightOfTriangle; j++) {
                            if (j >= -i && j <= i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
