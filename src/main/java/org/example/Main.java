package org.example;

import org.example.list.MyArrayList;
import org.example.list.MyLinkedList;
import org.example.list.MyList;
import org.example.stack.MyStack;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        testArrayList();
        testMyArrayList();

        testLinkedList();
        testMyLinkedList();

        testStack();
        testMyStack();

        testQueue();
        testMyQueue();
    }

    private static void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("Remove first element of myQueue::"+queue.poll());
        System.out.println("Now the first element::"+queue.peek());
    }

    private static void testQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("Remove first element of queue::"+queue.poll());
        System.out.println("Now the first element::"+queue.peek());
    }

    private static void testMyStack() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Last element of myStack is::"+stack.pop());
    }

    private static void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Last element of stack is::"+stack.pop());
    }

    private static void testMyLinkedList() {
        MyList<Integer> numbers = new MyLinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1,5);
        numbers.remove(2);
        printInfo(numbers);
    }

    private static void testLinkedList() {
        List<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1,5);
        numbers.remove(2);
        printInfo(numbers);
    }

    private static void testArrayList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);// 1 2 3
        numbers.add(2);// 1 5 2 3
        numbers.add(3);// 1 2
        numbers.add(1,5);// add new element into given index
        numbers.remove(2);
        printInfo(numbers);
    }

    private static void printInfo(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.getClass().getName() + " Number::"+numbers.get(i) + " Index of this::"+ numbers.indexOf(numbers.get(i)));
        }
    }

    private static void testMyArrayList() {
        MyList<Integer> numbers = new MyArrayList<>();
        numbers.add(1);// 1 2 3
        numbers.add(2);// 1 5 2 3
        numbers.add(3);// 1 2
        numbers.add(1,5);// add new element into given index
        numbers.remove(2);
        printInfo(numbers);
    }

    private static void printInfo(MyList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.getClass().getName() + " Number::"+numbers.get(i) + " Index of this::"+ numbers.indexOf(numbers.get(i)));
        }
    }


}