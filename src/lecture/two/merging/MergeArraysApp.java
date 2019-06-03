package lecture.two.merging;

import java.util.Arrays;

public class MergeArraysApp {
    public static void main(String[] args) {
        int[] a1 = new int[]{0, 2, 2};
        int[] a2 = new int[]{1, 3};
        System.out.println(Arrays.toString(mergeArrays(a1, a2)));
    }

    private static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
        for (int k = 0, i = 0, j = 0; k < a3.length; k++) {
            if (i > a1.length - 1) {
                a3[k] = a2[j];
                j++;
            } else if (j > a2.length - 1) {
                a3[k] = a1[i];
                i++;
            } else if (a1[i] < a2[j]) {
                a3[k] = a1[i];
                i++;
            } else {
                a3[k] = a2[j];
                j++;
            }
        }

        return a3;
    }
}
