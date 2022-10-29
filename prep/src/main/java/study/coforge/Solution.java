package study.coforge;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // name="Dipyaman"
    //count of occurance of each character

    public static void main(String[] args) {
        String name = "Dipyaman";
        Map<Character, Integer> map = getCountOfString(name);
        System.out.println(map);
    }

    private static Map<Character, Integer> getCountOfString(String name) {
        Map<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < name.length(); i++) {
            hm.put(name.charAt(i), hm.getOrDefault(name.charAt(i), 0) + 1);
        }
        return hm;
    }


}
