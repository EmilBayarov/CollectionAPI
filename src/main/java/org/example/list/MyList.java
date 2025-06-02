package org.example.list;

import org.example.MyCollection;

public interface MyList<E> extends MyCollection<E> {
    boolean add(E e);
    void add(int index, E e);
    E remove(int index);
    E get(int index);
    int indexOf(E e);
    int size();

}
