package ru.mail.littlerock2877.stepik.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProfessorFights {
    /* Задача D. Бои профессоров
    Дана лекционная аудитория, в которой несколько профессоров хотят прочесть свои лекции. Для составления расписания профессора подали заявки, вида [si,fi)– время начала и конца лекции.
    Лекция считается открытым полуинтервалом, то есть какая-то лекция может начаться в момент окончания другой, без перерыва.
    Составьте расписание занятий так, чтобы выполнить максимальное количество заявок.

    Формат входных данных
    В первой строке вводится натуральное число N, не более 1000 – общее количество заявок. Затем вводится N строк с описаниями заявок - по два числа в каждом
    Гарантируется, что si < fi
    Время начала и окончания лекции – натуральное число, не превышает 1440.

    Формат выходных данных
    Выведите одно число – максимальное количество заявок, которые можно выполнить.

    Sample Input 1:
    1
    5 10
    Sample Output 1:
    1
    Sample Input 2:
    3
    1 5
    2 3
    3 5
    Sample Output 2:
    2 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] lections = new int[n][2];
        for (int i = 0; i < n; i++) {
            lections[i][0] = scanner.nextInt();
            lections[i][1] = scanner.nextInt();
        }

        lections = Arrays.stream(lections).sorted(Comparator.comparing(key -> key[1])).toArray(int[][]::new);

        int count = 1;
        int prev = lections[0][1];

        for (int i = 1; i < lections.length; i++) {
            if (lections[i][0] >= prev) {
                prev = lections[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
