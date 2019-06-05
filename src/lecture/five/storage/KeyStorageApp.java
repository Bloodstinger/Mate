package lecture.five.storage;

import java.util.Arrays;

public class KeyStorageApp<K, V> {
    private static final int CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int index = 0;

    private KeyStorageApp() {
        try {
            this.keys = (K[]) new Object[CAPACITY];
            this.values = (V[]) new Object[CAPACITY];
        } catch (ClassCastException e) {
            System.out.println("Неверный формат ключа.");
        }
        }

        public void put (K key, V value){
            if (index == getCapacity(keys)) {
                increaseSize(getCapacity(keys));
            }
            this.keys[index] = key;
            this.values[index] = value;
            index++;
        }

        private int getCapacity (K[]keys){
            return keys.length;
        }

        private void increaseSize ( int oldSize){
            int oldCapacity = getCapacity(keys);
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            keys = Arrays.copyOf(keys, newCapacity);
            values = Arrays.copyOf(values, newCapacity);
        }

        private K[] getKeys () {
            return keys;
        }

        private V[] getValues () {
            return values;
        }

        public V get (K key){
            V value = null;
            for (int i = 0; i < getKeys().length; i++) {
                if (getKeys()[i] == key) {
                    value = getValues()[i];
                }
            }
            return value;
        }

        public static void main (String[]args){
            KeyStorageApp<Integer, String> storage = new KeyStorageApp<>();
            storage.put(5, "Five");
            storage.put(3, "Three");
            System.out.println(storage.get(5));
            System.out.println(storage.get(3));
        }

    }
