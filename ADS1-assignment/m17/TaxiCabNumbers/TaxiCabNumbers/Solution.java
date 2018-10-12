import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * variable declaration.
     */
    private final int sum;
    /**
     * variable declaration.
     */
    private final int i;
    /**
     * variable declaration.
     */
    private final int j;
    /**
     * Constructs the object.
     *
     * @param      i integer.
     * @param      j integer.
     */
    public CubeSum(int i, int j) {
        this.sum = i * i * i + j * j * j;
        this.i = i;
        this.j = j;
    }
    /**
     * Gets the sum.
     *
     * @return     The sum.
     */
    public int getSum() {
        return sum;
    }
    /**
     * gets the number.
     *
     * @return number.
     */
    public int geti() {
        return i;
    }
    /**
     * gets the number.
     *
     * @return number.
     */
    public int getj() {
        return j;
    }
    /**
     * compare to method.
     *
     * @param      that  The that
     *
     * @return  integer.
     */
    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }
}
/**
 * client program.
 */
public final class Solution {
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        int n = 600;
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int count = 0;
        int temp = 1;
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            System.out.println(s.getSum()+" "+temp);
            if (temp == s.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if(count == M - 1) {
                N--;
                if (N == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }
            temp = s.getSum();
            if (s.getj()< n) {
                pq.insert(new CubeSum(s.geti(), s.getj()+ 1));
            }
            }
        }

}
