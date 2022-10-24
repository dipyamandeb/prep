package study.java8;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        //odd number
//        myList.stream().filter(n->n%2==0).forEach(System.out::println);
//        myList.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::println);
        Set<Integer> set = new HashSet<>();
//        myList.stream().filter(n->!set.add(n)).forEach(System.out::println);
//        myList.stream().findFirst().ifPresent(System.out::println);
//        System.out.println(myList.stream().count());
//        System.out.println(myList.stream().max(Integer::compare));
        myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
// find the sum of numbers that are less than 100 and calculate the average
//        List<Integer> list = Arrays.asList(150, 132, 73, 104, 84, 168, 92, 27, 77);
//        list.stream().filter(n->n<100).map(n->n+/2);


    }


}
