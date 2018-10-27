import java.util.Scanner;
class StudentDetails {

    private String student_name;
    private double total_marks;
    StudentDetails(String sn, double tm) {

        this.student_name = sn;
        this.total_marks = tm;
    }

    public String getStudentName() {
        return this.student_name;
    }
    public double getTotalMarks() {
        return this.total_marks;
    }
}
public final class Solution {
    private Solution() {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LinearProbingHashST<Integer, StudentDetails> hashobj =
            new LinearProbingHashST<Integer, StudentDetails>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(",");
            hashobj.put(Integer.parseInt(tokens[0]),
                new StudentDetails(tokens[1], Double.parseDouble(tokens[2])));
        }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String[] tokens = sc.nextLine().split(",");
            StudentDetails s = hashobj.get(Integer.parseInt(tokens[1]));
            if (s == null) {
                System.out.println("Student doesn't exists...");
            } else {
                if (Integer.parseInt(tokens[2]) == 1) {
                    System.out.println(s.getStudentName());
                } else {
                    System.out.println(s.getTotalMarks());
                }
            }
        }
    }
}