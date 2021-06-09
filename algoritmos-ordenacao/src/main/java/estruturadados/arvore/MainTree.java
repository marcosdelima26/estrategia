package estruturadados.arvore;


/**
 * https://www.baeldung.com/java-binary-tree
 */
public class MainTree {

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);


        System.out.println(bt);

        System.out.println(bt.containsNode(9));

    }
}
