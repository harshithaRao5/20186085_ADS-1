import java.util.Scanner;
/**
 * Class for stocks.
 */
class Stocks implements Comparable<Stocks> {
    /**
     * { var_description }.
     */
    private String stockname;
    /**
     * { var_description }.
     */
    private Float percentchange;
    /**
     * Constructs the object.
     */
    Stocks() {

    }
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      change  The change
     */
    Stocks(final String name, final float change) {
        this.stockname = name;
        this.percentchange = change;
    }
    /**
     * Gets the stock name.
     *
     * @return     The stock name.
     */
    public String getStockName() {
        return this.stockname;
    }
    /**
     * Gets the percent change.
     *
     * @return     The percent change.
     */
    public Float getPercentChange() {
        return this.percentchange;
    }
    /**
     * { function_description }.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Stocks that) {
        if (this.percentchange < that.percentchange) {
            return -1;
        } else if (this.percentchange > that.percentchange) {
            return 1;
        } if (stockname.compareTo(that.stockname) > 0) {
            return 1;
        }
        if (stockname.compareTo(that.stockname) < 0) {
            return -1;
        } else {
                return 0;
            }

        }


    }
    /**
     * { item_description }.
     */
    public final class Solution {
        /**
         * Constructs the object.
         */
        private Solution() {

        }
        /**
         * { function_description }.
         *
         * @param      args  The arguments
         */
        public static void main(final String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = Integer.parseInt(sc.nextLine());
            final int five = 5;
            /**
             * 9 o clock
             */
            MinPQ<Stocks> minpq = new MinPQ<>();
            MaxPQ<Stocks> maxpq = new MaxPQ<>();
            for (int j = 0; j < n; j++) {
                String[] tokens = sc.nextLine().split(",");
                minpq.insert(new Stocks(tokens[0],
                                        Float.parseFloat(tokens[1])));
                maxpq.insert(new Stocks(tokens[0],
                                        Float.parseFloat(tokens[1])));

            }
            for (int i = 0; i < five; i++) {
                System.out.println(maxpq.delMax());
            }
            System.out.println();
            for (int i = 0; i < five; i++) {
                System.out.println(minpq.delMin());
            }
            System.out.println();
        }
    }
