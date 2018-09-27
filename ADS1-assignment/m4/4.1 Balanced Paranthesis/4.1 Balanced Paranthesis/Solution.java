import java.util.Scanner;
class LinkedStackOfStrings {
	private Node first = null;
	private class Node {
		char item;
		Node nextAddress;
	}
	public char top() {
		return first.item;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public void push(char item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.nextAddress = oldfirst;
	}
	public char pop() {
		char item = first.item;
		first = first.nextAddress;
		return item;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < size; i++) {
			String line = sc.next();
			if(checkParanthesis(line)){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}
	public static boolean checkParanthesis(String s) {
		LinkedStackOfStrings obj = new LinkedStackOfStrings();
		int sLength = s.length();
		for (int i = 0; i < sLength; i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				obj.push(ch);
			}
			else {
				if(obj.isEmpty()) return false;
				if (ch == ')' && obj.top() == '(') {
				obj.pop();
			} else if (ch == '}' && obj.top() == '{') {
				obj.pop();
			} else if (ch == ']' && obj.top() == '[') {
				obj.pop();
			} else return false;
		}

	}
	return obj.isEmpty();
}
}