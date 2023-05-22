package ss12_java_collection_framework.bai_tap.bai_1_dem_so_lan_xuat_hien_cua_tu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCounter {
    public static void main(String[] args) {
        String string = "Khong xong viec khong ve";
        stringMap(string);
    }

    public static void stringMap(String string) {
        String lowerString = string.toLowerCase();
        String[] newString = lowerString.split("\\s+");

        Map<String, Integer> wordMap = new HashMap<>();
        int count;

        for (int i = 0; i < newString.length; i++) {
            count = 0;
            for (int j = 0; j < newString.length; j++) {
                if (newString[i].equals(newString[j])) {
                    count++;
                }
            }
            System.out.println(count);
            wordMap.put(newString[i], count);
        }

        Set<String> wordSet = wordMap.keySet();
        for (String str : wordSet) {
            System.out.println("Từ: " + str + " xuất hiện " + wordMap.get(str) + " lần trong chuỗi\n");
        }

    }

}
