package lecture.nine.hash.map;

import java.util.NoSuchElementException;

public class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final float LOAD_FACTOR = 0.75f;
    private Node<K, V>[] nodeTable;
    private int size;
    private int threshold;
    private float loadFactor;

    private static class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public boolean hasNext() {
            return this.next != null;
        }
    }


    private static int hash(Object key) {
        int hash = key.hashCode();
        if (key == null) {
            return 0;
        } else {
            return hash ^ (hash >>> 16);
        }
    }

    public CustomHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        } else if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException();
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        this.loadFactor = loadFactor;
    }

    public CustomHashMap() {
        this.loadFactor = LOAD_FACTOR;
    }

    public CustomHashMap(int initialCapacity) {
        this(initialCapacity, LOAD_FACTOR);
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> node = nodeTable[bucketNumber(hash(key), nodeTable.length)];
        if (node == null) {
            throw new NoSuchElementException("Value doesn't exist.");
        }
        while (!node.getKey().equals(key) && node.hasNext()) {
            node = node.next;
        }
        if (!node.getKey().equals(key)) {
            throw new NoSuchElementException("Wrong key");
        }
        return node;
    }

    private Node<K, V>[] resizeTable() {
        Node<K, V>[] oldTab = nodeTable;
        int oldCapacity = (oldTab == null) ? 0 : oldTab.length;
        int oldThreshold = threshold;
        int newCapacity;
        int newThreshold = 0;
        if (oldCapacity > 0) {
            newCapacity = oldCapacity << 1;
            if (newCapacity < MAXIMUM_CAPACITY && oldCapacity >= DEFAULT_CAPACITY) {
                newThreshold = oldThreshold << 1;
            }
        } else if (oldThreshold > 0) {
            newCapacity = oldThreshold;
        } else {
            newCapacity = DEFAULT_CAPACITY;
            newThreshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
        }
        threshold = newThreshold;
        @SuppressWarnings({"unchecked"})
        Node<K, V>[] newTab = (Node<K,V>[]) new Node[newCapacity];
        nodeTable = newTab;
        if (oldTab != null) {
            for (Node<K, V> node : oldTab) {
                if (node != null) {
                    put(node.getKey(), node.getValue());
                    if (node.hasNext()) {
                        Node<K,V> nodeToCopy = node;
                        while (node.hasNext()) {
                            nodeToCopy = node.next;
                            put(nodeToCopy.getKey(), nodeToCopy.getValue());
                        }
                    }
                }
            }
            size--;
        }
        return newTab;
    }

    private V putValue(int hash, K key, V value) {
        Node<K, V>[] nodeTab = nodeTable;
        Node<K, V> newNode = new Node<>(hash, key, value, null);
        if (nodeTab == null || nodeTab.length == 0) {
            nodeTab = new Node[DEFAULT_CAPACITY];
        }
        Node<K, V> oldNode = nodeTab[bucketNumber(hash, nodeTab.length)];
        int bucketNumber = bucketNumber(hash, nodeTab.length);
        if (nodeTab[bucketNumber] == null) {
            nodeTab[bucketNumber] = new Node<>(hash, key, value, null);
        } else if (oldNode.getKey() == key) {
            oldNode.value = value;
        } else {
            while (oldNode.hasNext()) {
                oldNode = oldNode.next;
            }
            oldNode.next = newNode;
        }
        size++;
        if (size > threshold-1) {
            resizeTable();
        }
        return value;
    }

    private int bucketNumber(int hashKey, int nodeTabLength) {
        return hashKey % (nodeTabLength - 1);
    }

    public V put(K key, V value) {
        putValue(hash(key), key, value);
        return value;
    }

    public V get(K key) {
        return getNode(key).value;
    }

    public int getSize() {
        return size;
    }

}
