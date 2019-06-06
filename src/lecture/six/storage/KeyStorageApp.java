package lecture.six.storage;

public class KeyStorageApp {
    public static void main(String[] args) {
        KeyStorage<Integer, String> storage = new KeyStorage<>();
        storage.put(5, "Five");
        storage.put(3, "Three");
        System.out.println(storage.get(5));
        System.out.println(storage.get(3));
    }
}
