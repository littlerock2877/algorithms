import search.Search;

public class Main {
    public static void main(String[] args) {
        search();
    }

    private static void search() {
        // Searching
        int[] a = { 1, 5, 19, 34, 34, 34, 72, 100, 115, 154 };
        int x = 34;
        // Linear search
        System.out.println("Linear search = " + Search.linearSearch(a, x));
        //Left binary search
        System.out.println("Left binary search = " + Search.leftBinarySearch(a, x));
        //Right binary search
        System.out.println("Right binary search = " + Search.rightBinarySearch(a, x));
    }
}