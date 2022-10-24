package study.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

//        numsStream();
//        strStream();
//        callingFi();
//        lambdaThread();
    }

    private static void lambdaThread() {
        Thread t1 = new Thread(() -> System.out.println("Thread run"));
        t1.start();
    }

    private static void callingFi() {
        //declare the working of method using lambda and assign it to instance of interface
        Greetings greet = () -> System.out.println("Hello from lambda");
        //call the method using instance of interface
        greet.greetMethod();
    }

    private static void strStream() {
        String names[] = {"Anil", "Anu", "Durgesh", "Dilip"};
        List<String> namewithA = Arrays.stream(names).filter(s -> s.startsWith("A")).collect(Collectors.toList());
        System.out.println(namewithA);
    }

    private static void numsStream() {
        List<Integer> list1 = Arrays.asList(54, 23, 15, 66, 33, 6);

        //even number and square them
        list1.stream().filter(n -> n % 2 == 0).map(i -> i * i).collect(Collectors.toList()).forEach(System.out::println);

        //max
        Integer max = list1.stream().max((x, y) -> x.compareTo(y)).get();
        System.out.println(max);

        //min
        Integer min = list1.stream().min((x, y) -> x.compareTo(y)).get();
        System.out.println(min);
        List<Integer> collect = list1.stream().sorted((x, y) -> y.compareTo(x)).collect(Collectors.toList());
        System.out.println("list: " + collect);
    }

}
