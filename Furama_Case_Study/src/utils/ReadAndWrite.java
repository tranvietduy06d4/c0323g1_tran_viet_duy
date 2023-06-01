package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<String> readFile(String path) {
        List<String> string = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine()) !=null) {
                string.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");;
        } catch (IOException i) {
            System.out.println("Input Output Error");
        } catch (Exception e) {
            System.out.println("Errors!!!");
        }
        return string;

    }
    public static void writeFile (String path,List<String> string, boolean append) {
        try{
            FileWriter fileWriter = new FileWriter(path, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String str:string) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (FileNotFoundException f) {
            System.out.println("File not found");
        } catch (IOException i) {
            System.out.println("Input Output Error");
        } catch (Exception e) {
            System.out.println("Errors!!!");
        }

    }
}
