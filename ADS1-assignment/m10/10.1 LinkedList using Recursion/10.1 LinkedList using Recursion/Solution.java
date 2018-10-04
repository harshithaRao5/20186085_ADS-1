import java.util.Scanner;
class Node {
	public int item;
	public Node next;
	Node(int data) {
		item = data;
		next = null;
	}
	public int getItem() {
		return item;
	}
	public Node getNext() {
		return next;
	}
}
class linkedList {
	private Node head;
	private int size;
	linkedList() {
		head = null;
		size = 0;
	}
	public int length() {
		return size;
	}
	public boolean isEmpty() {
		return head == null;
	}
	public void insertAt(int position, int item1) {
		insertAt(head, position, item1);
	}
	private void insertAt(Node node, int position, int item1) {
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
			node = new Node(item1);
			temp.next = node;
			node.next = nextNode;
		}
		size++;
	}


	public void reverse() {
		head = reverse(head);
	}
	private Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node temp = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return temp;
	}
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
public class Solution {

	private Solution() {

	}
	public static void main(String[] args) {
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
			}
		}

	}
}