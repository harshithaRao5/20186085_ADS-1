import java.util.Scanner;
/**
 * Class for book details.
 */
class BookDetails implements Comparable {
    /**
     * variable declaration.
     */
    private String name;
    /**
     * variable declaration.
     */
    private String author;
    /**
     * variable declaration.
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      bookname    The bookname
     * @param      bookauthor  The bookauthor
     * @param      bookprice   The bookprice
     */
    BookDetails(final String bookname,
        final String bookauthor, final float bookprice) {
        this.name = bookname;
        this.author = bookauthor;
        this.price = bookprice;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public float getPrice() {
        return this.price;
    }
    /**
     * compare to method that returns integer.
     *
     * @param      object  The object
     *
     * @return  integer.
     */
    public int compareTo(final Object object) {
        BookDetails that = (BookDetails) object;
        return this.name.compareTo(that.name);
    }
}
/**
 * Class for binary search tree.
 */
class BinarySearchTree {
    /**
     * variable declaration.
     */
    private Node root;
    /**
     * Class for node.
     */
    private final class Node {
        /**
         * variable declaration.
         */
        private BookDetails key;
        /**
         * variable declaration.
         */
        private int val;
        /**
         * variable declaration.
         */
        private Node left;
        /**
         * variable declaration.
         */
        private Node right;
        /**
         * Constructs the object.
         *
         * @param      key1   The key
         * @param      val1  The value
         */
        private Node(final BookDetails key1, final int val1) {
            this.key = key1;
            this.val = val1;
            left = null;
            right = null;
        }
    }
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * get method.
     *time complexity is O(logN)
     * @param      key   The key
     *
     * @return  integer.
     */
    public int get(final BookDetails key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else if (cmp == 0) {
                return x.val;
            }
        }
        return -1;
    }
    /**
     * put method to insert the key, value.
     *time complexity is O(N)
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final BookDetails key, final int val) {
        root = put(root, key, val);
    }
    /**
     * overloaded constructor.
     * time complexity is O(N)
     * @param      x   root node.
     * @param      key   The key
     * @param      val   The value
     *
     * @return root
     */
    private Node put(final Node x, final BookDetails key, final int val) {
        if (x == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp == 0) {
            x.val = val;
        }
        return x;
    }
}
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
        BinarySearchTree bstobj = new BinarySearchTree();
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                BookDetails deobj = new BookDetails(tokens[1],
                 tokens[2], Float.parseFloat(tokens[2 + 1]));
                bstobj.put(deobj, Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                deobj = new BookDetails(tokens[1], tokens[2],
                    Float.parseFloat(tokens[2 + 1]));
                if (bstobj.get(deobj) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bstobj.get(deobj));
                }
                break;
            default:
                break;
            }
        }
    }
}
