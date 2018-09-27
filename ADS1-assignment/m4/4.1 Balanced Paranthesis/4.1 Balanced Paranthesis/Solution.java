import java.util.Scanner;
//import java.util.Stack;
class LinkedStackOfStrings {
	private static Node first = null;
	private static class Node {
		char item;
		Node next;
	}
	public static boolean isEmpty() {
		return first == null;
	}
	public static void push(char item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	public static char pop() {
		char item = first.item;
		first = first.next;
		return item;
	}
	public static char top() {
		return first.item;
	}
	public static boolean checkParanthesis(String s) {

		int sLength = s.length();
		for (int i = 0; i < sLength; i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				push(ch);
			} else {
				if (isEmpty()) {
					return false;
				}
				if (ch == ')' && top() == '(') {
					pop();
				} else if (ch == '}' && top() == '{') {
					pop();
				} else if (ch == ']' && top() == '[') {
					pop();
				}
				else return false;
			}

		}
		return isEmpty();
	}

}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		LinkedStackOfStrings lobj = new LinkedStackOfStrings();
		for (int i = 0; i < size; i++) {
			String line = sc.next();
			if (lobj.checkParanthesis(line)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}

}