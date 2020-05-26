package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private Node<K, V> root;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    public V get(K key) {
        Node<K, V> node = root;
        while (node != null) {
            if (key.compareTo(node.key) < 0) {
                node = node.left;
            } else if (key.compareTo(node.key) > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    public Iterable<K> iterator() {
        Queue<K> keys = new ArrayDeque<>();
        inorder(root, keys);
        return keys;
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (key == null) {
            return new Node<>(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = put(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    private void inorder(Node<K, V> node, Queue<K> keys) {
        if (node == null) {
            return;
        }
        inorder(node.left, keys);
        keys.add(node.key);
        inorder(node.right, keys);
    }

    private Node<K,V> delete(Node<K,V> node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            Node<K, V> temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        return node;
    }

    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    private Node<K, V> min(Node<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private static class Node<K extends Comparable<K>, V> {

        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
