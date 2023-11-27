package edu.ntudp.sau;

import java.util.Random;
import java.util.Scanner;

public class matrixRunnerLab2 {
    // Константи для діапазону рандомних чисел
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть спосіб створення матриці:");
        System.out.println("1. Ручне введення");
        System.out.println("2. Рандомне заповнення");
        int choice = scanner.nextInt();

        int[][] matrix;

        switch (choice) {
            case 1:
                matrix = createMatrixManually(scanner);
                break;
            case 2:
                matrix = createMatrixRandomly();
                break;
            default:
                System.out.println("Неправильний вибір. Використано рандомне заповнення.");
                matrix = createMatrixRandomly();
        }

        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);
        double geometricAverage = calculateGeometricAverage(matrix);

        System.out.println("Мінімальний елемент матриці: " + min);
        System.out.println("Максимальний елемент матриці: " + max);
        System.out.println("Середнє арифметичне елементів матриці: " + average);
        System.out.println("Середнє геометричне елементів матриці: " + geometricAverage);

        scanner.close();
    }

    private static int[][] createMatrixManually(Scanner scanner) {
        System.out.println("Введіть розмір матриці (ширина та висота, не більше 20):");
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        int[][] matrix = new int[height][width];

        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] createMatrixRandomly() {
        Random random = new Random();
        int width = random.nextInt(20) + 1; // Розмір матриці від 1 до 20
        int height = random.nextInt(20) + 1;

        int[][] matrix = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");

        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];

        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }

        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];

        for (int[] row : matrix) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }

        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }

        return (double) sum / count;
    }

    private static double calculateGeometricAverage(int[][] matrix) {
        int product = 1;
        int count = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                product *= value;
                count++;
            }
        }

        return Math.pow(product, 1.0 / count);
    }
}