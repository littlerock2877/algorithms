package ru.mail.littlerock2877.stepik.binarySearchByAnswer;

import java.util.Scanner;

public class Copiers {
    /*Задача B. Ксероксы
    Перед вам стоит важная задача: сделать N копий договора для финансовой сделки. Одна версия договора уже напечатана.
    В вашем распоряжении имеются два ксерокса, один из которых копирует лист за x секунд, а другой - за y. Разрешается использовать как один ксерокс,
    так и оба одновременно. Можно копировать не только с оригинала, но и с копии. Выясните, какое минимальное время вам потребуется для копирования.

    Входные данные
    На вход программы поступают три натуральных числа N, x и y, разделенные пробелом.

    Выходные данные
    Выведите одно число - минимальное время в секундах, необходимое для получения N копий.

    Замечание
    Для решения задачи рекомендуется использование бин. поиска по ответу.

    Sample Input 1:
    4 1 1
    Sample Output 1:
    3
    Sample Input 2:
    5 1 2
    Sample Output 2:
    4*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();;
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (n == 1) {
            System.out.println(Math.min(x, y));
            return;
        }

        int l = - 1;
        int r = Math.min(x, y) * (n - 1);
        int c;
        while (l + 1 != r) {
            c = (l + r) / 2;
            if (c / x + c / y < n - 1) {
                l = c;
            } else {
                r = c;
            }
        }
        System.out.println(Math.min(x, y) + r);
    }
}
