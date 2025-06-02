package org.example.list;

public class MyArrayUtil {
    public static Object[] copyArray(Object[] elementData, int newCapacity) {
        Object[] newArr = new Object[newCapacity];
        for (int i = 0; i < elementData.length; i++) {
            newArr[i] = elementData[i];
        }
        return newArr;
    }

    public static int findNewLength(int oldCapacity, int min, int max) {
        return oldCapacity + (Math.max(min, max));
    }

    public static void checkIndex(int index, int size) {
        if (index<0 || size<index)
            throw new IndexOutOfBoundsException("Index out of size");
    }

    public static Object[] copyArray(Object[] elementData, int index, int newCapacity) {
        Object[] newArr = new Object[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            if (i<index) newArr[i] = elementData[i];
            else if (i>index) {
                newArr[i] = elementData[i-1];
            } else {
                newArr[index] = null;
            }
        }
        return newArr;
    }
}
