import java.util.Scanner;
class LinkedList {
    private LinkedList first;
    private LinkedList last;
    private LinkedList next;
    private char item;
    private int length;
    public LinkedList() {
        first = null;
        last = null;
        length = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }
    public void push(char item) {
        LinkedList oldlast = last;
        last = new LinkedList();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        length++;
    }

    public char pop() {

        char item = first.item;
        if (first != null) {
            first = first.next;
            //System.out.println("hey");

        }
        length--;
        return item;
    }
    public int size() {
        //System.out.println(length);
        return length;
    }
}
class AddLargeNumbers {
        private static LinkedList lobj = new LinkedList();

        public static LinkedList numberToDigits(String number) {
            for (int i = 0; i < number.length(); i++) {
                lobj.push(number.charAt(i));
                //System.out.println(number.charAt(i));
            }
            return lobj;
        }
        public static String digitsToNumber(LinkedList list) {
            String s = "";
            int i = 0;
            for (i = 0; i < list.size(); i++) {
                s += lobj.pop();

                //System.out.println(s);

            }
            // while (i < list.size()) {
            //     s += lobj.pop();
            //     i++;
            // }
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
