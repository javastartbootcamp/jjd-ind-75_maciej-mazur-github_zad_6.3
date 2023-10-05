package pl.javastart.task;

import java.util.Scanner;

class ArrayUtils {
    private int[][] arr;
    private final Scanner sc = new Scanner(System.in);
    private static final String ROW_STRING = "wierszy";
    private static final String COLUMN_STRING = "kolumn";

    void run() {
        if (!createArray()) {
            return;
        }

        fillInArray();
        printArray();
    }

    private void printArray() {
        int rowCount = arr.length;
        int columnCount = arr[0].length;
        int hyphenNumber = (columnCount - 1) * 7 + 6;
        String separator = "-".repeat(hyphenNumber);
//        String shorterSpaces = " ".repeat(3);
//        String widerSpaces = " ".repeat(4);

        for (int i = 0; i < rowCount; i++) {
            System.out.printf("%4d |", arr[i][0]);

            for (int j = 1; j < columnCount; j++) {
                System.out.printf("%5d |", arr[i][j]);
            }

            System.out.println();
            System.out.println(separator);
        }
    }

    private void fillInArray() {
        int rowCount = arr.length;
        int columnCount = arr[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                arr[i][j] = i * j;
            }
        }
    }

    private boolean createArray() {
        System.out.println("Podaj liczbę wierszy.");
        int rowNumber = sc.nextInt();
        sc.nextLine();
        if (!isValidNumber(rowNumber, ROW_STRING)) {
            return false;
        }

        System.out.println("Podaj liczbę kolumn.");
        int columnNumber = sc.nextInt();
        sc.nextLine();
        if (!isValidNumber(columnNumber, COLUMN_STRING)) {
            return false;
        }

        arr = new int[rowNumber][columnNumber];
        return true;
    }

    private boolean isValidNumber(int number, String dimensionType) {
        if (number < 1 || number > 100) {
            System.out.println("Liczba " + dimensionType + " musi należeć do przedziału <1, 100>. " +
                    "Nastąpi zakończenie działania programu.");
            return false;
        }

        return true;
    }
}
