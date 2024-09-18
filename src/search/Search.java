package search;

public class Search {
    public static int linearSearch(int[] array, int target) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int leftBinarySearch(int[] array, int target) {
        int l = -1;
        int r = array.length - 1;
        int c;
        while (l + 1 != r) {
            c = (l + r) / 2;
            if (array[c] < target) {
                l = c;
            } else {
                r = c;
            }
        }
        return r;
    }

    public static int rightBinarySearch(int[] array, int target) {
        int l = 0;
        int r = array.length;
        int c;
        while (l + 1 != r) {
            c = (l + r) / 2;
            if (array[c] > target) {
                r = c;
            } else {
                l = c;
            }
        }
        return l;
    }
}
