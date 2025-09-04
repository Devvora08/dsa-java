import java.util.Scanner;

public class BinaryTrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Binary tree = new Binary();
        tree.populate(scanner);
        tree.pretty();
    }
}

class Binary {
    public Binary() {

    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int val) {
            this.value = val;
        }
    }

    private Node root;

    // insert elements
    public void populate(Scanner scanner) {
        System.out.println("Enter the root");
        int value = scanner.nextInt();
        root = new Node(value);
        populateTree(scanner, root);
    }

    private void populateTree(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of : "+ node.value);
        boolean left = scanner.nextBoolean();
        if(left) {
            System.out.println("Enter the value of left of : "+node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populateTree(scanner, node.left);
        } 

        System.out.println("Do you want to enter right of : "+ node.value);
        boolean right = scanner.nextBoolean();
        if(right) {
            System.out.println("Enter the value of right of : "+node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populateTree(scanner, node.right);
        } 
    }

    // display the tree
    // public void display() {
    //     displayTree(root, "");
    // }

    // private void displayTree(Node node, String indent) {
    //     if(node == null) {
    //         return;
    //     }
    //     System.out.println(indent + node.value);
    //     displayTree(node.left, indent + "\t");
    //     displayTree(node.right, indent + "\t");
    // }

    public void pretty() { // this is abstraction, hiding the complex display method inside a void function
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if(node == null) return;

        prettyDisplay(node.right, level+1);
        if(level != 0) {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->"+node.value);
        } else{
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level+1);
    }
}
