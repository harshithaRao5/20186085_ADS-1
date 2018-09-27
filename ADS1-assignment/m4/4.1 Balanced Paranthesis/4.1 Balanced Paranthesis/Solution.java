import java.util.Scanner;
//import java.util.Stack;
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
	public void pop() {
		char item = first.item;
		first = first.next;
	}
	public char top() {
		if (!isEmpty())
			return first.item;
		return '\0';
	}
	public boolean checkParanthesis(String s) {

		int sLength = s.length();
		for (int i = 0; i < sLength; i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				push(ch);
			} else if (ch == ')' && top() == '(') {
					pop();
			} else if (ch == '}' && top() == '{') {
					pop();
			} else if (ch == ']' && top() == '[') {
					pop();
				//else return false;
			} else {
				return false;
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
			String line = sc.nextLine();
			if (lobj.checkParanthesis(line)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}

}