package hw5;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collection;

public class BinarySearchTree {

    private class Node{ 
        int data;
        int hd;
        Node right,left;
        public Node(int n, int hd){
            this.hd = hd;
            data = n;
            right = null;
            left = null;
        }
    }

    public Node root;
    public LinkedList<Integer> tempHD = new LinkedList<>();
    public int[] horizontalDistance; 
    public int[] topView;
    public int[] hdOfEach, lvlOrder;
    public int size = 0;

    public BinarySearchTree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int key){
        root = insert(root, key, 0);
        size++;
    }

    public Node insert(Node root, int key, int hd){
        if(root == null){
            root = new Node(key, hd);
        } else {
            if(key <= root.data){
                root.left = insert(root.left, key, hd - 1);
            } else {
                root.right = insert(root.right, key, hd + 1);
            }
        }
        return root;
    }

    public void inorder(){
        inorder(root);
    }

    public void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void topView() {

        findhd(root, 0);
        this.horizontalDistance = new int[this.tempHD.size()];
        for (int i = 0; i < this.horizontalDistance.length; i++) {
            this.horizontalDistance[i] = this.tempHD.get(i);
        }
        Arrays.sort(this.horizontalDistance);

        this.topView = new int[this.horizontalDistance.length];

        lvlOrder = new int[size];
        hdOfEach = new int[size];
        levelOrder(root);

        Arrays.fill(topView, Integer.MIN_VALUE); 
        for(int i = 0; i < size; i++){
            int key = lvlOrder[i];
            int keyhd = hdOfEach[i];
            int whereDoHeck = Arrays.binarySearch(horizontalDistance, keyhd);
            if(topView[whereDoHeck] == Integer.MIN_VALUE){
                topView[whereDoHeck] = key;
            }
        }

        for(int i = 0; i < topView.length -1; i++){
            System.out.print(topView[i] + " - ");
        }
        System.out.print(topView[topView.length-1]);
    }

    public void findhd(Node root, int hd){ 
        if(root == null){
            return;
        }
        if(!this.tempHD.contains(hd)){
            this.tempHD.add(hd);
        }
        findhd(root.left, hd-1);
        findhd(root.right, hd+1);
    }

    Queue<Node> queue = new LinkedList<>() ;
    public void levelOrder(Node root) {
        if (root == null)
            return;
        queue.clear();
        queue.add(root);
        queue.add(new Node(0, -1)); 
        int ctr = 1;
        while(!queue.isEmpty()){
            Node node = queue.remove();
            int tempCtr = queue.remove().data;
            int temphd = node.hd;
            lvlOrder[tempCtr] = node.data;
            hdOfEach[tempCtr] = temphd;
            if(node.left != null){
                queue.add(node.left);
                queue.add(new Node(ctr, -1)); 
                ctr++;
            }
            if(node.right != null){
                queue.add(node.right);
                queue.add(new Node(ctr, -1));
                ctr++;
            }
        }

    }

}
