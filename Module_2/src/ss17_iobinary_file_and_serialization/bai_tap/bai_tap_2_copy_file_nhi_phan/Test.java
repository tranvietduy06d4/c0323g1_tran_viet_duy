package ss17_iobinary_file_and_serialization.bai_tap.bai_tap_2_copy_file_nhi_phan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        CopyFileToFile copyFileToFile = new CopyFileToFile();
        copyFileToFile.writeToFile(integerList, "src/ss17_iobinary_file_and_serialization/bai_tap/bai_tap_2_copy_file_nhi_phan/interger_lits.dat");

        Scanner scanner = new Scanner(System.in);
        String sourcePath = null;
        boolean checkSourcePath = true;

        while (checkSourcePath) {
            System.out.println("Vui lòng nhập vào đường dẫn của file nguồn cần sao chép: ");
            sourcePath = scanner.nextLine();
            File file = new File(sourcePath);
            if (file.exists()) {
                checkSourcePath = false;
            } else {
                System.out.println("Không tìm thấy file");

            }
        }
        List<Integer> newIntegerList = copyFileToFile.readFromFile(sourcePath);

        String destinationPath = null;
        boolean checkDestinationPath = true;
        while (checkDestinationPath) {
            System.out.println("Vui lòng nhập vào đường dẫn của file đích đến: ");
            sourcePath = scanner.nextLine();
            File file = new File(sourcePath);
            if (file.exists()) {
                checkDestinationPath = false;
            } else {
                System.out.println("Không tìm thấy file");
            }
        }
        copyFileToFile.writeToFile(newIntegerList,sourcePath);

    }
}

