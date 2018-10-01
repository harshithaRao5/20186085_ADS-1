import java.util.Scanner;
class Steque {
    private int length = 0;

    private Node first = null;

    private Node last = null;

    private class Node {

        private int item;

        private Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void push(final int item) {
        if (first == null) {
            first = new Node();
            first.item = item;
            first.next = null;
            last = first;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
        }
        length++;
    }
    public void enequeue(final int item) {
        if (last == null) {
            last = new Node();
            last.item = item;
            last.next = null;
            first = last;
        }   else {
            Node temp = last;
            last = new Node();
            last.item = item;
            last.next = null;
            temp.next = last;
        }
        length++;
    }
    public void pop() {
        if (first != null) {
            first = first.next;
            length--;
        }
    }
    // public void pop() {
    //     if (last != null) {
    //         Node temp = first;
    //         while (temp.next.next != null) {
    //             temp = temp.next;
    //         }
    //         temp.next = null;
    //         last = temp;
    //         length--;
    //     }
    // }
    public int top() {
        return first.item;
    }
    public int size() {
        return length;
    }
    public void displayAll() {
        if (length != 0) {
            String s = "";
            Node temp = first;
            while (temp != null) {
                s += temp.item + ", ";
                temp = temp.next;
            }
            System.out.println(s.substring(0, s.length() - 2));
        }
        else{
        System.out.println("Steque is empty.");
    }
    }
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			Steque sobj = new Steque();
			while (sc.hasNext()) {
				String[] tokens = sc.nextLine().split(" ");
				switch(tokens[0]) {
					case "push":
					sobj.push(Integer.parseInt(tokens[1]));
					sobj.displayAll();
					break;
					case "pop":
					sobj.pop();
					sobj.displayAll();
					break;
					case "enequeue":
					sobj.enequeue(Integer.parseInt(tokens[1]));
					sobj.displayAll();
					break;

				}
			}
		}
	}
}