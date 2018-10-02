import java.util.Scanner;
import java.util.Arrays;
class Tournament implements Comparable<Tournament> {
    private String teamName;
    private int wins;
    private int losses;
    private int draws;
    Tournament() {
        this.teamName = null;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }
    Tournament(final String name, final int win, final int loss, final int draw) {
        this.teamName = name;
        this.wins = win;
        this.losses = loss;
        this.draws = draw;
    }
    public String getName() {
        return this.teamName;
    }
    public int getWins() {
        return this.wins;
    }
    public int getLoss() {
        return this.losses;
    }
    public int getDraws() {
        return this.draws;
    }
    public void setName(final String name) {
        this.teamName = name;
    }
    public void setWins(final int wins1) {
        this.wins = wins1;
    }
    public void setLoss(final int loss1) {
        this.losses = loss1;
    }
    public void setDraws(final int draw) {
        this.draws = draw;
    }
    public int compareTo(Tournament that) {

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
class SelectionSort {
    private Tournament[]tournamentArray;
    private int size;
    SelectionSort() {
        this.size = 0;
        this.tournamentArray = new Tournament[10];
    }
    public int size() {
        return size;
    }
    public void resize() {
        tournamentArray = Arrays.copyOf(tournamentArray, 2 * tournamentArray.length);
    }
    public void add(Tournament game) {
        if (size == tournamentArray.length) {
            resize();
        }
        tournamentArray[size++] = game;
    }
    public void selectionSort() {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (tournamentArray[j].compareTo(tournamentArray[min]) == 1) {
                    min = j;
                }
                exchange(tournamentArray, i, min);
            }
        }
    }
    public void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
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

public final class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SelectionSort isobj = new SelectionSort();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            isobj.add(new Tournament(tokens[0], Integer.parseInt(tokens[1]),
                                     Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
        }
        isobj.selectionSort();
        System.out.println(isobj);

    }
}