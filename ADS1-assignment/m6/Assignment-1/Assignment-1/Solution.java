import java.util.Scanner;
class LinkedList<Item> {
    private stack<Item> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class stack<Item> {
        private Item item;
        private stack<Item> next;
    }

    /**
     * Initializes an empty stack.
     */
    public LinkedList() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(Item item) {
        stack<Item> oldfirst = first;
        first = new stack<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public Item pop() {
        Item item = null;
        if (!isEmpty())
            item = first.item;        // save item to return
        first = first.next;            // delete first stack
        n--;
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public Item peek() {
        if (!isEmpty())
            return first.item;
        return null;
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
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
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
