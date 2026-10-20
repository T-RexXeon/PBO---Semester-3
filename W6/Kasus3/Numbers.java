package W6.Kasus3;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Integer[] numberList; 
        int size;

        Scanner scan = new Scanner(System.in);

        System.out.print("\nHow many integers do you want to sort? ");
        size = scan.nextInt();
        numberList = new Integer[size];

        System.out.println("Enter the numbers...");
        for (int i = 0; i < size; i++) {
            numberList[i] = scan.nextInt();
        }

        Sorting.insertionSort(numberList);

        System.out.println("\nYour numbers in sorted order (Descending):");
        for (int i = 0; i < size; i++) {
            System.out.print(numberList[i] + " ");
        }
        System.out.println();
    }
}