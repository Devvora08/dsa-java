// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.

// Input: s = "()[]{}"
// Output: true

// Input: s = "([)]"
// Output: false

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String check = "{";
        System.out.println(countMissingParenthesis(check));
    }

    static boolean checkValid(String s){
        // put every char in stack if opening braces, if closing comes, check if matches with top
        // of opening, if true, pop it, else return false. return true if stack = empty

        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if(ch == ')'){
                    if(stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                } if (ch == '}'){
                    if(stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                } if (ch == ']'){
                    if(stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }   
        }
        return stack.isEmpty();
    }

    static int countMissingParenthesis(String s) {
        // function to count missing valid parenthesis
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size();

    }
}
