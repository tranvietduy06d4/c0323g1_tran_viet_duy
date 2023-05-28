package ss16_io_text_file.bai_tap.bai_1_copy_file_text;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyFileTest {
    public static void main(String[] args) {
        String newString;
        try {
            newString = readFile("src/ss16_io_text_file/bai_tap/bai_1_copy_file_text/test.txt");
            System.out.println(newString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writeFileToFile(newString, "src/ss16_io_text_file/bai_tap/bai_1_copy_file_text/new.txt");
        System.out.println("Số kí tự có trong file đã cho là: " + newString.length());
    }

    static String readFile(String path) throws IOException {
        String string = "";
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File không tồn tại");
            throw new FileNotFoundException();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                string += line + "\n";
            }
        } catch (IOException e) {
            throw new IOException();

        }
        return string;
    }


    static void writeFileToFile(String string, String destinationPath) {
        File file = new File(destinationPath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(string);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
