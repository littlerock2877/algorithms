package ru.mail.littlerock2877.stepik.binarySearchByAnswer;

import java.util.Scanner;

public class ComplicatedLifeOfCows {
    /* Задача A. Сложная жизнь коров.
    На прямой расположены стойла, в которые необходимо расставить коров так, чтобы минимальное раcтояние между коровами было как можно больше.

    Формат входных данных
    В первой строке вводятся числа N (2<N<10001) – количество стойл и K (1<K<N) – количество коров. Во второй строке задаются N натуральных
    чисел в порядке возрастания – координаты стойл (координаты не превосходят 10^9)

    Формат выходных данных
    Выведите одно число – наибольшее возможное допустимое расстояние.

    Замечание
    Для решения задачи рекомендуется использование бин. поиска по ответу.

    Sample Input 1:
    6 3
    2 5 7 11 15 20
    Sample Output 1:
    9
    Sample Input 2:
    6 4
    1 3 7 100 1210 2015
    Sample Output 2:
    99 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] stalls = new int[n];
        for (int i = 0; i < stalls.length; i++) {
            stalls[i] = scanner.nextInt();
        }

        int l = 1;
        int r = stalls[stalls.length - 1] - stalls[0] + 1;
        int c;
        while (l + 1 != r) {
            c = (l + r) / 2;
            if (isCorrect(c, stalls, n, k)) {
                l = c;
            } else {
                r = c;
            }
        }
        System.out.println(l);
    }

    private static boolean isCorrect(int c, int[] stalls, int n, int k) {
        int prev = stalls[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (stalls[i] - prev >= c) {
                count++;
                prev = stalls[i];
            }
        }
        return count >= k;
    }
}
