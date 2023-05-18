package ss10_dsa_list.bai_tap.bai_1_tao_MyList;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        this.size = capacity;
        elements = new Object[capacity];
    }

    void add(int index, E newElement) {
        ensureCapacity(elements.length);
        if (index > elements.length) {
            throw new IndexOutOfBoundsException("index: " + index + " outside the element length: ");
        } else {
            for (int i = elements.length - 1; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = newElement;
            size++;
        }
    }


    E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Wrong. Do not have this position on element :");
        } else {
            E removeElement = (E) elements[index];
            elements[index] = null;
            return removeElement;
        }

    }
    

    int size() {
        return this.size;
    }

    void ensureCapacity(int capacity) {
        if (size == capacity) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    public E clone() {
        //coming soon
        return null;

    }

    public boolean contains(E o) {
        //coming soon
        return false;

    }

}

