package ru.mail.littlerock2877.search;

import java.util.Scanner;

public class CountOfNegatives {
    /*Задача C. Количество отрицательных в отсортированной матрице
    Дана матрица, элементы строк которой отсортированы по невозрастанию как по строкам, так и по столбцам. Найти количество отрицательных элементов в ней.

    Формат входных данных
    В первой строке вводятся числа n и m – количество строк и столбцов матрицы соответственно. Далее вводится сама матрица по строкам.

    Формат выходных данных
    Выведите одно число – количество отрицательных элементов в матрице.

    Sample Input 1:
            4 4
            4 3 2 -1
            3 2 1 -1
            1 1 -1 -2
            -1 -1 -2 -3
    Sample Output 1:
            8
    Sample Input 2:
            2 3
            3 2 1
            2 1 0
    Sample Output 2:
            0 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int result = 0;
        int lbs;
        for (int i = 0; i < n; i++) {
            lbs = lbs(matrix[i]);
            result += matrix[i][lbs] < 0 ? m - lbs : 0;
        }
        System.out.println(result);
    }

    private static int lbs(int[] arr) {
        int left = -1;
        int right = arr.length - 1;
        int c;
        while (left + 1 != right) {
            c = (left + right) / 2;
            if (arr[c] > 0) {
                left = c;
            } else {
                right = c;
            }
        }
        return right;
    }
}
