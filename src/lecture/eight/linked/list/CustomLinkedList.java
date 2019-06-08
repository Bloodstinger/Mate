package lecture.eight.linked.list;

import lecture.seven.array.list.NegativeIndexException;

public class CustomLinkedList<T> implements List<T> {
    transient private int listSize;
    transient private Node<T> first;
    transient private Node<T> last;

    public CustomLinkedList() {
    }

    public CustomLinkedList(List<T> list) {
        this();
        addAll(list);
    }

    private static class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;

        Node(Node<T> prev, T object, Node<T> next) {
            this.item = object;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> node(int index) {
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

    private void checkIndex(int index) {
        if (index > listSize) {
            throw new IndexOutOfBoundsException();
        } else if (index < 0) {
            throw new NegativeIndexException();
        }
    }

    private void linkLast(T item) {
        final Node<T> lastNode = last;
        final Node<T> newNode = new Node<>(lastNode, item, null);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
        listSize++;
    }

    private void linkBefore(T item, Node<T> nodeAfter) {
        final Node<T> prev = nodeAfter.prev;
        final Node<T> newNode = new Node<>(prev, item, nodeAfter);
        nodeAfter.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        listSize++;
    }

    private T unlinkNode(Node<T> node) {
        final T item = node.item;
        final Node<T> nextNode = node.next;
        final Node<T> prevNode = node.prev;
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
        linkLast(value);
    }

    @Override
    public void add(T value, int index) {
        checkIndex(index);
        if (index == listSize) {
            linkLast(value);
        } else {
            linkBefore(value, node(index));
        }
    }


    @Override
    public void addAll(List<T> list) {
        Object[] listArray = list.toArray();
        int length = list.size();
        Node<T> prevNode;
        prevNode = last;

        for (Object node :
                listArray) {
            T item = (T) node;
            Node<T> newNode = new Node<>(prevNode, item, null);
            prevNode.next = newNode;
            prevNode = newNode;
        }
        last = prevNode;
        listSize += length;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return node(index).item;
    }

    @Override
    public void set(T value, int index) {
        checkIndex(index);
        Node<T> setNode = node(index);
        setNode.item = value;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        return unlinkNode(node(index));
    }

    @Override
    public T remove(T t) {
        if (t == null) {
            for (Node<T> tNode = first; tNode != null; tNode = tNode.next) {
                if (tNode.item == null) {
                    unlinkNode(tNode);
                }
            }
        } else {
            for (Node<T> tNode = first; tNode != null; tNode = tNode.next) {
                if (t.equals(tNode.item)) {
                    unlinkNode(tNode);
                }

            }
        }
        return null;
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

}
