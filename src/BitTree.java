import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Node;

public class BitTree {

    /**
     * @author Sam Bigham
     *         Code for the Bit Tree
     */

    /**
     * The size of the tree.
     */
    int size;

    /**
     * how many elements are in the tree
     */
    int length;

    /**
     * The root of our tree. Initialized to null for an empty tree.
     */
    BitTreeNode root;

    public BitTree(int n) {
        this.size = n;

        this.root = new BitTreeNode(null);

        init(this.root, n);

    }

    void init(BitTreeNode curNode, int n) {

        BitTreeNode newLeftNode = new BitTreeNode(null);
        BitTreeNode newRightNode = new BitTreeNode(null);

        if (n == 0) {
            return;
        }

        curNode.left = newLeftNode;
        curNode.right = newRightNode;

        init(curNode.left, n - 1);
        init(curNode.right, n - 1);

    }

    public void set(String bits, String value) throws Exception {

        // this.root = new BitTreeNode(2);
        set(bits, value, this.root);
    }

    void set(String bits, String value, BitTreeNode node) throws Exception {
        // System.out.println("bits is : " + bits);
        BitTreeNode curNode = node;
        if (!areNumbers(bits)) {
            throw new Exception("string doesn't only have numbers");
        }
        if (bits.length() == 1) {
            if (bits.charAt(0) == '1') {
                curNode.left = new BitTreeNode(value);
                curNode.left.value = value;
            } else {
                curNode.right = new BitTreeNode(value);
            }
            this.length++;
            return;
        }

        if (bits.length() == 0) {// null case
            System.out.println("bits length = 0 possible error expected");
        }

        if (bits.charAt(0) == '1') {
            // System.out.println("going left " + bits.substring(1));
            set(bits.substring(1), value, curNode.left);
        } else {
            // System.out.println("going right " + bits.substring(1));
            // System.out.println(bits.substring(1));
            // System.out.println(curNode.right.value);
            set(bits.substring(1), value, curNode.right);
        }
    }// set

    String get(String bits) throws Exception {
        if (bits.length() <= size) {
            throw new Exception("bits is too small");
        } else if (bits.length() > size + 1) {
            throw new Exception("bits is too big");
        }
        String str = get(bits, this.root);

        return str;
    }

    String get(String bits, BitTreeNode node) throws Exception {
        BitTreeNode curNode = node;
        String str;

        if (bits.length() <= 1) {
            // System.out.println("at end of tree");

            if (bits.charAt(0) == '1') {
                if (curNode.left == null) {
                    throw new Exception("curNode.left is null");
                }
                str = String.valueOf(curNode.left.value);
            } else {
                if (curNode.right == null) {
                    throw new Exception("curNode.right is null");
                }
                str = String.valueOf(curNode.right.value);
            }
            return str;
        } // if

        if (bits.charAt(0) == '1') {
            // System.out.println("going left " + bits.substring(1));
            str = get(bits.substring(1), curNode.left);
        } else {
            // System.out.println("going right " + bits.substring(1));
            str = get(bits.substring(1), curNode.right);
        }

        return str;
    }// get

    /*
     * dumps out the tree by printing it
     */
    void dump(PrintWriter pen) {
        int[] progress = new int[this.size + 1];
        dump(pen, this.root, progress, 0);

        // pen.println(this.root.value);
    }

    void dump(PrintWriter pen, BitTreeNode node, int[] progress, int n) {
        BitTreeNode curNode = node;
        // if(progress.length > n) {
        // return;
        // }

        if (curNode.right != null && curNode.left != null) {

            progress[n] = 0;
            int i = n;
            dump(pen, curNode.right, progress, ++n);

            progress[i] = 1;
            dump(pen, curNode.left, progress, ++i);

            /**if statement is rather clunky and should be improved if I can figure out how
             * This is for the unique situation when we're at the end of the tree, but both values of the 
             * children are not null
            */
            if(curNode.right.right == null && 
            curNode.right.left == null &&
             curNode.left.left == null &&
             curNode.left.right == null && 
             curNode.left.value != null &&
             curNode.right.value != null) {
                progress[progress.length -1] = 0;
                pen.println(arrToString(progress) + "," + curNode.right.value);
                progress[progress.length -1] = 1;
                pen.println(arrToString(progress) + "," + curNode.left.value);
            }

        } else if (curNode.right != null || curNode.left != null) {
            if (curNode.right != null) {
                progress[n] = 0;
                n++;
                dump(pen, curNode.right, progress, n);
                 pen.println(arrToString(progress) + "," + curNode.right.value);
            }
            if (curNode.left != null) {
                progress[n] = 1;
                n++;
                dump(pen, curNode.left, progress, n);

                pen.println(arrToString(progress) + "," + curNode.left.value);
            }
        } 
    }// dump

    void load(BufferedReader source) throws IOException {

        String str;
        String[] strArr = new String[2];

        do {
            str = source.readLine();

            if (str != null) {
                if (str.length() > 1) {
                    strArr = str.split(",");
                    try {
                        // System.out.println("strArr[0] is : "+ strArr[0] + " strarr[1] is : " +
                        // strArr[1] );
                        this.set(strArr[0], strArr[1]);

                    } catch (Exception e) {
                        e.printStackTrace();
                    } // try...catch
                } // if
            } // if
        } while (str != null);

    }// load

    boolean areNumbers(String str) {

        if (str.length() == 0) {
            return true;
        } // if
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) {
                return false;
            } // if
        } // for
        return true;
    }// areNumbers

    static String arrToString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(Integer.valueOf(arr[i]));
        }
        return stringBuilder.toString();
    }

}// BitTree
