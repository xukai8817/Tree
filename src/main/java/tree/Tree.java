package tree;

import java.util.Iterator;

public interface Tree<E extends Comparable<E>> {

    public boolean search(E e);
    
    public boolean insert(E e);
    
    public boolean delete(E e);

    /**
     * 先序遍历
     */
    public void inOrder();
    
    /**
     * 后序遍历
     */
    public void postOrder();
    
    /**
     * 前序遍历
     */
    public void preOrder();
    
    public int getSize();
    
    public boolean isEmpty();
    
    public Iterator<E> iterator();
    
}
