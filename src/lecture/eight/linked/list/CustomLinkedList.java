package lecture.eight.linked.list;

import lecture.seven.array.list.NegativeIndexException;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomLinkedList<T> implements List<T> {
    private int listSize;
    private Node<T> first;
    private Node<T> last;

    public CustomLinkedList() {
    }

    public CustomLinkedList(List<T> list) {
        this();
        addAll(list);
    }

    private static class Node<T> {
        private T item;
        private Node<T> prev;
        private Node<T> next;

        Node(Node<T> prev, T object, Node<T> next) {
            this.item = object;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> getNode(int index) {
        if (index < (listSize >> 1)) {
            Node<T> item = first;
            for (int i = 0; i < index; i++) {
                item = item.next;
            }
            return item;
        } else {
            Node<T> item = last;
            for (int i = listSize; i > index; i--) {
                item = item.prev;
            }
            return item;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[listSize];
        int i = 0;
        for (Node<T> node = first; node != null; node = node.next) {
            result[i++] = node.item;
        }
        return result;
    }

    @Override
    public void add(T value) {
        Node<T> lastNode = last;
        Node<T> newNode = new Node<>(lastNode, value, null);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
        listSize++;
    }

    @Override
    public void add(T value, int index) {
        checkIndex(index);
        if (index == listSize) {
            add(value);
        } else {
            linkBeforeNode(value, getNode(index));
        }
    }


    @Override
    public void addAll(List<T> list) {
        Object[] array = list.toArray();
        for (Object node : array) {
            add((T) node);
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).item;
    }

    @Override
    public void set(T value, int index) {
        checkIndex(index);
        Node<T> setNode = getNode(index);
        setNode.item = value;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        return unlinkNode(getNode(index));
    }

    @Override
    public T remove(T t) {
        Node<T> node = first;
        if (t == null) {
            while (node.item != null) {
                node = node.next;
            }
            unlinkNode(node);
        } else {
            while (node.item != t) {
                node = node.next;
            }
            unlinkNode(node);
        }
        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    private void checkIndex(int index) {
        if (index > listSize) {
            throw new IndexOutOfBoundsException();
        } else if (index < 0) {
            throw new NegativeIndexException();
        }
    }

    private void linkBeforeNode(T item, Node<T> nodeAfter) {
        Node<T> prev = nodeAfter.prev;
        Node<T> newNode = new Node<>(prev, item, nodeAfter);
        nodeAfter.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        listSize++;
    }

    private T unlinkNode(Node<T> node) {
        T item = node.item;
        Node<T> nextNode = node.next;
        Node<T> prevNode = node.prev;
        if (prevNode == null) {
            first = nextNode;
        } else {
            prevNode.next = nextNode;
            node.prev = null;
        }

        if (nextNode == null) {
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
            node.next = null;
        }

        node.item = null;
        listSize--;
        return item;
    }

}
