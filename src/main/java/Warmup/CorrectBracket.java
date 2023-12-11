package Warmup;

import java.util.*;

class CorrectBracket {
    public static void main(String[] args) {
        // put your code here accepted
        Scanner s = new Scanner(System.in);
        String str = s.next();

        int f = m(str);

        if (f == 0) System.out.println("yes");
        else System.out.println("no");
    }

    private static int m(String str) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        Stack<Integer> arrI = new Stack<>();
        for (char c : str.toCharArray()) {
            i++;
            if (c == '{' || c == '(' || c == '[') {
                stack.add(c);
                arrI.add(i);
            }
            else if (!stack.isEmpty()) {
                if (c == '}' && stack.peek().equals('{')) {
                    stack.pop();
                    arrI.pop();
                }
                else if (c == ')' && stack.peek().equals('(')) {
                    stack.pop();
                    arrI.pop();
                }
                else if (c == ']' && stack.peek().equals('[')) {
                    stack.pop();
                    arrI.pop();
                }
                else if (c == '}' || c == ')' || c == ']') return i;
            } else if (c == '}' || c == ')' || c == ']') return i;
        }

        if (stack.isEmpty()) return 0;
        else return arrI.firstElement();
    }
}