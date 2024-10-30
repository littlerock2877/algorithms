package ru.mail.littlerock2877.stepik.search;

import java.util.Scanner;

public class LeastPositive {
    /* Задача A. Наименьший положительный
    Выведите значение наименьшего из всех положительных элементов в списке. Известно, что в списке есть хотя бы один положительный элемент, а значения всех элементов списка по модулю не превосходят 1000.

    Формат входных данных
    Вводится список чисел. Все числа списка находятся на одной строке.

    Формат выходных данных
    Выведите ответ на задачу.

    Замечание
    Для удобства считывания данных на других языках программирования в первую строку было добавлено количество элементов в списке. Пустые списки не приходят.

    Sample Input 1:
            5
            5 -4 3 -2 1
    Sample Output 1:
            1
    Sample Input 2:
            6
            40 -20 10 5 0 2
    Sample Output 2:
            2 */

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int result = 1000;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
                if (arr[i] < result && arr[i] > 0) {
                    result = arr[i];
                }
            }
            System.out.println(result);
    }

}
