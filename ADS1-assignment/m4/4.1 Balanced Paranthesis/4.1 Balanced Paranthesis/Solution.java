import java.util.Scanner;
/**
 * Class for linked stack of strings.
 */
class LinkedStackOfStrings {
	/**
	 * variable.
	 */
	private Node first = null;
	/**
	 * Class for node.
	 */
	private class Node {
		/**
		 * variable.
		 */
		char item;
		/**
		 * variable.
		 */
		Node nextAddress;
	}
	/**
	 * top element of stack.
	 *
	 * @return    first element
	 */
	public char top() {
		return first.item;
	}
	/**
	 * Determines if empty.
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		return first == null;
	}
	/**
	 * add element to stack.
	 *
	 * @param      item  The item
	 */
	public void push(final char item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.nextAddress = oldfirst;
	}
	/**
	 * element deleted element.
	 *
	 * @return deleted element.
	 */
	public char pop() {
		char item = first.item;
		first = first.nextAddress;
		return item;
	}
}
/**
 * main method
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 *
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
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
	/**
	 *check paranthesis method.
	 *
	 * @param      s     string.
	 *
	 * @return     boolean.
	 */
	public static boolean checkParanthesis(final String s) {
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