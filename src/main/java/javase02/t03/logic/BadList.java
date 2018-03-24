package javase02.t03.logic;


import lombok.Getter;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Iterator;

public class BadList<T>{
    private Object[] list;

    private int capacity;
    @Getter
    private int size;
    private static final double EXPAND_SIZE = 1.5;

    public BadList() {
        capacity = 4;
        size = 0;
        list = new Object[capacity];
    }

    public void add(T value) {
        if (size == capacity) {
            capacity = (int) (capacity * EXPAND_SIZE);
            Object[] expandedList = new Object[capacity];
            System.arraycopy(list, 0, expandedList, 0, size);
            list = expandedList;
        }

        ++size;
        list[size - 1] = value;
    }

    public boolean remove(T value) {
        int indexToDelete = findIndexOf(value);
        if (indexToDelete < 0)
            return false;

        // 0 1 2 3 4 5 -> 3, size = 6 -> size - index - 1 = 2 ->
        if (indexToDelete == size - 1)
            list[indexToDelete] = null;
        else {
            System.arraycopy(list, indexToDelete + 1, list, indexToDelete, size - indexToDelete - 1);
            list[size - 1] = null;
        }
        --size;

        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        return (T) list[index];
    }

    public int findIndexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(list[i]))
                return i;
        }
        return -1;
    }

    public void sort(Comparator<T> comparator) {
        quicksort(0, size - 1, comparator);
    }

    private void quicksort(int lo, int hi, Comparator<T> comparator) {
        if (lo < hi) {
            int p = partition(lo, hi, comparator);
            quicksort(lo, p - 1, comparator);
            quicksort(p + 1, hi, comparator);
        }
    }

    private int partition(int lo, int hi, Comparator<T> comparator) {
        T pivot = (T) list[hi];

        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (comparator.compare((T) list[j], pivot) < 0) {
                ++i;
                swap(i, j);
            }
        }
        swap(i + 1, hi);
        return i + 1;
    }

    private void swap(int index1, int index2) {
        Object o = list[index1];
        list[index1] = list[index2];
        list[index2] = o;
    }

    public T[] toArray(Class<T> tClass){
        T[] arr = (T[])Array.newInstance(tClass, size);
        System.arraycopy(list, 0, arr, 0, size);
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Object o :
                list) {
            if (o == null) {
                str.append("null");
            } else
                str.append(((T) o).toString());
            str.append(", ");
        }
        return str.toString();
    }
}
