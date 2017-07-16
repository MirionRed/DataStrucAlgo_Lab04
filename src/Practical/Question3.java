/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Red King
 */
public class Question3 {

    public static void main(String[] args) {
        Point[] points = new Point[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(Math.round(Math.random()*10),
                    Math.round(Math.random()*10));
        }
       
        List<Point> list;
        
        Arrays.sort(points);
        list = Arrays.asList(points);
        System.out.println("\nPoints in increasing order of their x-coordinates:");
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).getX() + "," + list.get(i).getY());
        }
        
        Arrays.sort(points, new CompareY());
        list = Arrays.asList(points);
        System.out.println("\nPoints in increasing order of their y-coordinates:");
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).getX() + "," + list.get(i).getY());
        }
    }
}

class Point implements Comparable<Point> {

    private double x, y;

    public Point(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int compareTo(Point p) {
        if (x == p.getX()) {
            if (y == p.getY()) {
                return 0;
            } else if (y > p.getY()) {
                return 1;
            } else {
                return -1;
            }
        } else if (x > p.getX()) {
            return 1;
        } else {
            return -1;
        }
    }
}

class CompareY implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        double x1 = o1.getX();
        double y1 = o1.getY();
        double x2 = o2.getX();
        double y2 = o2.getY();

        if (y1 == y2) {
            if (x1 == x2) {
                return 0;
            } else if (x1 > x2) {
                return 1;
            } else {
                return -1;
            }
        } else if (y1 > y2) {
            return 1;
        } else {
            return -1;
        }
    }

}
