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
    public boolean add(E e) {
        ensureCapacity(elements.length);
        elements[size+1] = e;
        return true;
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

    public E[] clone() {
        Object[] newElement = new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            newElement[i] = elements[i];
        }
        return (E[]) newElement;
    }

    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

}

