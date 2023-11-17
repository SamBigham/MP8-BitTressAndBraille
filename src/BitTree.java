import java.io.PrintWriter;
import java.util.List;

import org.w3c.dom.Node;

public class BitTree {

    /**
     * The size of the tree.
     */
    int size;

    /**
     * The root of our tree. Initialized to null for an empty tree.
     */
    BitTreeNode root;

    public BitTree(int n) {
        this.size = n;

        this.root = new BitTreeNode(0);

        init(n);

    }

    void init(int n) {
        // this.root = new BitTreeNode(2);
        init(this.root, n);
    }

    void init(BitTreeNode curNode, int n) {

        BitTreeNode newLeftNode = new BitTreeNode(0);
        BitTreeNode newRightNode = new BitTreeNode(1);

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

    /**
     * Dump a portion of the tree to some output location.
     */
    public void dump(PrintWriter pen) {
        dump(pen, root, "");
    } // dump(PrintWriter)

    void dump(PrintWriter pen, BitTreeNode node, String indent) {
        if (node == null) {
            pen.println(indent + "<>");
        } else {
            pen.println(" : " + node.value);
            if ((node.left != null) || (node.right != null)) {
                dump(pen, node.left, indent + " ");
                dump(pen, node.right, indent + "  ");
            } // if has children
        } // else
    } // dump

    void set(String bits, String value, BitTreeNode node) throws Exception {
        BitTreeNode curNode = node;

        if (!areNumbers(bits)) {
            throw new Exception("string doesn't only have numbers");
        }
        if (bits.length() == 0) {// null case
            // curNode.value = Integer.parseInt(value);
            curNode.value = 4;
        }
        if (curNode.left == null && curNode.right == null) {
            curNode.value = 4;
            return;
        }

        System.out.println(bits.charAt(0));
        if (bits.charAt(0) == 1) {
            System.out.println("going left" + bits.charAt(0));
            set(bits.substring(1), value, curNode.left);
        } else {
            System.out.println("going right" + bits.charAt(0));
            set(bits.substring(1), value, curNode.left);
        }

        // if (bits.charAt(0) == 0) {// goes right
        // set(bits.substring(1), value, curNode.right);
        // }
        // else if (bits.charAt(0) == 1) {//goes left
        // set(bits.substring(1), value, curNode.left);
        // }
        // need a recursive case... possibly two left right
    }

    boolean areNumbers(String str) {

        if (str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) {
                return false;
            }
        }
        return true;
    }

}
