package study.gmp;


import java.util.Stack;

/*
Stack: 11 2 32 3 41

Output: 41 32 11 3 2


 */
public class Solution {
    public static void main(String[] args) {
        Stack<Integer> stack =  new Stack<>();
        stack.push(11);
        stack.push(2);
        stack.push(32);
        stack.push(3);
        stack.push(41);

        sortStack(stack);
        System.out.println(stack);
    }

    private static void sortStack(Stack<Integer> stack) {
   //base case
        if (!stack.isEmpty()){
            int baseElement = stack.pop();
            sortStack(stack);
            insertElement(stack,baseElement);

        }


    }

    private static void insertElement(Stack<Integer> stack, int baseElement) {
        if(stack.isEmpty() || baseElement < stack.peek()){
            stack.push(baseElement);
            return;
        }
        int temp = stack.pop();
        insertElement(stack,baseElement);
        stack.push(temp);
    }


}
