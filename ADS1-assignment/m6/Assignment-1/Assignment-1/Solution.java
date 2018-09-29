import java.util.Scanner;
class LinkedList {
    /**
     * variable.
     */
    private Node first = null;
    private int length = 0;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * variable.
         */
        private char item;
        /**
         * variable.
         */
        private Node nextAddress;
    }
    /**
     * top element of stack.
     *
     * @return    first element
     */
    public char top() {
        return first.item;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * add element to stack.
     *
     * @param      item  The item
     */
    public void push(final char item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.nextAddress = oldfirst;
        length++;
    }
    /**
     * element deleted element.
     *
     * @return deleted element.
     */
    public char pop() {
        char item = first.item;
        first = first.nextAddress;
        length--;
        return item;
    }
    public int size() {
        return length;
    }
}
class AddLargeNumbers {
    private static LinkedList lobj = new LinkedList();

    public static LinkedList numberToDigits(String number) {
        for (int i = 0; i < number.length(); i++) {
            lobj.push(number.charAt(i));
        }
        return lobj;
    }
    public static String digitsToNumber(LinkedList list) {
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            s += lobj.pop();
        }
        return s;

    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        return null;
    }

}
    public class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String p = sc.nextLine();
            String q = sc.nextLine();
            switch (input) {
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);

                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
            }
        }

    }
