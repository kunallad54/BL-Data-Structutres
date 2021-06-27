/*************************************************************************************************************
 *
 * Purpose : Simple Balanced Parentheses
 *           a. Desc -> Take an Arithmetic Expression such as
 *                     (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) where parentheses are used to order the
 *                     performance of operations. Ensure parentheses must appear in a balanced
 *                     fashion.
 *          b. I/P -> read in Arithmetic Expression such as (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)
 *          c. Logic -> Write a Stack Class to push open parenthesis “(“ and pop closed
 *                      parenthesis “)”. At the End of the Expression if the Stack is Empty then the
 *                      Arithmetic Expression is Balanced. Stack Class Methods are Stack(), push(),
 *                      pop(), peak(), isEmpty(), size()
 *         d. O/P -> True or False to Show Arithmetic Expression is balanced or not.
 *
 * @author Krunal Lad
 * @Since 27-06-2021
 *
 *************************************************************************************************************/

package DataStructureMain;

import Implementations.StackImplementationUsingLinkedList;

public class SimpleBalancedParenthesis {
    public static void main(String[] args) {

        String expression = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
        System.out.println("Length = " + expression.length());

        StackImplementationUsingLinkedList<Character> stack = new StackImplementationUsingLinkedList<Character>();
        boolean isBalanced = false;

        for (int i = 0; i < expression.length(); i++) {
            isBalanced = false;
            if (expression.charAt(i) != ')') {
                stack.push(('('));
                System.out.println("Peek : " + stack.peek());
            } else if (expression.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    isBalanced = true;
                }
            }

        }
        if (stack.isEmpty() && isBalanced) {
            System.out.println("\n Expression has balanced parenthesis");
        } else {
            System.out.println("\n Expression has not balanced parenthesis");
        }
    }
}
