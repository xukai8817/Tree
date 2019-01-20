package tree.binary.search;

import java.util.Iterator;

public class TestBinaryTree {

    public static void main(String[] args) {
        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
        BinaryTree<Integer> intTree = new BinaryTree<>(numbers);
        intTree.inOrder();
        System.out.println();
        System.out.println(intTree.path(2));
        System.out.println(intTree.root);

        intTree.breadthFirstTraversal();
        System.out.println(intTree.height());
        System.out.println(intTree.isFullBinaryTree());

        for (Iterator iterator = intTree.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }

}
