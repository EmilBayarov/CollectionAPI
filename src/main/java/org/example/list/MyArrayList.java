package org.example.list;

import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_SIZE = 10;
    private static final Object[] EMPTY_DATA = {};


    public MyArrayList() {
        this.elementData = EMPTY_DATA;
    }

    public MyArrayList(int capacity) {
        if (capacity>0 ) {
            this.elementData = new Object[capacity];
        } else if (capacity == 0) {
            this.elementData = EMPTY_DATA;
        } else {
            throw new IllegalArgumentException("Illegal capacity "+capacity);
        }
    }

    @Override
    public boolean add(E e) {
        add(e, elementData, size);
        return false;
    }

    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s+1;
    }

    private Object[] grow() {
        return grow(size+1);
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != EMPTY_DATA) {
            int newCapacity = MyArrayUtil.findNewLength(oldCapacity, minCapacity - oldCapacity, oldCapacity >> 1);
            return elementData = MyArrayUtil.copyArray(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_SIZE, minCapacity)];
        }
    }

    @Override
    public void add(int index, E e) {
        MyArrayUtil.checkIndex(index, size);
        final int s;
        Object[] elementData;
        if ((s= size) == (elementData = this.elementData).length)
            elementData = grow();
        this.elementData = MyArrayUtil.copyArray(elementData, index, size+1);
        this.elementData[index] = e;
        size = s +1;
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size);
        Object[] es  = elementData;
        E oldValue = (E) es[index];
        fastRemove(es, index);
        size--;
        return oldValue;
    }

    private void fastRemove(Object[] es, int index) {
        Object[] newArr = new Object[es.length-1];
        for (int i = 0; i < newArr.length; i++) {
            if (i<index) newArr[i] = es[i];
            else {
                newArr[i] = es[i+1];
            }
        }
        this.elementData = newArr;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    private E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public int indexOf(E e) {
        if (e==null) {
            for (int i=0;i<size;i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i=0;i<size;i++) {
                if (e.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    public void sort(Comparator<E> comparator) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                E a = (E) elementData[i];
                E b = (E) elementData[j];
                if (comparator.compare(a, b) > 0) {
                    elementData[i] = b;
                    elementData[j] = a;
                }
            }
        }
    }
}
