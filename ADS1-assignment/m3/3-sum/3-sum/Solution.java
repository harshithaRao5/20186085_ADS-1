import java.util.Scanner;
import java.util.Arrays;

class ThreeSum {
    int[] array;
    int size;
    ThreeSum(int[] arr, int n) {
        this.array = arr;
        this.size = n;
    }
    private static boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i-1]) {
                return true;
            }
        }
        return false;
    }
    public static int binarySearch(int[] array, int a) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == a) {
                return a;
            } else if (array[mid] < a) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static int count(int[] a) {
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                int result = binarySearch(a, -(a[i] + a[j]));
                if (result > j && result > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
public class Solution {

    private Solution() {

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        ThreeSum tsum = new ThreeSum(array, n);
        System.out.println(tsum.count(array));
    }
}