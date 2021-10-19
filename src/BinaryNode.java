import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;
    private int depth;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data)
    {
        this.data = data;
        this.right = null;
        this.left = null;
        this.depth = 0;
    }

    // O(1)
    public BinaryNode(T data,int depth)
    {
        this(data);
        this.depth = depth;
    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData()
    {
        return this.data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item)
    {
       int compare = item.compareTo(this.data);
       if(compare<=0){
           if(this.left == null) this.left = new BinaryNode<T>(item,this.getDepth()+1);
           else this.left.insert(item);
       }
       else{
           if(this.right == null) this.right = new BinaryNode<T>(item,this.getDepth()+1);
           else this.right.insert(item);
       }
    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
        int compare = item.compareTo(this.data);
        if(compare==0) return true;
        else{
            if(compare<0 && this.left != null) return this.left.contains(item);
            if(this.right != null) return this.right.contains(item);
            return false;
        }
    }

    public int getDepth() {
        return depth;
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
        if(this.left == null && this.right ==null) return this.depth;
        else if(this.left == null) return this.right.getHeight();
        else if(this.right == null) return this.left.getHeight();
        return Math.max(this.left.getHeight(), this.right.getHeight());
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {

        if(this.left != null) this.left.fillListInOrder(result);
        result.add(this);
        if(this.right != null) this.right.fillListInOrder(result);
    }
}