import java.util.Scanner;
// class BinarySearchST<Key extends Comparable<Key>, Value> {
// 	private static final int INIT_CAPACITY = 2;
// 	private Key[] keys;
// 	private Value[] vals;
// 	private int n = 0;
// 	BinarySearchST() {
// 		this(INIT_CAPACITY);
// 	}

// 	public BinarySearchST(int capacity) {
// 		keys = (Key[]) new Comparable[capacity];
// 		vals = (Value[]) new Object[capacity];
// 	}
// 	private void resize(int capacity) {
// 		Key[]   tempk = (Key[])   new Comparable[capacity];
//         Value[] tempv = (Value[]) new Object[capacity];
//         for (int i = 0; i < n; i++) {
//             tempk[i] = keys[i];
//             tempv[i] = vals[i];
//         }
//         vals = tempv;
//         keys = tempk;
// 	}

// }
public final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchST<String, Integer> bst = new BinarySearchST<String, Integer>();
		String[] tokens = sc.nextLine().split(" ");
		for (int i = 0; i < tokens.length; i++) {
			bst.put(tokens[i],i);
		}
			while (sc.hasNext()) {
				String[] choice = sc.nextLine().split(" ");
				switch (choice[0]) {
				case "max":
				System.out.println(bst.max());
				break;
				case "floor":
				System.out.println(bst.floor(tokens[1]));
				break;
				case "rank":
				System.out.println(bst.rank(tokens[1]));
				break;
				case "deleteMin":
				bst.deleteMin();
				break;
				case "contains":
				System.out.println(bst.contains(tokens[1]));
				break;
				case "keys":
				System.out.println(bst);
				break;
				case "get":
				System.out.println(bst.get(tokens[1]));
				break;
				default:
				break;

				}
			}


	}
}