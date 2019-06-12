package lecture.seven.array.list;

import java.util.Objects;

public class CustomArrayList<V> implements List<V> {
    private static final int STARTING_CAPACITY = 10;
    private static final int EMPTY_CAPACITY = 0;
    private static final Object[] EMPTY_ARRAY = {};
    private V value;
    private Object[] array;
    private int arraySize = array.length;

    public CustomArrayList() {
        this.array = new Object[STARTING_CAPACITY];
    }

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.array = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.array = EMPTY_ARRAY;
        } else {
            throw new NegativeArraySizeException();
        }
    }

    private int calculateCapacity(Object[] array, int checkedArray) {
        if (array == EMPTY_ARRAY) {
            return Math.max(STARTING_CAPACITY, checkedArray);
        }
        return checkedArray;
    }

    private void increaseCapacity(int capacity) {
        int oldCapacity = arraySize;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - capacity < 0) {
            newCapacity = oldCapacity;
        }
        System.arraycopy(array, 0, new Object[newCapacity], 0, oldCapacity);

    }

    private void ensureCapacity(int capacity) {
        if (capacity - arraySize > 0) {
            increaseCapacity(capacity);
        }
    }

    private void checkCapacity(int arraySize) {
        ensureCapacity(calculateCapacity(array, arraySize));
    }

    private void indexCheck(int index) {
        if (index > arraySize) {
            throw new ArrayAddingIndexException("Index is greater than array size!");
        } else if (index < 0) {
            throw new NegativeIndexException();
        }
    }

    private void removeElement(int index) {
        int objectsAfterRemoved = arraySize - index - 1;
        if (objectsAfterRemoved > 0) {
            System.arraycopy(array, index + 1, array, index, objectsAfterRemoved);
        }
        array[--arraySize] = null;
    }

    @Override
    public void add(V value) {
        checkCapacity(arraySize + 1);
        array[arraySize++] = value;
    }

    @Override
    public void add(V value, int index) {
        indexCheck(index);
        checkCapacity(arraySize + 1);
        System.arraycopy(array, index, array, index + 1, arraySize - index);
        array[index] = value;
        arraySize++;
    }

    @Override
    public void addAll(List<V> list) {
        int length = list.size();
        increaseCapacity(length + arraySize);
        System.arraycopy(list, 0, array, arraySize, length);
        arraySize += length;
    }

    @Override
    public V get(int index) {
        indexCheck(index);
        return (V) array[index];
    }

    @Override
    public void set(V value, int index) {
        indexCheck(index);
        array[index] = value;
    }


    @Override
    public V remove(int index) {
        indexCheck(index);
        V oldValue = (V) array[index];
        removeElement(index);
        return oldValue;
    }

    @Override
    public V remove(V v) {
        for (int index = 0; index < arraySize; index++) {
            if (v.equals(array[index]) || Objects.isNull(v)) {
                removeElement(index);
                return (V) array[index];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return arraySize;
    }

    @Override
    public boolean isEmpty() {
        return arraySize == 0;
    }
}
