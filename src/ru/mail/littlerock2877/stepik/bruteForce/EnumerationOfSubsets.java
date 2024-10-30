package ru.mail.littlerock2877.stepik.bruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnumerationOfSubsets {
    /*Задача B. Перебор подмножеств с условием
    Определите количество непустых подмножеств данного множества, сумма элементов которых делится на 7, а количество четных элементов делится на 3. Значения элементов могут повторяться.
    Подмножеством данного множества является любой набор элементов данного множества.

    Формат входных данных
    В первой строке вводится число n - количество элементов, 1≤n≤20. В следующем строке вводятся числа через пробел.

    Формат выходных данных
    Выведите одно число - количество непустых подмножеств данного множества с указанными условиями.

    Замечание
    Достаточно реализовать алгоритм полного перебора с асимтотической сложностью O(2 ^ n). Также отметим, что 0 делится на любое число, поэтому сумма и количество, равное нулю подходит под условие.

    Sample Input 1:
    3
    28 28 28
    Sample Output 1:
    1
    Sample Input 2:
    5
    -41 19 47 -5 -97
    Sample Output 2:
    5 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        long count = 0;
        int sum;
        int evenCount;
        for (int mask = 1; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(arr[i]);
                }
            }

            sum = subset.stream().mapToInt(x -> x).sum();
            evenCount = (int) subset.stream().filter(x -> x % 2 == 0).count();
            if (sum % 7 == 0 && evenCount % 3 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
