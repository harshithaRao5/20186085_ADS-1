import java.util.Scanner;
/**
 * client program.
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
        LinearProbingHashST<Integer, String> hashobj =
     new LinearProbingHashST<Integer, String>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(",");
            String s = tokens[1] + "," + tokens[2];
            hashobj.put(Integer.parseInt(tokens[0]), s);
        }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String[] tokens = sc.nextLine().split(",");
            String s = hashobj.get(Integer.parseInt(tokens[1]));
            if (s == null) {
                System.out.println("Student doesn't exists...");

            } else {
                String[] tokens1 = s.split(",");
                if (Integer.parseInt(tokens[2]) == 1) {
                    System.out.println(tokens1[0]);
                } else {
                    System.out.println(Double.parseDouble(tokens1[1]));
                }
            }
        }
    }
}