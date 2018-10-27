import java.util.Scanner;
class StudentDetails {
    /**
     * student name.
     */
	private String student_name;
    /**
     * marks variable.
     */
	private double total_marks;
    /**
     * Constructs the object.
     *
     * @param      sn    The serial number
     * @param      tm    The time
     */
	StudentDetails(final String sn, final double tm) {

		this.student_name = sn;
		this.total_marks = tm;
	}
    /**
     * Gets the student name.
     *
     * @return     The student name.
     */
	public String getStudentName() {
		return this.student_name;
	}
    /**
     * Gets the total marks.
     *
     * @return     The total marks.
     */
	public double getTotalMarks() {
		return this.total_marks;
	}
}
/**
 * client class
 */
public final class Solution {
    /**
     * Constructs the object.
     */
	private Solution() {
        //unused constructor.
	}
    /**
     * main method.
     *
     * @param      args  The arguments
     */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		LinearProbingHashST<Integer, StudentDetails>  hashobj
        = new LinearProbingHashST<Integer, StudentDetails>();
		for (int i = 0; i < n; i++) {
			String[] tokens = sc.nextLine().split(",");
			hashobj.put(Integer.parseInt(tokens[0]),
                new StudentDetails(tokens[1], Double.parseDouble(tokens[2])));
		}
		int m = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String[] tokens = sc.nextLine().split(",");
			StudentDetails s = hashobj.get(Integer.parseInt(tokens[1]));
			if (Integer.parseInt(tokens[2]) == 1) {
				System.out.println(s.getStudentName());
			} else {
				System.out.println(s.getTotalMarks());
			}
		}
	}
}