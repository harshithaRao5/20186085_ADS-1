import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for three sum.
 */
class ThreeSum {
    /**
     * integer array.
     */
    private int[] array;
    /**
     * array size.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      arr   The arr
     * @param      n     integer
     */
    ThreeSum(final int[] arr, final int n) {
        this.array = arr;
        this.size = n;
    }
   /**
    * binary search method.
    *
    * @param      arr  The array
    * @param      a      integer
    *
    * @return result
    */
    public int binarySearch(final int[] arr, final int a) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == a) {
                return mid;
            } else if (arr[mid] < a) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    /**
     * count of sum.
     *
     * @param      a integer
     *
     * @return  count
     */
    public int count(final int[] a) {
        Arrays.sort(a);
        // System.out.println(Arrays.toString(a));
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int result = binarySearch(a, -(a[i] + a[j]));
                //System.out.println(result + "result$$$$j" + j);
                if (result > j) {
                    count++;
                }
            }
        }
        return count;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
/**
 * Constructs the object.
 */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        ThreeSum tsum = new ThreeSum(array, n);
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(tsum.count(array));
    }
}
