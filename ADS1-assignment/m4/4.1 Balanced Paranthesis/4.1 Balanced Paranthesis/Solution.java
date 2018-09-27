import java.util.Scanner;
import java.util.Stack;
class LinkedStackOfStrings {
	private Node first = null;
	private class Node {
		char item;
		Node next;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public void push(char item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	public char pop() {
		char item = first.item;
		first = first.next;
		return item;
	}
	public char top() {
		return first.item;
	}


}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < size; i++) {
			String line = sc.next();
			if (checkParanthesis(line)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}
	public static boolean checkParanthesis(String s) {
		LinkedStackOfStrings lobj = new LinkedStackOfStrings();
		int sLength = s.length();
		for (int i = 0; i < sLength; i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				lobj.push(ch);
			} else {
				if (lobj.isEmpty()) {
					return false;
				}
				if (ch == ')' && lobj.top() == '(') {
					lobj.pop();
				} else if (ch == '}' && lobj.top() == '{') {
					lobj.pop();
				} else if (ch == ']' && lobj.top() == '[') {
					lobj.pop();
				}
				//else return false;
			}

		}
		return lobj.isEmpty();
	}
}