import java.util.Scanner;
class LinkedList {
    private int size = 0;
    LinkedList() {
    }
    Node first = null;
    public class Node {
        Node() {
        }
        int item;
        Node next;
        Node(int item1) {
            this.item = item1;
        }
    }
    public int top() {
        return first.item;
    }
    public void push(int item) {
        Node next = new Node(item);
        next.next = first;
        first = next;
        size++;
    }
    public int pop() {
        int output = first.item;
        first = first.next;
        size--;
        return output;
    }

    public boolean isEmpty() {
        return first == null;
    }
    public String toString() {
        Node head = first;
        String result = "";
        while(head != null) {
            result = result + head.item;
            head = head.next;
        }
        return result;
    }
    public int size() {
        return size;
    }

}
class AddLargeNumbers {
    //private static LinkedLists lobj = new LinkedLists();

    public static LinkedList numberToDigits(String number) {
        LinkedList nobj = new LinkedList();
        for (int i = number.length() - 1; i >= 0; i--) {
            String s = "" + number.charAt(i);
            nobj.push(Integer.parseInt(s));
        }
        return nobj;
    }
    public static String digitsToNumber(LinkedList list) {
        // String s = "";
        // for (int i = 0; i < list.size(); i++) {
        //     s += lobj.pop();
        // }
        // return s;
        return list.toString();
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
