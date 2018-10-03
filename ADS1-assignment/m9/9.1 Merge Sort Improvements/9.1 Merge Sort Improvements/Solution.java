import java.util.Scanner;
class Merge {
	private int CUTOFF = 7;
	Merge() {

	}
	private void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
		// assert isSorted(array, low, mid);
		// assert isSorted(array, mid+1, high);
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				array[k] = aux[j++];
			} else if (j > high) {
				array[k] = aux[i++];
			} else if (less(aux[j], (aux[i]))) {
				array[k] = aux[j++];
			} else {
				array[k] = aux[i++];
			}
		}
		//assert isSorted(aux,low,high);
	}
	private void sort(Comparable[]array, Comparable[]aux, int low, int high) {
		if (high <= low + CUTOFF) {
			insertionsort(array, low, high);
			System.out.println("Insertion sort method invoked...");
			return;
		}

		int mid = low + (high - low) / 2;
		sort(array, aux, 0, mid);
		sort(array, aux, mid + 1, high);
		if (!less(array[mid + 1], (array[mid]))) {
			System.out.println("Array is already sorted. So, skipped the call to merge...");
			return;
		}
		merge(array, aux, low, mid, high);
	}
	public void sort(Comparable[] array) {
		Comparable[] aux = new Comparable[array.length];
		sort(array, aux, 0, array.length - 1);
		//assert isSorted(array);
	}
	public void insertionsort(Comparable[] array, int i, int j) {
		for (i = 0; i < array.length; i++) {
			for (j = i; j > 0; j--) {
				if (less(array[j], (array[j - 1]))) {
					exchange(array, j, j - 1);
				} else {
					break;
				}
			}
		}
	}
	/**
	 * exchange method.
	 *
	 * @param      a array.
	 * @param      i integer.
	 * @param      j integer.
	 */
	public void exchange(final Comparable[] a, final int i, final int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	 public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
	// public boolean isSorted(String[] array) {
	// 	return isSorted(array, 0, a.length - 1);
	// }
	public String toString(Comparable[] array) {
		//System.out.println("hello");
		int k = 0;
		String s = "[";
		for (k = 0; k < array.length - 1; k++) {
			s += array[k] + ", ";
			//System.out.println(s + "string");
		}
		s += array[k] + "]";
		return s;
	}
}


public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int n = Integer.parseInt(sc.nextLine());
		// for (int i = 0; i < n; i++) {
		Merge mergeobj = new Merge();
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			mergeobj.sort(tokens);
			System.out.println(mergeobj.toString(tokens));
			System.out.println();
		}

	}
}