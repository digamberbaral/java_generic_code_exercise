package java_generic_code_exercise.data_structures.trees;

class Node{
    int key;
    Node left;
    Node right;

    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    Node root;
    int size;

    BinaryTree(){
        this.root = null;
        this.size = 0;
    }
    public void insert(int key){
        root = insertRec(root, key);
    }
    private Node insertRec(Node root, int key){
        if(root == null){
            root = new Node(key);
            size++;

            return root;
        }
        if(key < root.key){
            root.left = insertRec(root.left, key);
        } else if(key > root.key){
            root.right = insertRec(root.right, key);
        }
        size++;
        return root;
    }
    public void inOrder(){
        inOrderRec(root);
    }
    public void preOrder(){
        preOrderRec(root);
    }
    public void postOrder(){
        postOrderRec(root);
    }
    public boolean search(int key){
        return searchRec(root, key);
    }
    public int findMin(){
        return findMinRec(root);
    }
    private int findMinRec(Node root){
        if(root.left == null){
            return root.key;
        }
        return findMinRec(root.left);
    }
    private boolean searchRec(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.key == key){
            return true;
        }
        return (key < root.key) ? searchRec(root.left, key) : searchRec(root.right, key);
    }
    public int height(){
        return heightRec(root);
    }
    public int size(){
        return size;
    }
    private int heightRec(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(heightRec(root.left), heightRec(root.right)) + 1;
    }

    private void inOrderRec(Node root){
        if(root != null){
            inOrderRec(root.left);
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }
    private void preOrderRec(Node root){
        if(root != null){
            System.out.println(root.key);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }
    private void postOrderRec(Node root){
        if(root != null){
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.println(root.key);
        }
    }


    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(20);
        bt.insert(30);
        bt.insert(40);
        bt.insert(50);
        bt.insert(60);
        bt.insert(70);
        bt.insert(80);
        bt.insert(90);
        bt.inOrder();
        System.out.println();
        bt.preOrder();
        System.out.println();
        bt.postOrder();
        System.out.println();
        System.out.println("Size: " + bt.size);
        System.out.println("Height: " + bt.height());
        System.out.println("Search for 50: " + bt.search(50));
    }
}
