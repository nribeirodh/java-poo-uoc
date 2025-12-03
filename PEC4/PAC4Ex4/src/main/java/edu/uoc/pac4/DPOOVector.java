package edu.uoc.pac4;

public class DPOOVector<T> {


    private T[] elements;
    private int size;


    @SuppressWarnings("unchecked")
    public DPOOVector(int capacity) {
        elements = (T[]) new Object[capacity];
        size = 0;
    }


    public boolean add(T elem) {
        if (elem == null) {
            return false;
        }
        if (size >= elements.length) {
            return false;
        }
        elements[size] = elem;
        size++;
        return true;
    }


    public int size() {
        return size;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return elements[index];
    }


    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }
}
