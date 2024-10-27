package ru.mail.littlerock2877.bruteForce;

import java.util.Scanner;

public class ColumnsNeedToBeRemoved {
    /* Задача A. Сколько колонок нужно убрать
    С консоли подаются строки одинакового размера каждая в новой строке, образуя тем самым матрицу. Нужно определить, какое количество столбцов в образованной матрице будет находиться не в лексикографическом порядке.
    Лексикографический порядок - отношение линейного порядка на множестве слов над некоторым упорядоченным алфавитом (в нашем случае алфавит английский).

    Формат входных данных
    В первой строке вводится число n - количество строк. Далее вводятся сами строки длины m. Дополнительно отметим, что символы строк - это строчные буквы английского алфавита.

    Формат выходных данных
    Выведите одно число – количество столбцов, которые не отсортированы лексикографически.

    Sample Input 1:
    3
    cba
    daf
    ghi
    Sample Output 1:
    1
    Sample Input 2:
    2
    a
    b
    Sample Output 2:
    0 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }
        int length = arr[0].length();
        int result = 0;
        char prev;
        for (int i = 0; i < length; i++) {
            prev = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j].charAt(i) < prev) {
                    result++;
                    break;
                }
                prev = arr[j].charAt(i);
            }
        }
        System.out.println(result);
    }
}
