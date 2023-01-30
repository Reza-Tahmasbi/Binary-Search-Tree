package binarytree.namespace;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import static binarytree.namespace.PanelInsertTree.comboBox1;
import static binarytree.namespace.DrawTree.drawTreeButton;
import static binarytree.namespace.Main.*;

public class BinaryTree {
    // PROPERTIES
    private static int nameGenerator = 1;
    private Node_kuchulu treeRoot;
    public int nodeAmount = 0;
    private final String name;

    public String getName() {
        return name;
    }

    public Node_kuchulu getTreeRoot() {
        return treeRoot;
    }

    // CONSTRUCTOR
    public BinaryTree(Node_kuchulu node) {
        nodeAmount++;
        treeRoot = node;
        name = "Tree Number" + nameGenerator;
        nameGenerator++;
        comboBox1.getItems().add(name);
    }

    // GET TREE FROM COMBO-BOX AND RETURN THE ROOT
    public static Node_kuchulu getTreeRootFromComboBox() {
        Node_kuchulu currentRoot = null;
        if (comboBox1.getValue() == null)
            textArea.setText("Select a tree");
        else {
            for (BinaryTree item : binaryTreeArrayList) {
                if (comboBox1.getValue().equals(item.getName()))
                    currentRoot = item.getTreeRoot();
            }
        }
        return currentRoot;
    }

    // RETURN TREE FROM COMBO BOX
    public static BinaryTree getTreeFromComboBox() {
        BinaryTree currentTree = null;
        if (comboBox1.getValue() == null)
            textArea.setText("Select a tree");
        else {
            for (BinaryTree item : binaryTreeArrayList) {
                if (comboBox1.getValue().equals(item.getName()))
                    currentTree = item;
            }
        }
        return currentTree;
    }

    // INSERT NEW NODE
    public static void insertNode(Node_kuchulu treeRoot, int data) {
        Node_kuchulu temp = treeRoot;
        Node_kuchulu temp2 = null;
        while (temp != null) {
            temp2 = temp;
            if (temp.data == data) {
                break;
            }
            if (temp.data > data)
                temp = temp.left;
            else
                temp = temp.right;
        }
        assert temp2 != null;
        if (temp2.data > data) {
            getTreeFromComboBox().nodeAmount++;
            temp2.left = new Node_kuchulu(data, getTreeFromComboBox().nodeAmount - 1);
            textArea.setText("Node added successfully");
        } else if (temp2.data < data) {
            getTreeFromComboBox().nodeAmount++;
            temp2.right = new Node_kuchulu(data, getTreeFromComboBox().nodeAmount - 1);
            textArea.setText("Node added successfully");
        } else
            textArea.setText("Node with this value is already there");
    }

    // FIND HEIGHT
    public static int getTreeHeight(Node_kuchulu node) {
        if (node == null)
            return 0;
        int lDepth = getTreeHeight(node.left);
        int rDepth = getTreeHeight(node.right);
        if (lDepth > rDepth)
            return (lDepth + 1);
        else
            return (rDepth + 1);
    }

    // RETURNS LEAVES AMOUNT
    public static int getLeavesAmount(Node_kuchulu temp) {
        if (temp == null)
            return 0;
        if (temp.left == null && temp.right == null)
            return 1;
        else
            return getLeavesAmount(temp.left) + getLeavesAmount(temp.right);
    }

    // MAX VALUE
    public static int findMax(Node_kuchulu node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int res = node.data;
        int lRes = findMax(node.left);
        int rRes = findMax(node.right);
        if (lRes > res)
            res = lRes;
        if (rRes > res)
            res = rRes;
        return res;
    }

    // MIN VALUE
    public static int findMin(Node_kuchulu node) {
        if (node == null)
            return Integer.MAX_VALUE;
        int res = node.data;
        int lRes = findMin(node.left);
        int rRes = findMin(node.right);
        if (lRes < res)
            res = lRes;
        if (rRes < res)
            res = rRes;
        return res;
    }

    // TRAVERSING ALGORITHMS
    // INORDER TRAVERSAL
    public static void inorder(Node_kuchulu temp) {
        if (temp == null)
            return;
        inorder(temp.left);
        globString += (temp.data + " ");
        inorder(temp.right);
    }

    // POST-ORDER TRAVERSAL
    public static void postOrder(Node_kuchulu temp) {
        if (temp == null)
            return;
        postOrder(temp.left);
        postOrder(temp.right);
        globString += (temp.data + " ");

    }

    // PRE-ORDER TRAVERSAL
    public static void preOrder(Node_kuchulu temp) {
        if (temp == null)
            return;
        globString += (temp.data + " ");
        preOrder(temp.left);
        preOrder(temp.right);

    }

    // LEVEL-ORDER TRAVERSAL
    public static void levelOrder(Node_kuchulu temp) {
        Queue<Node_kuchulu> queue = new LinkedList<Node_kuchulu>();
        queue.add(temp);
        while (!queue.isEmpty()) {
            Node_kuchulu tempNode = queue.poll();
            globString += (tempNode.data + " ");
            if (tempNode.left != null) queue.add(tempNode.left);
            if (tempNode.right != null) queue.add(tempNode.right);
        }
    }

    // CHECKS WEATHER THE TREE IS COMPLETE OR NOT
    public static boolean isCompleteBST(Node_kuchulu temp) {
        Queue<Node_kuchulu> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(temp);
        while (!queue.isEmpty()) {
            Node_kuchulu temp_node = queue.remove();
            if (temp_node.left != null) {
                if (flag)
                    return false;
                queue.add(temp_node.left);
            } else
                flag = true;

            if (temp_node.right != null) {
                if (flag)
                    return false;
                queue.add(temp_node.right);

            } else
                flag = true;
        }
        return true;
    }

    public String burnTheTree() {
        if (treeRoot == null)
            return "No leaf to burn";
        else {
            treeRoot = null;
            return "Tree is burned";
        }
    }

    // SEARCHING ALGORITHM
    public static String searchBST(Node_kuchulu temp, int data) {
        if (temp == null) {
            return "Not found";
        }
        if (temp.data == data) {
            drawTreeButton.fire();
            return "Founded ";
        }
        if (temp.data < data)
            return searchBST(temp.right, data);
        return searchBST(temp.left, data);
    }

    // CHECKS IF TREE IS FULL
    public static boolean isFullTree(Node_kuchulu temp) {
        if (temp == null)
            return true;
        Queue<Node_kuchulu> q = new ArrayDeque<>();
        q.add(temp);
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            // null indicates - not a full BT
            if (temp == null)
                return false;
            // if it's not a leaf-node then the current node
            // should contain both left and right pointers.
            try {
                if (!(temp.left == null && temp.right == null)) {
                    q.add(temp.left);
                    q.add(temp.right);
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    // CHECKS IF TWO TREES ARE IDENTICAL // problem with identical tree1 is null -> SOLVED WITH TRY CATCH :) YEA I KNOW, IT'S NOT COOL!
    public static int isIdentical(Node_kuchulu tree1, Node_kuchulu tree2) {
        globString = "";
        preOrder(tree1);
        String temp1 = globString;
        globString = "";
        preOrder(tree2);
        String temp2 = globString;
        if (temp2.equals(temp1))
            return 1;
        else
            return 2;
    }

}


