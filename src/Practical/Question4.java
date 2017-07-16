/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Red King
 */
public class Question4 {

    public static void main(String[] args) {
        System.out.print("Implementation 1 or 2 : ");
        Scanner in = new Scanner(System.in);
        if (in.nextInt() == 1) {
            Implementation1();
        } else {
            Implementation2();
        }
    }

    public static void Implementation1() {
        Random r = new Random();
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        for (int i = 0; i < 50000; i++) {
            numbers.add(r.nextInt(51));
        }

        long timeStart = System.currentTimeMillis();
        ListIterator<Integer> list = numbers.listIterator();
        while (list.hasNext()) {
            list.next();
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd - timeStart);

        long timeStartGet = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            numbers.get(i);
        }
        long timeEndGet = System.currentTimeMillis();
        System.out.println(timeEndGet - timeStartGet);
    }

    public static void Implementation2() {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            arrayList.add(i);
        }
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);

        long iteratorTimerStart = System.currentTimeMillis();
        ListIterator<Integer> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        long iteratorTimerEnd = System.currentTimeMillis();
        System.out.println("Time to traverse the list using an iterator :"
                + (iteratorTimerEnd - iteratorTimerStart) + " millis");

        System.out.println("Go do something else when running this, like Youtube or other stuff.");
        long getTimerStart = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            linkedList.get(i);
        }
        long getTimerEnd = System.currentTimeMillis();
        System.out.println("Time to traverse the list using the get(index) method:"
                + (getTimerEnd - getTimerStart) + " millis");
    }
}
