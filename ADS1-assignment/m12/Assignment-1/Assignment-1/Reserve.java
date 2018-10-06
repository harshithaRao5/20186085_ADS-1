import java.util.Arrays;
public class Reserve {
	private int vacancies;
	private int unreserved;
	private int bc;
	private int sc;
	private int st;
	Reserve(int vac, int ur, int bc1, int sc1, int st1) {
		this.vacancies = vac;
		this.unreserved = ur;
		this.bc = bc1;
		this.sc = sc1;
		this.st = st1;
	}
	private StudentDetails[] studentArray = new StudentDetails[10];
	private int size = 0;
	public int size() {
		return size;
	}
	public void resize() {
		studentArray = Arrays.copyOf(studentArray,
		                             2 * studentArray.length);
	}
	public void add(final StudentDetails student) {
		if (size == studentArray.length) {
			resize();
		}
		studentArray[size++] = student;
	}
	public void reservation() {
		Sort obj = new Sort();
		for (int s = 0; s < size; s++) {
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