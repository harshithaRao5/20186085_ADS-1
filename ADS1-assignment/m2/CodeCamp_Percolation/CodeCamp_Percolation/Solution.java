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

class Percolation {
	private boolean[][] array;
    private WeightedQuickUnionUF wu;
    private int arraySize;
    private int count = 0;
    Percolation() {

    }
    public Percolation(int n) {
        int arrSize = n;
        array = new boolean[n][n];
        wu = new WeightedQuickUnionUF((n*n));
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                array[i][j] = false;
            }
        }
    }
    public int toOneD(int row, int col) {
    	return (arraySize*row) + col;
    }
	public void open(int row, int column) {
		int row1 = row - 1;
		int col1 = column - 1;
		array[row1][col1] = true;
		count++;
		if (row1 - 1 >= 0 && isOpen(row-1, column)) {
			wu.union(toOneD(row, column), toOneD(row-1, column));
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
	public boolean isOpen(int row, int col) {
		return array[row-1][col-1];
	}
	public boolean isFull(int row, int col) {
		if(isOpen(row, col)) {
			for (int i = 0; i < arraySize; i++) {
				if(wu.connected(toOneD(row, col), i)) {
					return true;
				}
			}
		}
		return false;
	}
	public int numberOfOpenSites() {

		return count;
	}
	public boolean percolates() {
		for (int j = (arraySize * (arraySize - 1)-1); j < arraySize * arraySize; j++) {
			for (int i = 0; i < arraySize; i++) {
				if (wu.connected(i, j)) {
					return true;
				}
			}
		}
		return false;
	}


}
public class Solution {
	public static void main(String[] args) {
		Percolation pobj = new Percolation();
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		while(scan.hasNext()) {
			int rows = scan.nextInt();
			int columns = scan.nextInt();
		}
		System.out.println(pobj.percolates());


	}
}