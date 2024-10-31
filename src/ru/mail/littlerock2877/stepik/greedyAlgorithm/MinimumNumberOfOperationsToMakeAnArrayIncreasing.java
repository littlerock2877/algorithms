package ru.mail.littlerock2877.stepik.greedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberOfOperationsToMakeAnArrayIncreasing {
    /* Задача A. Минимальное количество операций, чтобы сделать массив возрастающим
    Вам дается целочисленный массив. За одно действие вы можете выбрать элемент массива и увеличить его на 1.
    Например, если массив состоит из элементов [1,2,3], вы можете увеличить элемент с его первым индексом, [1,3,3].

    Формат входных данных
    Массив вводится в одну строку. Массив изначально не является возрастающим.

    Формат выходных данных
    Верните минимальное количество операций, которое нужно сделать, чтобы массив стал строго возрастающим. Массив длины 1 также считается возрастающим.

    Sample Input 1:
    1 1 1
    Sample Output 1:
    3
    Sample Input 2:
    1 5 2 4 1
    Sample Output 2:
    14 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (ints.length == 1) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] <= ints[i - 1]) {
                count += ints[i - 1] - ints[i] + 1;
                ints[i] = ints[i - 1] + 1;
            }
        }
        System.out.println(count);
    }
}
