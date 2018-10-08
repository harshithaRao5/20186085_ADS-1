import java.util.Scanner;
class IsMinHeap<E extends Comparable<E>> {
	private E[] array;

	IsMinHeap(E[] a) {
		this.array = a;
	}
	// private boolean isMinHeap() {
 //        return isMinHeap(1);
 //    }

    public boolean isMinHeap() {
        // if (k > n) return true;
        // int left = 2*k + 1;
        // int right = 2*k + 2;
        // if (left  <= n && greater(k, left)) {
        // 	return false;
        // }
        // if (right <= n && greater(k, right)) {
        // 	return false;
        // }
        // return isMinHeap(left) && isMinHeap(right);
        for (int i = 0; i < array.length; i++) {
        	if (less(i+1,i)) {
        		return false;
        	}
        }
        return true;
    }
    public boolean less(int i, int j) {
    	return array[i].compareTo(array[j]) < 0;
    }

}


public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unused constructor
	}
	/**
	 * client program.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		switch (choice) {
		case "String":
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; i++) {
				String[] tokens = sc.nextLine().split(",");
				String[] element = new String[tokens.length];
				for (int j = 0; j < tokens.length; j++) {
					element[j] = tokens[j];
				}
				IsMinHeap<String> isobj = new IsMinHeap<String>(element);
				System.out.println(isobj.isMinHeap());

			}
			break;
		case "Integer":
			int n1 = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n1; i++) {
				String[] tokens = sc.nextLine().split(",");
				Integer[] elementInt = new Integer[tokens.length];
				for (int j = 0; j < tokens.length; j++) {
					elementInt[j] = Integer.parseInt(tokens[j]);
				}
				IsMinHeap<Integer> isobj = new IsMinHeap<Integer>(elementInt);
				System.out.println(isobj.isMinHeap());
			}
			break;
		case "Double":
			int n2 = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n2; i++) {
				String[] tokens = sc.nextLine().split(",");
				Double[] elementDouble = new Double[tokens.length];
				for (int j = 0; j < tokens.length; j++) {
					elementDouble[j] = Double.parseDouble(tokens[j]);
				}
				IsMinHeap<Double> isobj = new IsMinHeap<Double>(elementDouble);
				System.out.println(isobj.isMinHeap());
			}
			break;
		case "Float":
			int n3 = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n3; i++) {
				String[] tokens = sc.nextLine().split(",");
				Float[] elementFloat = new Float[tokens.length];
				for (int j = 0; j < tokens.length; j++) {
					elementFloat[j] = Float.parseFloat(tokens[j]);
				}
				IsMinHeap<Float> isobj = new IsMinHeap<Float>(elementFloat);
				System.out.println(isobj.isMinHeap());
			}
			break;
		}
	}
}