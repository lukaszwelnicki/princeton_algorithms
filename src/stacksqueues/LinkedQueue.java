package stacksqueues;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> first;
    private Node<T> last;

    @Override
    public void enqueue(T object) {
        Node<T> oldLast = last;
        last = new Node<>(object, null);
        if (isEmpty()) first = last;
        else oldLast.next = last;
    }

    @Override
    public T dequeue() {
        T result = null;
        if (!isEmpty()) {
            result = first.item;
            first = first.next;
        }
        if (isEmpty()) {
            last = null;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
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
