import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<? super T> > {

    private BinaryNode<T> root;

    public BinarySearchTree() {}

    // TODO: initialisation
    public BinarySearchTree(T item) {
        this.root = new BinaryNode<>(item);
    }

    // TODO: on insere un nouvel item a partir de la racine
    // O(log(n))
    public void insert(T item) {
        root.insert(item);
    }

    // TODO: est-ce qu'un item fais partie de l'arbre
    // O(log(n))
    public boolean contains(T item) {
        return this.root.contains(item);
    }

    // TODO: trouver la hauteur de l'arbre
    // O(n)
    public int getHeight() {
        return root.getHeight();
    }

    // TODO: placer dans une liste les items de l'arbre en ordre
    // O(n)
    public List<BinaryNode<T>> getItemsInOrder() {
        List<BinaryNode<T>> result= new ArrayList<>();
        if(root != null) root.fillListInOrder(result);
        return result;
    }

    // TODO: retourner la liste d'item en String selon le bon format
    // O(n)
    public String toStringInOrder() {
        List<T> values = new ArrayList<>();
        for(BinaryNode<T> node:getItemsInOrder()) values.add(node.getData());
        return values.toString();
    }
}