import java.util.Scanner;
class Deque {
	/**
	 * variable.
	 */
	public Node first;
	public Node last;
	private int count;

	Deque() {
		first = null;
		last = null	;
		count = 0;
	}

	/**
	 * Class for node.
	 */
	class Node {
		/**
		 * variable.
		 */
		int item;
		/**
		 * variable.
		 */
		private Node next;
	}
	public boolean isEmpty() {
		return last == null || first == null;
	}
	public int size() {
		return count;
	}
	public void pushLeft(int item) {
		Node oldlast = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
        	last = first;
        } else {
        	first.next = oldlast;
        }
        //System.out.println(first.item);
        count++;
	}
	public void pushRight(int item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		count++;
	}
	public int popLeft() {

        int item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
			first = null;
		}
		return item;
	}
	public int popRight() {
		int item = last.item;
        last = last.next;
        if (isEmpty()) {
        	first = null;
        	last = null;
        }
        return item;
    }
    public String display() {
        if (count != 0) {
            String s = "[";
            Node temp = first;
            while (temp != null) {
                s += temp.item + ", ";
                temp = temp.next;
            }
            return s.substring(0, s.length() - 2) + "]";
        }
        return "[]";
    }
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n;
        Deque link = new Deque();
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            switch (line[0]) {
            case "pushLeft":
                link.pushLeft(Integer.parseInt(line[1]));
                System.out.println(link.display());
                break;
            case "pushRight":
                link.pushRight(Integer.parseInt(line[1]));
                System.out.println(link.display());
                break;
            case "popRight":
                if (!link.isEmpty()) {
                    link.popRight();
                    System.out.println(link.display());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popLeft":
                if (!link.isEmpty()) {
                    link.popLeft();
                    System.out.println(link.display());
                } else {
                    System.out.println("Deck is empty");
                }

                break;
            case "size":
                System.out.println(link.size());
            default:
                break;
            }

        }
	}
}