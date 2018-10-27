import java.util.Scanner;
class StudentDetails {
	private int roll_number;
	static String student_name;
	StudentDetails(final int rn, final String sn) {
		this.roll_number = rn;
		this.student_name = sn;
	}
	public int getRollNumber() {
		return this.roll_number;
	}
	public static String getStudentName() {
		return student_name;
	}

}
public final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		BST<Double, StudentDetails> bstobj = new BST<Double, StudentDetails>();
		for (int i = 0; i < n; i++) {
			String[] tokens = sc.nextLine().split(",");
			bstobj.put(Double.parseDouble(tokens[2]),
			           new StudentDetails(Integer.parseInt(tokens[0]), tokens[1]));
		}
		int m = Integer.parseInt(sc.nextLine());
		for (int j = 0; j < m; j++) {
			String[] input = sc.nextLine().split(" ");
			if(input[0].equals("BE")) {
				String[] s = bstobj.keys(Double.parseDouble(input[1]), Double.parseDouble(input[2])).toString().split(" ");
				for(int i =0; i<s.length;i++) {
					System.out.println(bstobj.get(Double.parseDouble(s[i])).student_name);
				}
			}

		}
	}
}