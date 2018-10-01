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
        return first == null||last == null;
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
    public int pop() {
        if (first != null) {
        	int value = first.item;
            first = first.next;
            length--;
            return value;
        }
        return 0;
        //  else {
        // 	last = null;
        // }

    }
    public void enequeue(final int item) {
    	//System.out.println("hey");
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
        //System.out.println("harshitha"+length);
    }
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
        System.out.println("");
    }
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			Steque sobj = new Steque();
			//System.out.println();
			while (sc.hasNext()) {
				String[] tokens = sc.nextLine().split(" ");
				switch(tokens[0]) {
					case "push":
					sobj.push(Integer.parseInt(tokens[1]));
					sobj.displayAll();
					break;
					case "pop":
					sobj.pop();
					if (sobj.isEmpty()) {
						System.out.println("Steque is empty.");
					} else {
						sobj.displayAll();
					}
					break;
					case "enqueue":
					sobj.enequeue(Integer.parseInt(tokens[1]));
					sobj.displayAll();
					break;
					default:
					sobj = new Steque();
					break;

				}
			}
		}
	}
}