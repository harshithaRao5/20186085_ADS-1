import java.util.Scanner;
/**
 * Class for steque.
 */
class Steque {
	/**
	 * variable.
	 */
    private int length = 0;
    /**
     * variable.
     */
    private Node first = null;
    /**
     * variable.
     */
    private Node last = null;
    /**
     * Class for node.
     */
    private class Node {
    	/**
    	 * variable.
    	 */
        private int item;
        /**
         * variable.
         */
        private Node next;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null||last == null;
    }
    /**
     * push method to enter element.
     *
     * @param      item  The item
     */
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
    /**
     * pop method to delete.
     *
     * @return value.
     */
    public int pop() {
        if (first != null) {
        	int value = first.item;
            first = first.next;
            length--;
            return value;
        }
        return 0;
    }
    /**
     * push at end.
     *
     * @param      item  The item
     */
    public void enequeue(final int item) {
    	//System.out.println("hey");
        if (last == null || first == null) {
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
    /**
     * top method.
     *
     * @return first element.
     */
    public int top() {
        return first.item;
    }
    /**
     *size method to get the length.
     *
     * @return length of list.
     */
    public int size() {
        return length;
    }
    /**
     *display all method.
     */
    public void displayAll() {
        if (length != 0) {
            String s = "";
            Node temp = first;
            while (temp != null) {
                s += temp.item + ", ";
                temp = temp.next;
            }
            System.out.println(s.substring(0, s.length() - 2));
        } else {
        System.out.println("Steque is empty.");
    	}
    }
}
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 *main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Steque sobj = new Steque();
			while (sc.hasNext()) {
				String[] tokens = sc.nextLine().split(" ");
				if (tokens[0].length() == 0) {
                    System.out.println();

                } else {
				switch(tokens[0]) {
					case "push":
					sobj.push(Integer.parseInt(tokens[1]));
					sobj.displayAll();
					break;
					case "pop":
					sobj.pop();
					sobj.displayAll();
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
}