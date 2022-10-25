package study.optional;

import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        String str= null;
        Optional optStr = Optional.ofNullable(str);
//        System.out.println(optStr.isPresent());
//        System.out.println(optStr.get());
//        System.out.println(optStr.orElse("Default value"));

        Optional<Integer> len = getLength(str);
        System.out.println(len);
    }

    private static Optional<Integer> getLength(String str) {
        return Optional.of(Optional.ofNullable(str).map(s -> s.length()).orElse(0));
    }
}
//    String str;
//    Optional optStr = Optional.ofNullable(str);
//java: variable str might not have been initialized


//    String str= new String();
//    Optional optStr = Optional.ofNullable(str);
//    System.out.println(optStr.isPresent());
//    true


//    String str = null;
//    Optional optStr = Optional.ofNullable(str);
//    System.out.println(optStr.isPresent());
//    System.out.println(optStr.orElse("Default value"));
//
//    false
//    Default value

//    String str = null;
//    Optional optStr = Optional.ofNullable(str);
//    System.out.println(optStr.get());
//    Exception in thread "main" java.util.NoSuchElementException: No value present