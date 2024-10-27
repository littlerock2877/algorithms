package ru.mail.littlerock2877.search;

import java.util.Arrays;
import java.util.Scanner;

public class ApproximateBinarySearch {
    /* Задача B. Приближенный двоичный поиск
    Реализуйте алгоритм приближенного бинарного поиска.

    Формат входных данных
    В первой строке входных данных содержатся числа N и K (0<N,K<100001). Во второй строке задаются N чисел первого массива, отсортированного по неубыванию,
    а в третьей строке – K чисел второго массива. Каждое число в обоих массивах по модулю не превосходит 2 * 10^9.

    Формат выходных данных
    Для каждого из K чисел выведите в отдельную строку число из первого массива, наиболее близкое к данному. Если таких несколько, выведите меньшее из них.

    Замечание
    Алгоритм рекомендуется реализовать с асимптотической сложностью O(KlogN).

    Sample Input 1:

    1 3 5 7 9
    2 4 8 1 6
    Sample Output 1:

    1
    3
    7
    1
    5
    5 5
    Sample Input 2:

    6 11
    1 1 4 4 8 120
    1 2 3 4 5 6 7 8 63 64 65
    Sample Output 2:

    1
    1
    4
    4
    4
    4
    8
    8
    8
    8
    120 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] first = new int[n];
        int[] second = new int[k];
        for (int i = 0; i < n; i++) {
            first[i] = scanner.nextInt();
        }
        for (int i = 0; i < k; i++) {
            second[i] = scanner.nextInt();
        }
        int curr;
        for (int i = 0; i < second.length; i++) {
            curr = second[i];
            second[i] = first[lbs(first, curr)] - curr < curr - first[rbs(first, curr)] ? first[lbs(first, curr)] : first[rbs(first, curr)];
        }
        Arrays.stream(second).forEach(System.out::println);
    }

    private static int lbs(int[] arr, int x) {
        int left = -1;
        int right = arr.length - 1;
        int c;
        while (left + 1 != right) {
            c = (left + right) / 2;
            if (arr[c] < x) {
                left = c;
            } else {
                right = c;
            }
        }
        return right;
    }

    private static int rbs(int[] arr, int x) {
        int left = 0;
        int right = arr.length;
        int c;
        while (left + 1 != right) {
            c = (left + right) / 2;
            if (arr[c] > x) {
                right = c;
            } else {
                left = c;
            }
        }
        return left;
    }
}
