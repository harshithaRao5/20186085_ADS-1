import java.util.Scanner;
/**
 * Class for student details.
 */
class StudentDetails {
	/**
	 * { var_description }
	 */
	private int roll_number;
	/**
	 * { var_description }
	 */
	String student_name;
	/**
	 * Constructs the object.
	 *
	 * @param      rn    { parameter_description }
	 * @param      sn    The serial number
	 */
	StudentDetails(final int rn, final String sn) {
		this.roll_number = rn;
		this.student_name = sn;
	}
	/**
	 * Gets the roll number.
	 *
	 * @return     The roll number.
	 */
	public int getRollNumber() {
		return this.roll_number;
	}
	/**
	 * Gets the student name.
	 *
	 * @return     The student name.
	 */
	public String getStudentName() {
		return student_name;
	}

}
/**
 * { item_description }
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
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
			if (input[0].equals("BE")) {
				String[] s = bstobj.keys(Double.parseDouble(input[1]), Double.parseDouble(input[2])).toString().split(" ");
				for (int i = 0; i < s.length; i++) {
					System.out.println(bstobj.get(Double.parseDouble(s[i])).student_name);
				}
			} else if (input[0].equals("LE")) {
				double min = bstobj.min();
				String[] s = bstobj.keys(min, Double.parseDouble(input[1])).toString().split(" ");
				for (int i = 0; i < s.length; i++) {
					System.out.println(bstobj.get(Double.parseDouble(s[i])).student_name);
				}


			} else if (input[0].equals("GE")) {
				double max = bstobj.max();
				String[] s = bstobj.keys(max, Double.parseDouble(input[1])).toString().split(" ");
				for (int i = 0; i < s.length; i++) {
					System.out.println(bstobj.get(Double.parseDouble(s[i])).student_name);
				}

			}

		}
	}
}