import java.util.Scanner;
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		LinearProbingHashST<Integer, String> hashobj =
		    new LinearProbingHashST<Integer, String>();
		for (int i = 0; i < n; i++) {
			String[] tokens = sc.nextLine().split(",");
			String s = tokens[1] + "," + tokens[2];
			hashobj.put(Integer.parseInt(tokens[0]), s);
		}
		int m = Integer.parseInt(sc.nextLine());
		for (int j = 0; j < m; j++) {
			String[] tokens = sc.nextLine().split(" ");
			String s = hashobj.get(Integer.parseInt(tokens[1]));
			String[] tokens1 = s.split(",");
			if (Integer.parseInt(tokens[2]) == 1) {
				System.out.println(tokens1[0]);
			} else {
				System.out.println(Double.parseDouble(tokens1[1]));
			}
		}
	}
}