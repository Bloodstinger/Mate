package lecture.five.storage;



public class KeyStorageApp<K, V> {
    private K[] keys;
    private V[] values;
    private int index =0;

    private KeyStorageApp() {
        this.keys = (K[]) new Object[100];
        this.values = (V[]) new Object[100];
    }

    private K[] getKeys() {
        return keys;
    }

    private V[] getValues() {
        return values;
    }

    public KeyStorageApp(KeyStorageApp<K, V> keyStorage) {
        new KeyStorageApp<>();
        this.keys = keyStorage.getKeys();
        this.values = keyStorage.getValues();
    }

    public void put(K key, V value) {
        this.keys[index] = key;
        this.values[index] = value;
        index++;
    }

    public V get(K key) {
        V value = null;
        for (int i = 0; i < getKeys().length; i++) {
            if (getKeys()[i] == key) {
                value = getValues()[i];
            }
        }
        return value;
    }

    public static void main(String[] args) {
        KeyStorageApp<Integer, String> storage = new KeyStorageApp<>();
        storage.put(5, "Five");
        storage.put(3, "Three");
        System.out.println(storage.get(5));
        System.out.println(storage.get(3));
    }

}
