import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
    /**
     * variable declarartion.
     */
    public int item;
    /**
     * variable declarartion.
     */
    public Node next;
    /**
     * Constructs the object.
     *
     * @param      data  The data
     */
    Node(final int data) {
        item = data;
        next = null;
    }
    /**
     * Gets the item.
     *
     * @return     The item.
     */
    public int getItem() {
        return item;
    }
    /**
     * Gets the next.
     *
     * @return     The next.
     */
    public Node getNext() {
        return next;
    }
}
/**
 * List of linkeds.
 */
class linkedList {
    /**
     * variable declaration.
     */
    private Node head;
    /**
     * variable declaration.
     */
    private int size;
    /**
     * Constructs the object.
     */
    linkedList() {
        head = null;
        size = 0;
    }
    /**
     *size of list.
     *
     * @return length.
     */
    public int length() {
        return size;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * insert at position.
     *
     * @param      position  The position
     * @param      item1     The item 1
     */
    public void insertAt(final int position, final int item1) {
        insertAt(head, position, item1);
    }
    /**
     * insert at position.
     *
     * @param      node      The node
     * @param      position  The position
     * @param      item1     The item 1
     */
    private void insertAt(final Node node, final int position, final int item1) {
        if (position == 0 && head == null) {
            head = new Node(item1);
        } else if (position == 0 && head != null) {
            Node oldhead = head;
            head = new Node(item1);
            head.next = oldhead;
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.getNext();
            }
            Node nextNode = temp.getNext();
            Node node1 = new Node(item1);
            temp.next = node1;
            node1.next = nextNode;
        }
        size++;
    }
    /**
     * { function_description }
     */
    public void reverse() {
        head = reverse(head);
    }
    /**
     * { function_description }
     *
     * @param      head  The head
     *
     * @return     { description_of_the_return_value }
     */
    private Node reverse(final Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        if (size != 0) {
            Node temp = head;
            while (temp != null) {
                s += temp.item + ", ";
                temp = temp.next;
            }
        }
        return s.substring(0, s.length() - 2);
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
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        linkedList llobj = new linkedList();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                if (Integer.parseInt(tokens[1]) < 0 || Integer.parseInt(
                            tokens[1]) > llobj.length() + 1) {
                    System.out.println("Can't insert at this position.");
                } else {
                    llobj.insertAt(Integer.parseInt(tokens[1]),
                                   Integer.parseInt(tokens[2]));
                    System.out.println(llobj.toString());
                }
                break;
            case "reverse":
                if (!llobj.isEmpty()) {
                    llobj.reverse();
                    System.out.println(llobj.toString());
                } else {
                    System.out.println("No elements to reverse.");
                    break;
                }
            default:
            break;
            }
        }

    }
}