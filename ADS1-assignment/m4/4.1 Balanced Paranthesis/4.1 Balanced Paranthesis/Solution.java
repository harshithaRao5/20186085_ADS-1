import java.util.Scanner;
//import java.util.Stack;
class LinkedStackOfStrings {
	private Node first = null;
	private class Node {
		String item;
		Node next;
	}
	public boolean isEmpty() {
		return first.item.equals(null);
	}
	public void push(String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}
	public String top() {
		if (!isEmpty())
			return first.item;
		return null;
	}
	public boolean checkParanthesis(String s) {

		int sLength = s.length();
		String ch = s.charAt(0) + "";
		if (ch.equals("}") || ch.equals("]") || ch.equals(")") ) {
			return false;
		} else {
			for (int i = 0; i < sLength; i++) {
				ch = s.charAt(i) + "";
				String top = top();
				if (ch.equals("(") || ch.equals("{") || ch.equals("[")) {
					push(ch);
				} else if (ch.equals(")") && top.equals("(")) {
						pop();
				} else if (ch.equals("}") && top.equals("{")) {
						pop();
				} else if (ch.equals("]") && top.equals("[")) {
						pop();
				} else {
					return false;
				}
			}
		}
		System.out.println(isEmpty());
		return isEmpty();
	}

}
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		LinkedStackOfStrings lobj = new LinkedStackOfStrings();
		while(scan.hasNext()) {
			if (lobj.checkParanthesis(scan.nextLine())) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}