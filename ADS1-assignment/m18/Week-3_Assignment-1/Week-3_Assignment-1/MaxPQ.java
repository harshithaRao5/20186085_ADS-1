import java.util.Arrays;
class MaxPQ {
	private Stocks[] stockarray;
	private int size;
	MaxPQ() {

	}
	public MaxPQ(int initCapacity) {
        stockarray = (Stocks[]) new Object[initCapacity + 1];
        size = 0;
    }
	public int size() {
		return size;
	}
	private void resize(int capacity) {
        Stocks[] temp = (Stocks[]) new Object[capacity];
        for (int i = 1; i <= size; i++) {
            temp[i] = stockarray[i];
        }
        stockarray = temp;
    }
	public MaxPQ(Stocks[] stock) {
		int n = stock.length;
		stockarray = (Stocks[]) new Object[stock.length + 1];
		for (int i = 0; i < n; i++)
			stockarray[i + 1] = stock[i];
		for (int k = n / 2; k >= 1; k--)
			sink(k);
	}
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= size) {
			int j = 2 * k;
			if (j < size && less(j, j + 1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	private boolean less(int i, int j) {
		return stockarray[i].compareTo(stockarray[j]) < 0;
	}

	private void exch(int i, int j) {
		Stocks swap = stockarray[i];
		stockarray[i] = stockarray[j];
		stockarray[j] = swap;
	}
	public void insert(Stocks x) {
		if (size == size() - 1) {
			resize(2 * size());
		}
		stockarray[size++] = x;
		swim(size);
	}
	public Stocks delMax() {
		Stocks max = stockarray[1];
		exch(1, size--);
		sink(1);
		stockarray[size + 1] = null;   // to avoid loiteing and help with garbage collection
		if ((size > 0) && (size == (stockarray.length - 1) / 4)) resize(size()/2);

		return max;
	}
	public String toString() {
		String s = "";
		for (int j = 0; j < 5; j++) {
			int i = 0;
			for (i = 0; i < size() - 1; i++) {
				s += stockarray[i].getStockName() + " " + stockarray[i].getPercentChange() + "\n";
			}
			s += stockarray[i].getStockName() + " " + stockarray[i].getPercentChange();
		}
		return s;
	}
}