package ru.mail.littlerock2877.stepik.greedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class CargoСonsignment {
    /* Задача C. Партия грузов
    Для перевозки партии грузов различной массы выделен грузовик, но его грузоподъёмность ограничена, поэтому перевезти сразу все грузы не удастся.
    Грузы массой от 210 до 220 кг грузят в первую очередь, гарантируется, что все такие грузы поместятся. На оставшееся после этого место стараются взять как можно больше грузов.
    Если это можно сделать несколькими способами, выбирают тот способ, при котором самый большой из выбранных грузов имеет наибольшую массу.
    Если и при этом условии возможно несколько вариантов, выбирается тот, при котором наибольшую массу имеет второй по величине груз, и т.д.
    Известны количество грузов, масса каждого из них и грузоподъёмность грузовика. Необходимо определить количество и общую массу грузов, которые будут вывезены при погрузке по вышеописанным правилам.

    Формат входных данных
    Первая строка входного файла содержит два целых числа: N - общее количество грузов и M - грузоподъёмность грузовика в кг. Далее в одной строке задаются N масс грузов в кг.

    Формат выходных данных
    В ответе запишите два целых числа: сначала максимально возможное количество грузов, затем их общую массу.

    Замечание
    Все грузы массой от 210 до 220 кг можно погрузить на грузовик.

    Sample Input 1:
    6 615
    140 215 120 160 100 340
    Sample Output 1:
    4 615
    Sample Input 2:
    7 1024
    111 222 333 98 345 423 56
    Sample Output 2:
    5 1021 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] weights = new int[n];

        int total = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            if (weights[i] >= 210 && weights[i] <= 220) {
                total += weights[i];
                count++;
            }
        }

        weights = Arrays.stream(weights).filter(x -> x < 210 || x > 220).sorted().toArray();

        int iMax = 0;
        for (int i = 0; i < weights.length; i++) {
            if (total + weights[i] <= m) {
                total += weights[i];
                count++;
                iMax = i;
            } else {
                break;
            }
        }

        for (int i = iMax; i >= 0; i--) {
            for (int j = iMax +1; j < weights.length; j++) {
                if (total - weights[i] + weights[j] <= m) {
                    total += weights[j] - weights[i];
                    int temp = weights[j];
                    weights[j] = weights[i];
                    weights[i] = temp;
                }
            }
        }

        System.out.printf("%d %d", count, total);
    }
}
