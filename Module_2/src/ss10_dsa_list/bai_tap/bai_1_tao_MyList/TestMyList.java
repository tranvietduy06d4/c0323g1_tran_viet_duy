package ss10_dsa_list.bai_tap.bai_1_tao_MyList;

import java.util.Arrays;

public class TestMyList {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(5);
        myList.add(0, 0);
        myList.add(1, 1);
        myList.add(2, 2);
        myList.add(3, 3);
        myList.add(4, 4);
        myList.add(5, 5);

        myList.add(5);
        myList.remove(2);

    }
}
