import java.util.Scanner;
class BookDetails implements Comparable<BookDetails> {
	private String name;
	private String author;
	private float price;
	BookDetails(String bookname, String bookauthor, float bookprice) {
		this.name = bookname;
		this.author = bookauthor;
		this.price = bookprice;
	}
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public float getPrice() {
		return this.price;
	}
	public int compareTo(BookDetails that) {
		// if(this.getPrice() > that.getPrice()){
		// 	return 1;
		// } else if (this.getPrice() < that.getPrice()){
		// 	return -1;
		// }
		if(this.getName().equals(that.getName())) {
			return 0;
		}
		return 1;

	}
}
class BinarySearchTree<BookDetails extends Comparable<BookDetails>, Value> {
	//BookDetails dobj = new BookDetails();
	private Node root;
	private class Node {
		private BookDetails key;
		private Value val;
		private Node left, right;
		private int size;

		public Node(BookDetails key, Value val, int size) {
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}
	BinarySearchTree() {

	}
	public Value get(BookDetails key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {
				x = x.left;
			} else if (cmp > 0) {
				x = x.right;
			} else if (cmp == 0) {
				return x.val;
			}
		}
		return null;
	}
	public void put(BookDetails key, Value val) {
		root = put(root, key, val);
	}
	private Node put(Node x, BookDetails key, Value val) {
		if (x == null) {
			return new Node(key, val, 1);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		} else if (cmp == 0) {
			x.val = val;
		}
		return x;
	}


}
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] tokens = sc.nextLine().split(",");
		BinarySearchTree<BookDetails, Integer> bstobj = new BinarySearchTree<BookDetails, Integer>();
		BookDetails deobj = new BookDetails(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1]));
		while (sc.hasNextLine()) {
			switch (tokens[0]) {
			case "put":
				bstobj.put(deobj, Integer.parseInt(tokens[2 + 2]));
				break;
			case "get":
				//bstobj.get(deobj);
				System.out.println(bstobj.get(deobj));
				break;
			}
		}
	}
}