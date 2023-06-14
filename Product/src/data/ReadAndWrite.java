package data;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<String> readFile(String path) {
        List<String> strings = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
            bufferedReader.close();

        } catch (FileNotFoundException f) {
            System.out.println("Không tìm thấy file");
        } catch (IOException ioException) {
            System.out.println("Lỗi đọc file");
        }

        return strings;

    }

    public static void writeFile(String path, List<String> string, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(path,append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String str:string) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (FileNotFoundException f) {
            System.out.println("File không tồn tại");
        } catch (IOException ioException) {
            System.out.println("Lỗi ghi file");
        }


    }
}
