package study.java8;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);






        //odd number
//        myList.stream().filter(n->n%2==0).forEach(System.out::println);
//        myList.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::println);
//        Set<Integer> set = new HashSet<>();
//        myList.stream().filter(n->!set.add(n)).forEach(System.out::println);
//        myList.stream().findFirst().ifPresent(System.out::println);
//        System.out.println(myList.stream().count());
//        System.out.println(myList.stream().max(Integer::compare));
//        myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
//        List<Integer> collect = myList.stream().sorted((x, y) -> y.compareTo(x)).collect(Collectors.toList());
//        System.out.println(collect);
// find the sum of numbers that are less than 100 and calculate the average
//        List<Integer> list = Arrays.asList(100, 10, 40);
//        OptionalDouble average = list.stream().filter(n -> n > 9).mapToInt(n -> n).average();
//        System.out.println(average);
//        OptionalDouble optionalDouble = Arrays.asList(1, 3, 6, 10, 12, 15).stream().filter(n -> n % 2==0).filter(n -> n % 3 == 0).mapToInt(n->n).average();
//        System.out.println(optionalDouble);

        Arrays.asList(10,20,15,30,18).stream().sorted((x,y)->y.compareTo(x)).limit(2).forEach(System.out::println);


    }


}
