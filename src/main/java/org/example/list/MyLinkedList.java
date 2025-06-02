package org.example.list;

public class MyLinkedList<E> implements MyList<E> {
    private int size = 10;
    private Node<E> first;
    private Node<E> last;
    public MyLinkedList() {}
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public void add(int index, E e) {
        checkIndex(index);
        if (index == size)
            linkLast(e);
        else
            linkBefore(e, node(index));
    }

    private void checkIndex(int index) {
        if (index <0 || index > size)
            throw new IndexOutOfBoundsException("Index out of size");
    }

    private void linkBefore(E e, Node<E> node) {
        Node<E> f = node.next;
        Node<E> newNode = new Node<>(node, e, node.next);
        f.prev = newNode;
        if (f == null)
            first = newNode;
        else
            node.next = newNode;
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        return unlink(node(index));
    }

    private E unlink(Node<E> node) {
        E element = node.element;
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev==null)
            first = next;
        else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null)
            last = prev;
        else {
            last.prev = prev;
            node.next = null;
        }

        node.element = null;
        size--;
        return element;
    }

    @Override
    public E get(int index) {
        if (index<0 || index> size)
            throw new IndexOutOfBoundsException("Index out of size");
        return node(index).element;
    }

    Node<E> node(int index) {
        if ((size>>1) > index){
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x= x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size-1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        if (e == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.element == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.element.equals(e))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    public static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E e, Node<E> next) {
            this.prev = prev;
            this.element = e;
            this.next = next;
        }
    }
}
