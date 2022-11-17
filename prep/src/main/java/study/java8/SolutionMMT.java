package study.java8;

import java.util.Arrays;
import java.util.List;

/*
Input 1:
 A = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Input 2:
 A = [1, 2]


Output 1:
 6
Output 2:
 0
 */

//vinod.kanchi@go-mmt.com
/*

Rotating Array Search

A: [10, 12, 0, 2, 4, 6, 8]

Search for 4 in the array and print the index.

answer: 4
 */
/*
A = [1 3 -1 -3 5 3 6 7]

B=1 3 -1 2 -4
s=3
LocalMaximu=  3
currMaxima = Math.max(currMaxima, new Elemanet)

 */


public class SolutionMMT {

    public static void main(String[] args) {

        List<Integer> myList = Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        int waterTrapped = waterTrapped(myList);
        System.out.println("Result: " + waterTrapped);
    }

    private static int waterTrapped(List<Integer> myList) {
        if (myList.isEmpty()) return 0;
        int l = 0;
        int r = myList.size() - 1;

        int ltMax = myList.get(l);
        int rtMax = myList.get(r);
        int waterTrapped = 0;
        while (l < r) {
            if (ltMax < rtMax) {
                l++;
                ltMax = Math.max(ltMax, myList.get(l));
                waterTrapped += ltMax - myList.get(l);
            } else {
                r--;
                rtMax = Math.max(rtMax, myList.get(r));
                waterTrapped += rtMax - myList.get(r);
            }

        }

        return waterTrapped;
    }

}
