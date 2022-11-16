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
