package ss17_iobinary_file_and_serialization.bai_tap.bai_tap_2_copy_file_nhi_phan;

import java.io.*;
import java.util.List;

public class CopyFileToFile implements Serializable {

    public List<Integer> readFromFile (String path) {
        List<Integer> integerList = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            integerList = (List<Integer>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException f) {
            System.out.println("Không tìm thấy file");
        } catch (IOException i) {
            System.out.println("File rỗng");;
        } catch (Exception e) {
            System.out.println("Error!!!");
        }
        return integerList;
    }
    public void writeToFile (List<Integer> integerList, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(integerList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException f) {
            System.out.println("Không tìm thấy file");
        } catch (IOException i) {
            System.out.println("File rỗng");
        } catch (Exception e) {
            System.out.println("Error!!!!");
        }


    }

}
