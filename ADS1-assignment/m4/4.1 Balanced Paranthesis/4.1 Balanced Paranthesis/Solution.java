import java.util.Scanner;
//import java.util.Stack;
class LinkedStackOfStrings {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
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
        return first.item;
    }

}

class BalancedParanthesis {

    private String s;
    private LinkedStackOfStrings lobj;

    BalancedParanthesis() {
        lobj = new LinkedStackOfStrings();
    }

    public void setString(String s1) {
        this.s = s1;
    }
    public boolean checkParanthesis() {

        int sLength = s.length();
        String ch = s.charAt(0) + "";
        if (ch.equals("}") || ch.equals("]") || ch.equals(")") ) {
            return false;
        } else {
            for (int i = 0; i < sLength; i++) {
                ch = s.charAt(i) + "";
                String top = lobj.top();
                if (ch.equals("(") || ch.equals("{") || ch.equals("[")) {
                    lobj.push(ch);
                } else if (ch.equals(")") && top.equals("(")) {
                    lobj.pop();
                } else if (ch.equals("}") && top.equals("{")) {
                    lobj.pop();
                } else if (ch.equals("]") && top.equals("[")) {
                    lobj.pop();
                } else {
                    return false;
                }
            }
        }
        return lobj.isEmpty();
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());

        for(int i = 0; i < size;i++) {
            BalancedParanthesis bp = new BalancedParanthesis();
            bp.setString(scan.nextLine());
            if (bp.checkParanthesis()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}