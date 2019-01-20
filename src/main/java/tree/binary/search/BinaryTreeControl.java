package tree.binary.search;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tree.binary.search.BinaryTree.TreeNode;

public class BinaryTreeControl extends JPanel {

    private static final long serialVersionUID = -3089035388076544312L;

    private BinaryTree<Integer> tree;

    private JTextField jtfKey = new JTextField(5);

    private TreeView view = new TreeView();

    private JButton jbtInsert = new JButton("插入");

    private JButton jbtDelete = new JButton("删除");

    public BinaryTreeControl(BinaryTree<Integer> tree) {
        this.tree = tree;
        setUI();
    }

    private void setUI() {
        this.setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.add(new JLabel("输入一个数字："));
        panel.add(jtfKey);
        panel.add(jbtInsert);
        panel.add(jbtDelete);
        add(panel, BorderLayout.SOUTH);

        jbtInsert.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int key = Integer.parseInt(jtfKey.getText());
                if (tree.search(key)) {
                    JOptionPane.showMessageDialog(null, key + "：已经存在");
                } else {
                    tree.insert(key);
                    view.repaint();
                }
            }
        });

        jbtDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int key = Integer.parseInt(jtfKey.getText());
                if (!tree.search(key)) {
                    JOptionPane.showMessageDialog(null, key + "：不存在");
                } else {
                    tree.delete(key);
                    view.repaint();
                    jtfKey.setText("");
                }
            }
        });

    }

    class TreeView extends JPanel {

        private static final long serialVersionUID = -3559958872832223130L;
        private int radius = 20;
        private int vGap = 50;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (tree.getRoot() != null) {
                displayTree(g, tree.getRoot(), getWidth() / 2, 30, getWidth() / 4);
            }
        }

        private void displayTree(Graphics g, TreeNode<Integer> root, int x, int y, int hGap) {
            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.drawString(root.element + "", x - 6, y + 4);

            if (root.left != null) {
                connectLeftChild(g, x - hGap, y + vGap, x, y);
                displayTree(g, root.left, x - hGap, y + vGap, hGap / 2);
            }

            if (root.right != null) {
                connectRightChild(g, x + hGap, y + vGap, x, y);
                displayTree(g, root.right, x + hGap, y + vGap, hGap / 2);
            }
        }

        private void connectLeftChild(Graphics g, int i, int j, int x, int y) {
            double d = Math.sqrt(vGap * vGap + (x - i) * (x - i));
            int x1 = (int) (i + radius * (x - i) / d);
            int y1 = (int) (j - radius * vGap / d);
            int x2 = (int) (x - radius * (x - i) / d);
            int y2 = (int) (y + radius * vGap / d);
            g.drawLine(x1, y1, x2, y2);
        }

        private void connectRightChild(Graphics g, int i, int j, int x, int y) {
            double d = Math.sqrt(vGap * vGap + (x - i) * (x - i));
            int x1 = (int) (i - radius * (i - x) / d);
            int y1 = (int) (j - radius * vGap / d);
            int x2 = (int) (x + radius * (i - x) / d);
            int y2 = (int) (y + radius * vGap / d);
            g.drawLine(x1, y1, x2, y2);
        }
    }

}
