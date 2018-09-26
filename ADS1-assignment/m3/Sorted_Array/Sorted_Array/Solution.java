import java.util.Scanner;
import java.util.Arrays;
class SortedArray {
	private int[] firstarray;
	private int[] secondarray;
	SortedArray(int[] a1, int[] a2) {
		this.firstarray = a1;
		this.secondarray = a2;
	}
	public String sort(int[] arr1, int[] arr2) {
		int i = 0;
		int j = 0, k = 0;
		int[] array = new int[arr1.length + arr2.length];
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				array[k++] = arr1[i++];
			} else {
				array[k++] = arr2[j++];
			}
		}
		while (i < arr1.length) {
			array[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			array[k++] = arr2[j++];
		}

		// System.out.println(s.sortedArray(arr1, arr2));
		// Collections.sort(array);
		// return Arrays.toString(array);
		String res = "";
		int index = 0;
		for (index = 0; index < array.length-1; index++) {
			res += array[index] + ",";
		} res += array[index];
		return res;
	}
}


public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size1 = Integer.parseInt(scan.nextLine());
		int size2 = Integer.parseInt(scan.nextLine());
		String[] arraytemp1 = scan.nextLine().split(",");
		String[] arraytemp2 = scan.nextLine().split(",");
		int[] array1 = new int[size1];
		int[] array2 = new int[size2];
		for (int i = 0; i < size1; i++) {
			array1[i] = Integer.parseInt(arraytemp1[i]);
		}
		for (int j = 0; j < size2; j++) {
			array2[j] = Integer.parseInt(arraytemp2[j]);
		}
		SortedArray sa = new SortedArray(array1, array2);
		System.out.println(sa.sort(array1, array2));

	}
}