package ss4_class_and_object.bai_tap.bai_2_stop_watch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 1 to start count time: ");
        int begin = scanner.nextInt();
        while (begin != 1) {
            System.out.println("Wrong. Please enter 1 again to start count time: ");
            begin = scanner.nextInt();
        }
        stopWatch.start();

        System.out.println("Please enter 2 to end count time: ");
        int end = scanner.nextInt();
        while (end != 2) {
            System.out.println("Wrong. Please enter 2 again to start count time: ");
            end = scanner.nextInt();
        }
        stopWatch.end();
        long result = stopWatch.getElapsedTime();
        System.out.println("Result is: " + result + " milliseconds");
    }
}
