package ru.mail.littlerock2877.stepik.bruteForce;

import java.util.Scanner;

public class DirectProductSet {
    /*Задача С. Прямое произведение множеств
    Определите количество чисел в десятичной системе счисления из n цифр, сумма цифр которых делится на 5, а чётные и нечётные цифры чередуются.

    Формат входных данных
    В первой строке вводится число n - количество цифр в числе, 2≤n≤7.

    Формат выходных данных
    Выведите одно число - количество чисел с указанными свойствами.

    Замечание
    Достаточно реализовать алгоритм полного перебора с асимтотической сложностью O(10^n). Также отметим, что числа не начинаются с нуля, поэтому эти случаи необходимо исключить.

    Sample Input 1:
    2
    Sample Output 1:
    9
    Sample Input 2:
    3
    Sample Output 2:
    45 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int sum = 0;
        int count = 0;
        int num;
        int current;
        int prev;
        for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
            prev = -1;
            current = i;
            while(current > 0) {
                num = current % 10;
                if (prev != -1 && (num - prev) % 2 == 0) {
                    sum = -1;
                    break;
                }
                prev = num;
                sum += num;
                current /= 10;
            }
            if (sum % 5 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
