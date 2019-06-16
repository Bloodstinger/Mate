package lecture.ten.numberSequence;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        Integer container;
        Scanner scanner = new Scanner(System.in);
        ArrayDeque arrayDeque = new ArrayDeque();
        while (scanner.hasNextInt()) {
            container = scanner.nextInt();
            if (i % 2 != 0) {
                arrayDeque.add(container);
            }
            i++;
        }
        Iterator<Integer> iterator = arrayDeque.descendingIterator();
        while (iterator.hasNext()) {
            container = iterator.next();
            System.out.print(container.toString() + " ");
        }
    }
}
