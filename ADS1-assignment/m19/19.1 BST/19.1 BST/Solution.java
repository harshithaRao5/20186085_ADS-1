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
    public String toString() {
        return getName()+", "+getAuthor()+", "+getPrice();
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
         * variable declaration.
         */
        private int size;
        /**
         * Constructs the object.
         *
         * @param      key1   The key
         * @param      val1  The value
         */
        private Node(final BookDetails key1, final int val1, final int s) {
            this.key = key1;
            this.val = val1;
            this.size = s;
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
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
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
            return new Node(key, val, 1);
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
    /**
     * min element.
     *
     * @return minimum.
     */
    public BookDetails min() {
        return min(root).key;
    }
    /**
     * overloaded constructor.
     *
     * @param      x Node
     *
     * @return minimum.
     */
    private Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * maximum element.
     *
     * @return maximum.
     */
    public BookDetails max() {
        return max(root).key;
    }
    /**
     * overloaded constructor.
     *
     * @param      x Node
     *
     * @return maximum.
     */
    private Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * floor method.
     *
     * @param      key   The key
     *
     * @return  key
     */
    public BookDetails floor(BookDetails key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     *
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node floor(Node x, BookDetails key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    public BookDetails ceiling(BookDetails key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    private Node ceiling(Node x, BookDetails key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
    public BookDetails select(int k) {
        Node x = select(root, k);
        return x.key;
    }
    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    public int rank(BookDetails key) {
        return rank(key, root);
    }

    // Number of keys in the subtree less than key.
    private int rank(BookDetails key, Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
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
        while (sc.hasNext()) {
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
            case "max":
                System.out.println(bstobj.max());
                break;
            case "min":
                System.out.println(bstobj.min());
                break;
            case "select":
                System.out.println(bstobj.select(Integer.parseInt(tokens[1])));
                break;
            case "floor":
                deobj = new BookDetails(tokens[1],
                                        tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bstobj.floor(deobj));
                break;
            case "ceiling":
                deobj = new BookDetails(tokens[1],
                                        tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bstobj.ceiling(deobj));
                break;
            default:
                break;
            }
        }
    }
}
