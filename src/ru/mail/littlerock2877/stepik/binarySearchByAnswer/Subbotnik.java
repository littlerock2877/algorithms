package ru.mail.littlerock2877.stepik.binarySearchByAnswer;

import java.util.Arrays;
import java.util.Scanner;

public class Subbotnik {
    /* Задача C. Субботник
    В классе учатся N человек. Классный руководитель получил указание направить на субботник R бригад по C человек в каждой.

    Все бригады на субботнике будут заниматься переноской бревен. Каждое бревно одновременно несут все члены одной бригады.
    При этом бревно нести тем удобнее, чем менее различается рост членов этой бригады.

    Числом неудобства бригады будем называть разность между ростом самого высокого и ростом самого низкого членов этой бригады (если в бригаде только один человек,
    то эта разница равна 0). Классный руководитель решил сформировать бригады так, чтобы максимальное из чисел неудобства сформированных бригад было минимально.

    Входные данные
    Сначала вводятся натуральные числа N R и C - количество человек в классе, количество бригад и количество человек в каждой бригаде (1≤ R⋅C ≤ N ≤100 000). Далее вводятся
    N целых чисел - рост каждого из N учеников. Рост ученика -  натуральное число, не превышающее 1 000 000 000.

    Выходные данные
    Выведите одно число - наименьше возможное значение максимального числа неудобства сформированных бригад.

    Замечание
    Рассмотрим следующий пример. Пусть в классе 8 человек, рост которых в сантиметрах равен 170,205,225,190,260,130,225,160
    и необходимо сформировать две бригады по три человека в каждой. Тогда одним из вариантов является такой:
    1 бригада: люди с ростом 225,205,225
    2 бригада: люди с ростом 160,190,170
    При этом число неудобства первой бригады будет равно 20, а число неудобства второй - 30. Максимальное из чисел неудобств будет 30, и это будет наилучший возможный результат.

    Sample Input 1:
    8 2 3
    170
    205
    225
    190
    260
    130
    225
    160
    Sample Output 1:
    30
    Sample Input 2:
    1 1 1
    12436434
    Sample Output 2:
    0 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = scanner.nextInt();
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }
        Arrays.sort(students);
        int left = -1;
        int right = students[students.length - 1] - students[0];
        int center;
        while (left + 1 != right) {
            center = (left + right) / 2;
            if (isCorrect(center, students, r, c)) {
                right = center;
            } else {
                left = center;
            }
        }
        System.out.println(right);
    }

    private static boolean isCorrect(int center, int[] students, int r, int c) {
        int count = 0;
        for (int i = 0; i < students.length - c + 1; i++) {
            if (students[i + c - 1] - students[i] <= center) {
                count++;
                i += c - 1;
            }
            if (count == r) {
                return true;
            }
        }
        return false;
    }
}
