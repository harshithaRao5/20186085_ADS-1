import java.util.Arrays;
/**
 * Class for reserve.
 */
public class Reserve {
	/**
	 * { var_description }
	 */
	private int vacancies;
	/**
	 * { var_description }
	 */
	private int unreserved;
	/**
	 * { var_description }
	 */
	private int bc;
	/**
	 * { var_description }
	 */
	private int sc;
	/**
	 * { var_description }
	 */
	private int st;
	/**
	 * { var_description }
	 */
	private StudentDetails[] studentArray = new StudentDetails[10];
	/**
	 * { var_description }
	 */
	private int size = 0;
	/**
	 * Constructs the object.
	 *
	 * @param      vac   The vac
	 * @param      ur    { parameter_description }
	 * @param      bc1   The bc 1
	 * @param      sc1   The screen 1
	 * @param      st1   The st 1
	 */
	Reserve(final int vac, final int ur, final int bc1, final int sc1, final int st1) {
		this.vacancies = vac;
		this.unreserved = ur;
		this.bc = bc1;
		this.sc = sc1;
		this.st = st1;
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
	public void reservation() {
		Sort obj = new Sort();
		for (int s = 0; s < studentArray.length; s++) {
			//System.out.println("hello");
			for (int i = 0; i <= unreserved; i++) {
				if (studentArray[s].getCategory().equals("open")) {
					obj.toString();
					break;
				}
			}
			for (int j = 0; j <= bc; j++) {
				if (studentArray[s].getCategory().equals("BC")) {
					obj.toString();
					break;
				}
			}
			for (int k = 0; k <= sc; k++) {
				if (studentArray[s].getCategory().equals("SC")) {
					obj.toString();
					break;
				}
			}
			for (int l = 0; l <= st; l++) {
				if (studentArray[s].getCategory().equals("ST")) {
					obj.toString();
					break;
				}
			}
		}
	}
}