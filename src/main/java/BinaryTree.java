/* OpenAI. (2026). ChatGPT (modelo GPT-5.3). Respuesta generada a partir del prompt: “Implement a generic Binary Search Tree in Java with insert, search, and in-order traversal methods using Comparable.” https://chat.openai.com/ */

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a Binary Search Tree for comparable elements.
 * The insertion and search idea follows the standard BST rule:
 * smaller elements go to the left and greater elements go to the right.
 *
 * @param <E> the element type stored in the tree
 */
public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    /**
     * Represents one node inside the binary tree.
     *
     * @param <E> the element type
     */
    private static class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        /**
         * Creates a new node.
         *
         * @param data the node data
         */
        private Node(E data) {
            this.data = data;
        }
    }

    /**
     * Inserts a value in the tree. If the value already exists, it replaces it.
     *
     * @param value the value to insert
     */
    public void insert(E value) {
        root = insertRecursive(root, value);
    }

    /**
     * Searches for a value in the tree.
     *
     * @param value the value to search
     * @return the stored value, or null if it was not found
     */
    public E search(E value) {
        return searchRecursive(root, value);
    }

    /**
     * Returns all elements ordered using in-order traversal.
     *
     * @return a list with the ordered elements
     */
    public List<E> inOrder() {
        List<E> result = new ArrayList<>();
        inOrderRecursive(root, result);
        return result;
    }

    private Node<E> insertRecursive(Node<E> current, E value) {
        if (current == null) {
            return new Node<>(value);
        }

        int comparison = value.compareTo(current.data);

        if (comparison < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (comparison > 0) {
            current.right = insertRecursive(current.right, value);
        } else {
            current.data = value;
        }

        return current;
    }

    private E searchRecursive(Node<E> current, E value) {
        if (current == null) {
            return null;
        }

        int comparison = value.compareTo(current.data);

        if (comparison == 0) {
            return current.data;
        } else if (comparison < 0) {
            return searchRecursive(current.left, value);
        } else {
            return searchRecursive(current.right, value);
        }
    }

    private void inOrderRecursive(Node<E> current, List<E> result) {
        if (current != null) {
            inOrderRecursive(current.left, result);
            result.add(current.data);
            inOrderRecursive(current.right, result);
        }
    }
}
