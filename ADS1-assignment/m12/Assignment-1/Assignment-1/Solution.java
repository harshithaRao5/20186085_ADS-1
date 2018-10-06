import java.util.Scanner;
import java.util.Arrays;
class StudentDetails implements Comparable<StudentDetails> {
	private String name;
	private String dateOfBirth;
	private int subject1;
	private int subject2;
	private int subject3;
	private int totalmarks;
	private String category;
	StudentDetails(String n, String dob, int s1,
		int s2, int s3, int tm, String rc) {
		this.name = n;
		this.dateOfBirth = dob;
		this.subject1 = s1;
		this.subject2 = s2;
		this.subject3 = s3;
		this.totalmarks = tm;
		this.category = rc;
	}
	public String getName() {
		return this.name;
	}
	public String getDOB() {
		return this.dateOfBirth;
	}
	public int getSubject1() {
		return this.subject1;
	}
	public int getSubject2() {
		return this.subject2;
	}
	public int getSubject3() {
		return this.subject3;
	}
	public int getTotalmarks() {
		return this.totalmarks;
	}
	public String getCategory() {
		return this.category;
	}
	public int compareTo(StudentDetails that) {
		//Date dateobj = new Date();
		if(this.getTotalmarks() > that.getTotalmarks()) {
			return 1;
		} else if (this.getTotalmarks() < that.getTotalmarks()) {
			return -1;
		}
		if(this.getSubject3() > that.getSubject3()) {
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
class Sort {
	private StudentDetails[] studentArray;
	private int size;
	Sort() {
		this.studentArray = new StudentDetails[10];
		this.size = 0;
	}
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
    public void exchange(final Comparable[] a, final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public String toString() {
        int k = 0;
        String str = "";
        for (k = 0; k < size - 1; k++) {
            str += studentArray[k].getName() + ","+studentArray[k].getTotalmarks()+","+studentArray[k].getCategory();
        }
        str += studentArray[k].getName() + ","+studentArray[k].getTotalmarks()+","+studentArray[k].getCategory();
        return str;
    }

}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sort sortobj = new Sort();
		while(sc.hasNext()) {
		String[] tokens = sc.nextLine().split(",");
		sortobj.add(new StudentDetails(tokens[0], tokens[1],
			Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),
			Integer.parseInt(tokens[4]),
			Integer.parseInt(tokens[5]),tokens[6]));
		}
		sortobj.insertionsort();
		System.out.println(sortobj);
	}
}