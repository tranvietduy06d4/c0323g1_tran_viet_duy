package ss17_iobinary_file_and_serialization.bai_tap.bai_tap_2_copy_file_nhi_phan;

import java.io.File;
import java.io.FileNotFoundException;
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
        copyFileToFile.writeToFile(integerList,"src/ss17_iobinary_file_and_serialization/bai_tap/bai_tap_2_copy_file_nhi_phan/interger_lits.dat");

        Scanner scanner = new Scanner(System.in);
        String path = null;
        while (true) {
            System.out.println("Vui lòng nhập vào đường dẫn của file cần sao chép: ");
            try {
                path = scanner.nextLine();
                File file = new File(path);
                if(!file.exists()) {
                    
                }
            } catch (FileNotFoundException f) {

            }


        }
        List<Integer> copyOfIntegerList = copyFileToFile.readFromFile(path);
        System.out.println(copyOfIntegerList);

    }
}
