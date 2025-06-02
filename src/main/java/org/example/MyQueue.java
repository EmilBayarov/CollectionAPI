package org.example;

import org.example.list.MyArrayUtil;

import java.util.Comparator;

public class MyQueue<E> {
    private static final int DEFAULT_CAPACITY = 11;
    private int size;
    private Object[] queue;
    private final Comparator<? super E> comparator;

    public MyQueue() {
        this(DEFAULT_CAPACITY, null);
    }

    public MyQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    public MyQueue(Comparator<? super E> comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }

    public MyQueue(int initialCapacity,
                   Comparator<? super E> comparator) {
        if (initialCapacity<1)
            throw new IllegalArgumentException("Initial capacity error");
        this.comparator = comparator;
        this.queue = new Object[initialCapacity];
    }

    public boolean add(E e) {
        return offer(e);
    }

    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException("You can not add null element into my queue");
        int i = size;
        if (i >= queue.length)
            grow(i+1);
        shiftUp(i,e);
        size = i + 1;
        return true;
    }

    private void shiftUp(int i, E e) {
        if (comparator != null)
            siftUpUsingComparator(i, e, queue, comparator);
        else
            siftUpComparable(i, e, queue);
    }

    private static <T> void siftUpComparable(int k, T x, Object[] es) {
        Comparable<? super T> key = (Comparable<? super T>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = es[parent];
            if (key.compareTo((T) e) >= 0)
                break;
            es[k] = e;
            k = parent;
        }
        es[k] = key;
    }

    private static <T> void siftUpUsingComparator(
            int k, T x, Object[] es, Comparator<? super T> cmp) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = es[parent];
            if (cmp.compare(x, (T) e) >= 0)
                break;
            es[k] = e;
            k = parent;
        }
        es[k] = x;
    }

    private void grow(int i) {
        int oldCapacity = queue.length;
        int newCapacity = MyArrayUtil.findNewLength(oldCapacity, i-oldCapacity, oldCapacity>>1);
        queue = MyArrayUtil.copyArray(queue, newCapacity);
    }

    public E poll() {
        final Object[] es = queue;
        final E result = (E) es[0];
        if (result != null) {
            final int n = --size;
            final E x = (E) es[n];
            es[n] = null;
            if (n>0) {
                final Comparator<? super E> cmp;
                if ((cmp = comparator) == null)
                    siftDownComparable(0, x, es, n);
                else
                    siftDownUsingComparator(0, x, es, n, cmp);
            }
        }
        return result;
    }

    private static <T> void siftDownComparable(int k, T x, Object[] es, int n) {
        // assert n > 0;
        Comparable<? super T> key = (Comparable<? super T>)x;
        int half = n >>> 1;           // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // assume left child is least
            Object c = es[child];
            int right = child + 1;
            if (right < n &&
                    ((Comparable<? super T>) c).compareTo((T) es[right]) > 0)
                c = es[child = right];
            if (key.compareTo((T) c) <= 0)
                break;
            es[k] = c;
            k = child;
        }
        es[k] = key;
    }

    private static <T> void siftDownUsingComparator(
            int k, T x, Object[] es, int n, Comparator<? super T> cmp) {
        // assert n > 0;
        int half = n >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = es[child];
            int right = child + 1;
            if (right < n && cmp.compare((T) c, (T) es[right]) > 0)
                c = es[child = right];
            if (cmp.compare(x, (T) c) <= 0)
                break;
            es[k] = c;
            k = child;
        }
        es[k] = x;
    }

    public E peek() {
        return (E) queue[0];
    }
}
