package ru.mail.littlerock2877.stepik.greedyAlgorithm;

import java.util.Scanner;

public class DriverKolya {
    /*Задача F. Водитель Коля
    Коля едет из пункта A в пункт B на автомобиле. Расстояние между этими пунктами равно N километров. Известно, что с полным баком автомобиль способен проехать
    k километров. Дана карта, на которой отмечены координаты бензоколонок, относительно пункта A. Определите минимальное число заправок,
    которые придется сделать Коле чтобы успешно достичь пункта B. Известно, что при выезде из пункта A бак был полон.

    Входные данные
    В первой строке вводятся числа N и k (натуральные, не превосходят 1000). В следующей строке вводится количество бензоколонок S, потом следует S натуральных чисел, не превосходящих
    N – расстояния от пункта A до каждой заправки. Заправки упорядочены по удаленности от пункта A.

    Выходные данные
    Если при данных условиях пунктаB достичь невозможно, то вывести число −1.Если решение существует, то вывести минимальное количество остановок на дозаправку,
    которое нужно чтобы достичь пункта B.

    Sample Input 1:
    100 20
    1 50
    Sample Output 1:
    -1
    Sample Input 2:
    100 50
    1 50
    Sample Output 2:
    1 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int s = scanner.nextInt();
        int[] arr = new int[s + 1];
        for (int i = 0; i < s; i++) {
            arr[i] = scanner.nextInt();
        }
        arr[s] = n;
        int count = 0;
        int prev = 0;
        int index = 0;
        for (int i = 1; i < s + 2; i++) {
            if (arr[i - 1] - prev > k && i - index == 1) {
                count = -1;
                break;
            } else if (arr[i - 1] - prev > k && i - index != 1) {
                count++;
                index = i - 1;
                prev += arr[i - 1];
            }
        }
        System.out.println(count);
    }
}
