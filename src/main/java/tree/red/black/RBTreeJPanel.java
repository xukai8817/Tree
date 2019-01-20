package tree.red.black;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RBTreeJPanel extends JPanel {

    private static final long serialVersionUID = -3089035388076544312L;

    private RBTree<Integer> tree;

    private JTextField jtfKey = new JTextField(5);

    private TreeView view;

    private JButton jbtInsert = new JButton("插入");

    private JButton jbtDelete = new JButton("删除");

    public RBTreeJPanel(TreeView view) {
        this.view = view;
        this.tree = view.getTree();
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
                Integer key = Integer.valueOf(jtfKey.getText());
                if (tree.search(key)) {
                    JOptionPane.showMessageDialog(null, key + "：已经存在");
                } else {
                    tree.insert(key);
                    view.repaint();
                    jtfKey.setText("");
                }
            }
        });

        jbtDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Integer key = Integer.valueOf(jtfKey.getText());
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

}
