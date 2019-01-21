package tree.binary.search;

import javax.swing.JApplet;

public class BinaryTreeDisplay extends JApplet {

    private static final long serialVersionUID = 5329743141395531185L;

    public BinaryTreeDisplay() {
        Integer[] numbers = {5, 3, 7, 2, 4, 6, 7, 8};
        BinaryTree<Integer> intTree = new BinaryTree<>(numbers);
        System.out.println("树大小为：" + intTree.size + "，高度为：" + intTree.height());
        add(new BinaryTreeControl(intTree));
    }

}
