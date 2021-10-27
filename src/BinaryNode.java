import java.util.*;

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
        this.depth=-1;
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
        BinaryNode<T> currentNode = this;
        BinaryNode<T> previousNode = currentNode;
        while (currentNode != null) {
            previousNode = currentNode;
            if (item.compareTo(currentNode.data) <= 0) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }
        if(item.compareTo(previousNode.data) <= 0) previousNode.left = new BinaryNode<>(item);
        else previousNode.right = new BinaryNode<>(item);

    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
        BinaryNode<T> currentNode = this;
        while (currentNode != null) {
            int compare = item.compareTo(currentNode.data);
            if (compare < 0) currentNode = currentNode.left;
            if(compare > 0)currentNode = currentNode.right;
            else return true;
        }
        return false;
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {

        int depth =-1;
        int height =0;

        Stack<BinaryNode<T>> stack = new Stack<>();
        BinaryNode<T> currentNode = this;
        while(currentNode != null || stack.size()>0){

            while (currentNode != null){
                currentNode.depth = ++depth;
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            depth = currentNode.depth;
            if(depth>height) height = depth;

            currentNode = currentNode.right;
        }
        return height;

    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {

        Stack<BinaryNode<T>> stack = new Stack<>();
        BinaryNode<T> currentNode = this;
        while(currentNode != null || stack.size()>0){

            while (currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            result.add(currentNode);

            currentNode = currentNode.right;
        }
    }
}