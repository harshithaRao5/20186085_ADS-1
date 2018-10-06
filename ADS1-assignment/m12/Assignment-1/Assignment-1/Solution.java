import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for student details.
 */
class StudentDetails implements Comparable<StudentDetails> {
	/**
	 * { var_description }
	 */
	private String name;
	/**
	 * { var_description }
	 */
	private String dateOfBirth;
	/**
	 * { var_description }
	 */
	private int subject1;
	/**
	 * { var_description }
	 */
	private int subject2;
	/**
	 * { var_description }
	 */
	private int subject3;
	/**
	 * { var_description }
	 */
	private int totalmarks;
	/**
	 * { var_description }
	 */
	private static String category;
	/**
	 * Constructs the object.
	 *
	 * @param      n     { parameter_description }
	 * @param      dob   The dob
	 * @param      s1    The s 1
	 * @param      s2    The s 2
	 * @param      s3    The s 3
	 * @param      tm    The time
	 * @param      rc    The rectangle
	 */
	StudentDetails(final String n, final String dob, final int s1,
	               final int s2, final int s3, final int tm, final String rc) {
		this.name = n;
		this.dateOfBirth = dob;
		this.subject1 = s1;
		this.subject2 = s2;
		this.subject3 = s3;
		this.totalmarks = tm;
		this.category = rc;
	}
	/**
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Gets the dob.
	 *
	 * @return     The dob.
	 */
	public String getDOB() {
		return this.dateOfBirth;
	}
	/**
	 * Gets the subject 1.
	 *
	 * @return     The subject 1.
	 */
	public int getSubject1() {
		return this.subject1;
	}
	/**
	 * Gets the subject 2.
	 *
	 * @return     The subject 2.
	 */
	public int getSubject2() {
		return this.subject2;
	}
	/**
	 * Gets the subject 3.
	 *
	 * @return     The subject 3.
	 */
	public int getSubject3() {
		return this.subject3;
	}
	/**
	 * Gets the totalmarks.
	 *
	 * @return     The totalmarks.
	 */
	public int getTotalmarks() {
		return this.totalmarks;
	}
	/**
	 * Gets the category.
	 *
	 * @return     The category.
	 */
	public static String getCategory() {
		return category;
	}
	/**
	 * { function_description }
	 *
	 * @param      that  The that
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(final StudentDetails that) {
		//Date dateobj = new Date();
		if (this.getTotalmarks() > that.getTotalmarks()) {
			return 1;
		} else if (this.getTotalmarks() < that.getTotalmarks()) {
			return -1;
		}
		if (this.getSubject3() > that.getSubject3()) {
			return 1;
		} else if (this.getSubject3() < that.getSubject3()) {
			return -1;
		}
		if (this.getSubject2() > that.getSubject2()) {
			return 1;
		} else if (this.getSubject2() < this.getSubject2()) {
			return -1;
		}
		// if (this.getDOB().dateobj.compareTo(that.getDOB()) == 1) {
		// 	return 1;
		// } else if (this.getDOB().dateobj.compareTo(that.getDOB()) == -1) {
		// 	return -1;
		// }
		return 0;
	}
}
/**
 * Class for sort.
 */
class Sort {
	/**
	 * { var_description }
	 */
	private StudentDetails[] studentArray;
	/**
	 * { var_description }
	 */
	private int size;
	/**
	 * { var_description }
	 */
	private static int TEN = 10;
	/**
	 * Constructs the object.
	 */
	Sort() {
		this.studentArray = new StudentDetails[TEN];
		this.size = 0;
	}
	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int size() {
		return size;
	}
	/**
	 * { function_description }
	 */
	public void resize() {
		studentArray = Arrays.copyOf(studentArray,
		                             2 * studentArray.length);
	}
	/**
	 * { function_description }
	 *
	 * @param      student  The student
	 */
	public void add(final StudentDetails student) {
		if (size == studentArray.length) {
			resize();
		}
		studentArray[size++] = student;
	}
	/**
	 * { function_description }
	 */
	public void insertionsort() {
		for (int i = 0; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (studentArray[j].compareTo(studentArray[j - 1]) == 1) {
					exchange(studentArray, j, j - 1);
				} else {
					break;
				}
			}
		}
	}
	/**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	public void exchange(final Comparable[] a, final int i, final int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		int k = 0;
		String str = "";
		for (k = 0; k < size - 1; k++) {
			str += studentArray[k].getName() + "," + studentArray[k].getTotalmarks() + "," + studentArray[k].getCategory() + "\n";
		}
		str += studentArray[k].getName() + "," + studentArray[k].getTotalmarks() + "," + studentArray[k].getCategory();
		return str;
	}

}
/**
 * Class for solution.
 */
public class Solution {
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
		Sort sortobj = new Sort();
		int students = Integer.parseInt(sc.nextLine());
		int vacancies = Integer.parseInt(sc.nextLine());
		int unreserved = Integer.parseInt(sc.nextLine());
		int bc = Integer.parseInt(sc.nextLine());
		int sC = Integer.parseInt(sc.nextLine());
		int st = Integer.parseInt(sc.nextLine());
		Reserve resobj = new Reserve(vacancies, unreserved, bc, sC, st);
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			sortobj.add(new StudentDetails(tokens[0], tokens[1],
			                               Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
			                               Integer.parseInt(tokens[4]),
			                               Integer.parseInt(tokens[5]), tokens[6]));
		}
		sortobj.insertionsort();
		System.out.println(sortobj);
		System.out.println();
		resobj.reservation();

	}
}