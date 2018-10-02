import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for tournament.
 */
class Tournament implements Comparable<Tournament> {
    /**
     * declaration of teamName.
     */
    private String teamName;
    /**
     * declaration of win.
     */
    private int wins;
    /**
     * declaration of losses.
     */
    private int losses;
    /**
     * declaration of draw.
     */
    private int draws;
    /**
     * Constructs the object.
     */
    Tournament() {
    }
    /**
     * Constructs the object.
     *
     * @param      name  The name
     * @param      win   The window
     * @param      loss  The loss
     * @param      draw  The draw
     */
    Tournament(final String name, final int win,
               final int loss, final int draw) {
        this.teamName = name;
        this.wins = win;
        this.losses = loss;
        this.draws = draw;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.teamName;
    }
    /**
     * Gets the wins.
     *
     * @return     The wins.
     */
    public int getWins() {
        return this.wins;
    }
    /**
     * Gets the loss.
     *
     * @return     The loss.
     */
    public int getLoss() {
        return this.losses;
    }
    /**
     * Gets the draws.
     *
     * @return     The draws.
     */
    public int getDraws() {
        return this.draws;
    }
    /**
     * compare method to compare the array.
     * @param      that  The that
     *
     * @return  integer.
     */
    public int compareTo(final Tournament that) {
        if (this.getWins() > that.getWins()) {
            return 1;
        } else if (this.getWins() < that.getWins()) {
            return -1;
        }
        if (this.getLoss() < that.getLoss()) {
            return 1;
        } else if (this.getLoss() > that.getLoss()) {
            return -1;
        }
        if (this.getDraws() > that.getDraws()) {
            return 1;
        } else if (this.getDraws() < that.getDraws()) {
            return -1;
        }
        return 0;
    }

}
/**
 * Class for insertion sort.
 */
class InsertionSort {
    /**
     * declaration tournamentArray.
     */
    private Tournament[]tournamentArray;
    /**
     * declaration size.
     */
    private int size;
    /**
     * magic number case.
     */
    private static final int TEN = 10;
    /**
     * Constructs the object.
     */
    InsertionSort() {
        this.size = 0;
        this.tournamentArray = new Tournament[TEN];
    }
    /**
     * size method.
     *
     * @return size of array.
     */
    public int size() {
        return size;
    }
    /**
     *resize the array.
     */
    public void resize() {
        tournamentArray = Arrays.copyOf(tournamentArray,
            2 * tournamentArray.length);
    }
    /**
     * add method.
     *
     * @param      game  The game
     */
    public void add(final Tournament game) {
        if (size == tournamentArray.length) {
            resize();
        }
        tournamentArray[size++] = game;
    }
    /**
     * sorting method to sort the arrays.
     */
    public void insertionsort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (tournamentArray[j].compareTo(tournamentArray[j - 1]) == 1) {
                    exchange(tournamentArray, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
    /**
     * exchange method.
     *
     * @param      a array.
     * @param      i integer.
     * @param      j integer.
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
            str += tournamentArray[k].getName() + ",";
        }
        str += tournamentArray[k].getName();
        return str;
    }
}
/**
 *client class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        InsertionSort isobj = new InsertionSort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            isobj.add(new Tournament(tokens[0], Integer.parseInt(tokens[1]),
            Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1])));
        }
        isobj.insertionsort();
        System.out.println(isobj);
    }
}
