import java.util.Scanner;
import java.util.Arrays;
class Tournament implements Comparable {
	private String teamName;
    private int wins;
    private int losses;
    private int draws;
    Tournament() {

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
    public int compareTo(Object object) {
    	Tournament that = (Tournament) object;
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
class InsertionSort {
	private Tournament[]tournamentArray;
	private int size;
	InsertionSort() {
		this.size = 0;
		this.tournamentArray = new Tournament[10];
	}
	public int size() {
		return size;
	}
	public void resize() {
		tournamentArray = Arrays.copyOf(tournamentArray, 2*tournamentArray.length);
	}
	public void add(Tournament game) {
		if(size == tournamentArray.length) {
			resize();
		}
		tournamentArray[size++] = game;
	}
	public void insertionsort() {
		int n = tournamentArray.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (tournamentArray[j].compareTo(tournamentArray[j-1]) == 1) {
					exchange(tournamentArray, j , j-1);
				} else {
					break;
				}
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
		InsertionSort isobj = new InsertionSort();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			isobj.add(new Tournament(tokens[0], Integer.parseInt(tokens[1]),
                Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
		}
		isobj.insertionsort();
		System.out.println(isobj);
	}
}