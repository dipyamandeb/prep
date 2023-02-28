package study.jsw1;

import java.util.*;

/*
["eat","tea","tan","ate","nat","bat"]
[["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Solution {

    public static void main(String[] args) {
        ArrayList<String > input = new ArrayList<>();
        input.add("eat");
        input.add("tea");
        input.add("tan");
        input.add("ate");
        input.add("nat");
        input.add("bat");

        System.out.println(groupList(input));
    }

    private static List<List<String>> groupList(ArrayList<String> input) {
        List<List<String>> results =new ArrayList<>();
        Map<String,Integer> helper = new HashMap<>();

        for(int i=0;i<input.size();i++){

            char[] tmpChar = input.get(i).toCharArray();
            Arrays.sort(tmpChar);

            String tmp = new String(tmpChar);

            if (helper.containsKey(tmp)){
                results.get(helper.get(tmp)).add(input.get(i));
                continue;
            }

            List<String> curr = new LinkedList<>();
            curr.add(input.get(i));
            results.add(curr);
            helper.put(tmp, results.size()-1);
        }
        return  results;
    }

}
