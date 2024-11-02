package ru.mail.littlerock2877.stepik.greedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SOS {
    /* Задача E. SOS
    Вам дается массив людей, где каждый элемент массива - это масса человека. Также в вашем распоряжение бесконечное количество лодок,
    где каждая лодка обладает некоторой максимальной грузоподъемностью. Каждая лодка перевозит не более двух человек одновременно,
    при условии, что сумма веса этих людей не превышает грузоподъемности.

    Формат входных данных
    В первой строке подается массив масс людей. Во второй строке подается максимальная грузоподъемность каждой лодки.

    Формат выходных данных
    Верните минимальное количество лодок для перевозки всех человек.

    Sample Input 1:
    1 2
    3
    Sample Output 1:
    1
    Sample Input 2:
    3 2 2 1
    3
    Sample Output 2:
    3 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        int[] weights = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).filter(x -> x <= n).sorted().toArray();

        int count = 0;
        int l = 0;
        int r = weights.length - 1;
        while (l < r) {
            if (weights[l] + weights[r] <= n) {
                l++;
                r--;
                count++;
            }
            else {
                count++;
                r--;
            }
            if (l == r) {
                count++;
                break;
            }
        }
        System.out.println(count);
    }
}
