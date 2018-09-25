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
	 *the array.
	 */
	private boolean[] array;
	/**
	 *object declaration for class.
	 */
    private WeightedQuickUnionUF wu;
    /**
     *array size.
     */
    private int arraySize;
    /**
     *size
     */
    private int size;
    /**
     * initializing count.
     */
    private int count;
    /**
     *first row;
     */
    private int top;
    /**
     * last row
     */
    private int bottom;
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
        this.arraySize = n;
        this.size = n * n;
        this.top = size;
        this.bottom = size + 1;
        this.count = 0;
        wu = new WeightedQuickUnionUF(size + 2);
        array = new boolean[size];
        for (int i = 0; i < arraySize; i++) {
            wu.union(top, i);
            wu.union(bottom, size - i - 1);
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
    	return (arraySize * (row - 1)) + (col - 1);
    }
    /**
     * Connects open sites(== full site).
     *
     * @param      row   The row
     * @param      col   The col
     */
    private void connectOpenSites(final int row, final int col) {
        if (array[col] && !wu.connected(row, col)) {
            wu.union(row, col);
        }
    }
    /**
     * method that opens the blocked site.
     *
     * @param      row     The row
     * @param      column  The column
     */
	public void open(final int row, final int col) {
		int index = toOneD(row, col);
        array[index] = true;
        count++;
        int toprow = index - arraySize;
        int bottomrow = index + arraySize;
        if (arraySize == 1) {
            wu.union(top, index);
            wu.union(bottom, index);
        }
        if (bottomrow < size) { 		//bottom
            connectOpenSites(index, bottomrow);
        }
        if (toprow >= 0) { 				//top
            connectOpenSites(index, toprow);
        }
        if (col == 1) { 				//left
            if (col != arraySize) {
                connectOpenSites(index, index + 1);
            }
            return;
        }
        if (col == arraySize) { 		//right
            connectOpenSites(index, index - 1);
            return;
        }
        connectOpenSites(index, index + 1);
        connectOpenSites(index, index - 1);
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
		return array[toOneD(row, col)];
	}
	// /**
	//  * Determines if full.
	//  *
	//  * @param      row   The row
	//  * @param      col   The col
	//  *
	//  * @return     True if full, False otherwise.
	//  */
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
		return wu.connected(top, bottom);
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
		Scanner scan = new Scanner(System.in);
		// int size = scan.nextInt();
		// while (scan.hasNext()) {
		// 	int rows = scan.nextInt();
		// 	int columns = scan.nextInt();
		// }
		int n = Integer.parseInt(scan.nextLine());
		Percolation pobj = new Percolation(n);
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			pobj.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		System.out.println(pobj.percolates() && pobj.numberOfOpenSites() != 0);
	}
}
