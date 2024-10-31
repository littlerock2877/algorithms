package ru.mail.littlerock2877.stepik.greedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SaleForHamsters {
    /* Задача B. Распродажа для хомяков
    Продавец предоставляет покупателю, делающему большую закупку, скидку по следующим правилам:

    1) на каждый второй товар стоимостью больше 50 рублей предоставляется скидка 25%;
    2) общая стоимость покупки со скидкой округляется вверх до целого числа рублей;
    3) порядок товаров в списке определяет продавец и делает это так, чтобы общая сумма скидки была наименьшей.

    По известной стоимости каждого товара в покупке необходимо определить общую стоимость покупки с учётом скидки и стоимость самого дорогого товара, на который будет предоставлена скидка.

    Формат входных данных
    Первая строка входного файла содержит число N- общее количество купленных товаров. В следующей строке идет N стоимостей товаров в рублях.

    Формат выходных данных
    В ответе запишите два целых числа: сначала общую стоимость покупки с учётом скидки, затем стоимость самого дорогого товара, на который будет предоставлена скидка.

    Sample Input 1:
    6
    125 50 490 215 144 320
    Sample Output 1:
    1277 144
    Sample Input 2:
    10
    212 30 44 5 88 9 1011 982 192 10
    Sample Output 2:
    2513 192 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scanner.nextInt();
            if (prices[i] <= 50) {
                sum += prices[i];
            }
        }

        prices = Arrays.stream(prices).filter(x -> x > 50).sorted().toArray();

        for (int i = 0; i < prices.length / 2; i++) {
            sum += (int) Math.round(prices[i] * 0.75);
        }

        for (int i = prices.length / 2; i < prices.length; i++) {
            sum += prices[i];
        }
        System.out.printf("%d %d", sum, prices[prices.length / 2 - 1]);
    }
}
