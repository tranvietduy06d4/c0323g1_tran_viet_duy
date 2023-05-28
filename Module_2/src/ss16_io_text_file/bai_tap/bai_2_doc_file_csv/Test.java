package ss16_io_text_file.bai_tap.bai_2_doc_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Nation> nationList = readFileToList("src/ss16_io_text_file/bai_tap/bai_2_doc_file_csv/nation.csv");
        System.out.println(nationList);
    }


    static List<Nation> readFileToList(String path) {
        List<Nation> nationList = new ArrayList<>();
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while (true) {
                try {
                    if (!((line = bufferedReader.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String[] nationArray = line.split(",");
                Nation nation = new Nation(Integer.parseInt(nationArray[0]), nationArray[1], nationArray[2]);
                nationList.add(nation);
            }
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("File nguồn không được điền đầy đủ thông tin. Vui lòng kiểm tra lại");
            a.getStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return nationList;

    }
}
