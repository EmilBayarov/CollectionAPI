package org.example.stack;

import java.util.ArrayList;

public class MyStack<E> extends ArrayList<E> {
    public MyStack() {}

    public E push(E e) {
        addElement(e);
        return e;
    }

    private synchronized void addElement(E e) {
        super.add(e);
    }

    public synchronized E pop() {
        E obj;
        int len = size();
        obj = peek();
        remove(len-1);
        return obj;
    }

    public synchronized E peek() {
        int len = size();
        if (len==0)
            throw new IllegalArgumentException("Stack is empty");
        return get(len-1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }


}
