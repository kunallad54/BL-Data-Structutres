/**
 * Purpose : To perform stack operations using linked list
 *
 * @author Krunal Lad
 * @Since 27-06-2021
 */

package Implementations;
public class StackImplementationUsingLinkedList<T> {
    LinkedList<T> stack = new LinkedList<T>();
    public static int top = 0;

    /**
     * Purpose : Push the element in the stack
     *
     * @param data taken from user
     */
    public void push(T data) {
        stack.add(data);
        top++;
    }

    /**
     * Purpose: To pop element from stack
     */
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            stack.deleteAtEnd();
            top--;
        }
    }

    /**
     * Purpose: To get the top element of stack
     *
     * @return top element of stack
     */
    public T peek(){
        if(!isEmpty()){
            T data;
            data = stack.get(top);
            return data;
        }
        return null;
    }

    /**
     * Purpose : Checks whether stack is empty or not
     * @return true if stack is empty else false
     */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    /**
     * Purpose : Prints data of stack
     */
    public void printStack(){
        stack.printList();
    }

    /**
     * Purpose : Method returning string of stack list
     *
     * @return returns stack list
     */
    public String returnStack(){
       return stack.returnList();
    }

    /**
     * Purpose : gets the size of stack
     *
     * @return size of stack
     */
    public int size(){
        return top;
    }

}
