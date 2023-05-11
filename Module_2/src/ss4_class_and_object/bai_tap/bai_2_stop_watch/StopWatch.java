package ss4_class_and_object.bai_tap.bai_2_stop_watch;

import java.util.Scanner;

public class StopWatch {
    long startTime;
    long endTime;


    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void end() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        long result = endTime - startTime;
        return result;
    }
}
