package org.example;

import org.example.list.MyArrayList;
import org.example.list.MyList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testArrayList();
        testMyArrayList();




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
            System.out.println("Number::"+ numbers.get(i)+" Index of this::"+ numbers.indexOf(numbers.get(i)));
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
            System.out.println("Number::"+ numbers.get(i)+" Index of this::"+ numbers.indexOf(numbers.get(i)));
        }
    }


}