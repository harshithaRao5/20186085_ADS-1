import java.util.Scanner;
class Stocks {
	private String stockname;
	private Float percentchange;
	Stocks(String name, float change) {
		this.stockname = name;
		this.percentchange = change;
	}
	public String getStockName() {
		return this.stockname;
	}
	public Float getPercentChange() {
		return this.percentchange;
	}

}
public final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			MinPQ<Float> minpq = new MinPQ<Float>();
			MaxPQ<Float> maxpq = new MaxPQ<Float>();
			Stocks stockobj = new Stocks(tokens[0],Float.parseFloat(tokens[1]));
			float median = 0.0f;
			for (int i = 0; i < n; i++) {
				// float k = scan.nextFloat();
				float k = stockobj.getPercentChange();
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
			}
			System.out.println(maxpq);
			System.out.println(minpq);

		}
	}
}