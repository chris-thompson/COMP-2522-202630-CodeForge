package ca.bcit.comp2522.dataStructures.tree;

/**
 * TreeNode. Note this class is not public. If we wanted to make this a static inner class,
 * do we have to change anything inside this class or inside the Tree class?
 *
 * @author BCIT
 * @version 2026
 */
class TreeNode {

    private int data;
    private TreeNode leftNode;
    private TreeNode rightNode;

    /**
     * Constructs an object of type TreeNode.
     * @param nodeData the datum an int
     */
    TreeNode(final int nodeData) {
        data = nodeData;
        leftNode = null;
        rightNode = null;
    }

    /**
     * Inserts the argument into the Tree.
     *
     * @param insertValue an int
     */
    public void insert(final int insertValue) {
        if (insertValue < data) {
            if (leftNode == null) {
                leftNode = new TreeNode(insertValue);
            } else {
                leftNode.insert(insertValue);
            }
        } else if (insertValue > data) {
            if (rightNode == null) {
                rightNode = new TreeNode(insertValue);
            } else {
                rightNode.insert(insertValue);
            }
        }
    }

    /**
     * Returns the data.
     * @return data an int
     */
    public int getData() {
        return data;
    }

    /**
     * Sets the data.
     * @param data an int
     */
    public void setData(final int data) {
        this.data = data;
    }

    /**
     * Returns the left TreeNode.
     * @return leftNode a TreeNode
     */
    public TreeNode getLeftNode() {
        return leftNode;
    }

    /**
     * Sets the left TreeNode.
     * @param leftNode a TreeNode
     */
    public void setLeftNode(final TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    /**
     * Returns the right TreeNode.
     * @return rightNode a TreeNode
     */
    public TreeNode getRightNode() {
        return rightNode;
    }

    /**
     * Sets the right TreeNode.
     * @param rightNode a TreeNode
     */
    public void setRightNode(final TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}

/**
 * Tree demonstrates traversals.
 *
 * @author BCIT
 * @version 2026
 */
public class Tree {
    private TreeNode root;

    /**
     * Constructs an object of type Tree.
     */
    public Tree() {
        root = null;
    }

    /**
     * Inserts the argument into the Tree.
     *
     * @param insertValue an object
     */
    public void insertNode(final int insertValue) {
        if (root == null) {
            root = new TreeNode(insertValue);
        } else {
            root.insert(insertValue);
        }
    }

    /**
     * Conducts a preorder traversal of the Tree.
     */
    public void preorderTraversal() {
        preorderHelper(root);
    }

    private void preorderHelper(final TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.printf("%d ", node.getData());
        preorderHelper(node.getLeftNode());
        preorderHelper(node.getRightNode());
    }

    /**
     * Conducts an inorder traversal of the Tree.
     */
    public void inorderTraversal() {
        inorderHelper(root);
    }

    private void inorderHelper(final TreeNode node) {
        if (node == null) {
            return;
        }
        inorderHelper(node.getLeftNode());
        System.out.printf("%d ", node.getData());
        inorderHelper(node.getRightNode());
    }

    /**
     * Conducts a postorder traversal of the Tree.
     */
    public void postorderTraversal() {
        postorderHelper(root);
    }

    private void postorderHelper(final TreeNode node) {
        if (node == null) {
            return;
        }
        postorderHelper(node.getLeftNode());
        postorderHelper(node.getRightNode());
        System.out.printf("%d ", node.getData());
    }
}
