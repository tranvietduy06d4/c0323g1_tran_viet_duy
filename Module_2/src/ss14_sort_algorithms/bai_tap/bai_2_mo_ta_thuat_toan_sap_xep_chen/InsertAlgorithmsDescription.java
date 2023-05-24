package ss14_sort_algorithms.bai_tap.bai_2_mo_ta_thuat_toan_sap_xep_chen;

import java.util.Arrays;

public class InsertAlgorithmsDescription {
    public static void main(String[] args) {
        int[] array = {7,2,5,9,4}; // Khởi tạo 1 mảng số nguyên
        System.out.println("Mảng ban đầu: " +Arrays.toString(array));
        insertIntegerArray(array); // Gọi method insertIntegerArray, truyền các đối số vào method : mảng array


    }

    // Thiết lập method với chức năng chèn 1 số nguyên bất kì vào mảng
    public static void insertIntegerArray (int[] array) {
        int element; // Khai báo biến element để lưu giá trị của phần tử đem đi so sánh và chèn
        int position; // Khai báo biến position để lưu giá trị index của phần tử đem đi so sánh và chèn (element)
        for (int i = 1; i < array.length; i++) {
            System.out.println("- Bắt đầu lần sắp xếp thứ " +i +" tại phần tử có vị trí index =  " +i);
            element = array[i]; // Dùng biến element để lấy ra phần tử array[i] đi so sánh và chèn
            position = i;       // Con trỏ đến phần tử cần so sánh
            while (position>0 && element < array[position-1]) { // Vòng lặp để sắp xếp phần tử
                array[position] = array[position-1];   // Đổi chỗ (trái sang phải; dịch chuyển phần tử vị trí [position-1] sang vị trí [position]
                System.out.println("Do phần tử " +element +" < phần tử " +array[position-1] + " nên dịch chuyển phần tử " +array[position-1] +" sang phải" );
                position--;
            }
            array[position] = element; // Gán giá trị của element cho phần tử vị trí [position] (chèn)
            System.out.println("Chèn giá trị của " +element +" vào vị trí index =  " +position);
            System.out.println("Mảng sau lần sắp xếp thứ " +i +":\n" +Arrays.toString(array));
        }
        System.out.println("Mảng hoàn thiện sau sắp xếp là: " +Arrays.toString(array)); // Hiển thị các phần tử của mảng array
    }
}
