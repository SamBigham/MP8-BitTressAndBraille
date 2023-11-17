/**
 * Nodes in a binary search tree.
 */
class BitTreeNode {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The key.  May not be null.
   */
  //K key;

  /**
   * The associated value.
   */
  int value;

  /**
   * The left subtree.
   */
  BitTreeNode left;

  /**
   * The right subtree.
   */
  BitTreeNode right;



  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new node.
   */
  public BitTreeNode(int value) {
    //this.key = key;
    this.value = value;
    this.left = null;
    this.right = null;
  } // BitTreeNode(K,V)

} // class BitTreeNode<K,V>