package stacksqueues;

public class LinkedStack<T> implements Stack<T> {

    private Node<T> head = null;

    @Override
    public void push(T object) {
        Node<T> oldHead = head;
        head = new Node<>(object, oldHead);
    }

    @Override
    public T pop() {
        T result = head.getItem();
        head = head.getNext();
        return result;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<S> {
        private S item;
        private Node<S> next;

        Node(S item, Node<S> next) {
            this.item = item;
            this.next = next;
        }

        public S getItem() {
            return item;
        }

        public void setItem(S item) {
            this.item = item;
        }

        public Node<S> getNext() {
            return next;
        }

        public void setNext(Node<S> next) {
            this.next = next;
        }
    }

}

