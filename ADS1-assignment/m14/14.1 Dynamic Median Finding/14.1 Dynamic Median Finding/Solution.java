import java.util.Scanner;
public final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        MinPQ<Float> minpq = new MinPQ<Float>(n);
        MaxPQ<Float> maxpq = new MaxPQ<Float>(n);
        float median = 0.0f;
        for (int i = 0; i < n; i++) {
            float k = scan.nextFloat();
            if (k > median) {
                minpq.insert(k);
            } else {
                maxpq.insert(k);
            }
            if (maxpq.size() - minpq.size() > 1) {
                float x = maxpq.delMax();
                minpq.insert(x);
            }
            if (minpq.size() - maxpq.size() > 1) {
                float y = minpq.delMin();
                maxpq.insert(y);
            }
            if (minpq.size() == maxpq.size()) {
                median = (minpq.min() + maxpq.max()) / 2;
                System.out.println(median);
            }
            if (maxpq.size() > minpq.size()) {
                median = maxpq.max();
                System.out.println(median);
            }
            if (minpq.size() > maxpq.size()) {
                median = minpq.min();
                System.out.println(median);
            }

        }
	}
}
