class BitTreeNode {

    /**
     * @author Sam Bigham
     * Code for the BitTreeNodes
     */

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
  String value;

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
  public BitTreeNode(String value) {
    //this.key = key;
    this.value = value;
    this.left = null;
    this.right = null;
  } // BitTreeNode(K,V)

} // class BitTreeNode<K,V>