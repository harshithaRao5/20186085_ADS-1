// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
	/**
	 *the 2 dimensional array.
	 */
	private boolean[][] array;
	/**
	 *object declaration for class.
	 */
    private WeightedQuickUnionUF wu;
    /**
     *initializing array size.
     */
    private int arraySize;
    /**
     * initializing count.
     */
    private int count = 0;
    /**
     * Constructs the object.
     */
    protected Percolation() {

    }
    /**
     * Constructs the object.
     *
     * @param n int
     */
    public Percolation(final int n) {
        int arrSize = n;
        array = new boolean[n][n];
        wu = new WeightedQuickUnionUF((n * n));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = false;
            }
        }
    }
    /**
     * method to convert from two dimensional to one dimensional.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return  onedimensional array
     */
    public int toOneD(final int row, final int col) {
    	return (arraySize * row) + col;
    }
    /**
     * method that opens the blocked site.
     *
     * @param      row     The row
     * @param      column  The column
     */
	public void open(final int row, final int column) {
		int row1 = row - 1;
		int col1 = column - 1;
		array[row1][col1] = true;
		count++;
		if (row1 - 1 >= 0 && isOpen(row - 1, column)) {
			wu.union(toOneD(row, column), toOneD(row - 1, column));
		}
		if (row1 + 1 < arraySize && isOpen(row + 1, column)) {
			wu.union(toOneD(row, column), toOneD(row + 1, column));
		}
		if (col1 - 1 >= 0 && isOpen(row, column - 1)) {
			wu.union(toOneD(row, column), toOneD(row, column - 1));
		}
		if (col1 + 1 < arraySize && isOpen(row, column + 1)) {
			wu.union(toOneD(row, column), toOneD(row, column + 1));
		}

	}
	/**
	 * Determines if open.
	 *
	 * @param      row   The row
	 * @param      col   The col
	 *
	 * @return     True if open, False otherwise.
	 */
	public boolean isOpen(final int row, final int col) {
		return array[row - 1][col - 1];
	}
	/**
	 * Determines if full.
	 *
	 * @param      row   The row
	 * @param      col   The col
	 *
	 * @return     True if full, False otherwise.
	 */
	public boolean isFull(final int row, final int col) {
		if (isOpen(row, col)) {
			for (int i = 0; i < arraySize; i++) {
				if (wu.connected(toOneD(row, col), i)) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * return number of open sites.
	 *
	 * @return count
	 */
	public int numberOfOpenSites() {
		return count;
	}
	/**
	 * method to check whether there is a flow.
	 *
	 * @return boolean
	 */
	public boolean percolates() {
		// if (arraySize == 1) {
		// 	if (isOpen(1, 1)) {
		// 		return true;
		// 	}
		// }
		for (int j = (arraySize * (arraySize - 1) - 1);
			j < (arraySize * arraySize); j++) {
			for (int i = 0; i < arraySize; i++) {
				if (wu.connected(i, j)) {
					return true;
				}
			}
		}
		return false;
	}
}
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	protected Solution() {

	}
	/**
	 * main method to read input.
	 *
	 * @param args String
	 */
	public static void main(final String[] args) {
		Percolation pobj = new Percolation();
		//WeightedQuickUnionUF wobj = new WeightedQuickUnionUF();
		Scanner scan = new Scanner(System.in);
		// int size = scan.nextInt();
		// while (scan.hasNext()) {
		// 	int rows = scan.nextInt();
		// 	int columns = scan.nextInt();
		// }
		int n = Integer.parseInt(scan.nextLine());
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			pobj.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[0]));
		}
		System.out.println(pobj.percolates());
	}
}