import java.util.Scanner;
/**
 * Class for is minimum heap.
 *
 * @param      <E> generic.
 */
class IsMinHeap<E extends Comparable<E>> {
    /**
     * array of generic type.
     */
    private E[] array;
    /**
     * Constructs the object.
     *
     * @param  a generic type
     */
    IsMinHeap(final E[] a) {
        this.array = a;
    }
    /**
     * Determines if minimum heap.
     * time complexity is N.
     * @return     True if minimum heap, False otherwise.
     */
    public boolean isMinHeap() {
        for (int i = 0; i < array.length - 1; i++) {
            if (less(i + 1, i)) {
                return false;
            }
        }
        return true;
    }
    /**
     * checks whether the element is less.
     *
     * @param      i  integer.
     * @param      j  integer.
     *
     * @return   True if less, False otherwise.
     */
    public boolean less(final int i, final int j) {
        return array[i].compareTo(array[j]) < 0;
    }

}

/**
 * client class.
 */
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
                IsMinHeap<String> isobj
                = new IsMinHeap<String>(tokens);
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
                IsMinHeap<Integer> isobj
                = new IsMinHeap<Integer>(elementInt);
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
                IsMinHeap<Double> isobj
                = new IsMinHeap<Double>(elementDouble);
                System.out.println(isobj.isMinHeap());
            }
            break;
        case "Float":
            int n3 = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n3; i++) {
                String str = sc.nextLine();
                if (str.equals("")) {
                    System.out.println("false");
                    break;
                } else {
                    String[] tokens = str.split(",");
                    Float[] elementFloat = new Float[tokens.length];
                    for (int j = 0; j < tokens.length; j++) {
                        elementFloat[j] = Float.parseFloat(tokens[j]);
                    }
                    IsMinHeap<Float> isobj
                     = new IsMinHeap<Float>(elementFloat);
                    System.out.println(isobj.isMinHeap());
                }
            }
            break;
            default:
            break;
        }
    }
}
