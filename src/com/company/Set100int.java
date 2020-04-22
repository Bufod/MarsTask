package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Set100int {

    private ArrayList[] array;
    private int capacity;

    public Set100int(int capacity) {
        this.capacity = capacity;
        array = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = new ArrayList();
        }
    }

    public boolean add(Object e) {
        int hcode = e.hashCode() % capacity;
        if (array[hcode].contains(e))
            return false;
        else {
            array[hcode].add(e);
            return true;
        }
    }

    public void clear() {
        for (ArrayList ai : array)
            ai.clear();
    }

    public boolean contains(Object e) {
        int hcode = e.hashCode() % capacity;
        return array[hcode].contains(e);
    }

    public boolean remove(Object e) {
        int hcode = e.hashCode() % capacity;
        if (array[hcode].contains(e))
            return false;
        else {
            array[hcode].remove(e);
            return true;
        }
    }

    @Override
    public String toString() {

        String res = "";
        for (int i = 0; i < capacity; i++){
            res += i + ":" + array[i].toString() + "\n";
        }
        return res;
    }
}
