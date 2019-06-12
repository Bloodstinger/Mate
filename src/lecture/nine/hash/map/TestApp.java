package lecture.nine.hash.map;

public class TestApp {
    public static void main(String[] args) {
        CustomHashMap<Integer, String > customHashMap = new CustomHashMap();
        customHashMap.put(1, "One");
        customHashMap.put(2, "Two");
        customHashMap.put(3, "Three");
        customHashMap.put(4, "Four");
        customHashMap.put(5, "Five");
        customHashMap.put(6, "Six");
        customHashMap.put(7, "Seven");
        customHashMap.put(8, "Eight");
        customHashMap.put(9, "Nine");
        customHashMap.put(10, "Ten");
        customHashMap.put(11, "Eleven");
        customHashMap.put(12, "Twelve");
        customHashMap.put(13, "Thirteen");
        customHashMap.put(14, "Fourteen");
        customHashMap.put(15, "Fifteen");
        customHashMap.put(16, "Sixteen");
        customHashMap.put(17, "Seventeen");
        customHashMap.put(18, "Eighteen");
        customHashMap.put(19, "Nineteen");
        customHashMap.put(20, "Twenty");


        for (int i = 1; i < 500; i++) {
            int key = i;
            String value = "Key value is " + i;
            customHashMap.put(key, value);
        }

        System.out.println(customHashMap.getSize());
        System.out.println(customHashMap.get(20));
        System.out.println(customHashMap.get(370));
        System.out.println(customHashMap.get(13613));

    }
}
