import java.util.Scanner;
class Stocks implements Comparable<Stocks> {
	private String stockname;
	private Float percentchange;
	Stocks(){

	}
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
	public int compareTo(final Stocks that) {
		if (this.percentchange < that.percentchange) {
			return -1;
		} else if (this.percentchange > that.percentchange) {
			return 1;
		} else {
			return 0;
		}

	}


}
public final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		MaxPQ maxpq = new MaxPQ();
		MinPQ minpq = new MinPQ();
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			maxpq.insert(new Stocks(tokens[0],Float.parseFloat(tokens[1])));
			minpq.insert(new Stocks(tokens[0],Float.parseFloat(tokens[1])));
		}
		System.out.println(maxpq);
		System.out.println(minpq);
		int m = Integer.parseInt(sc.nextLine());
	}
}