package pro.sky.java.course2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        sortBubble(creatArray());
        long start = System.currentTimeMillis();
        sortBubble(creatArray());
        System.out.println(System.currentTimeMillis() - start);
        sortSelection(creatArray());
        long start1 = System.currentTimeMillis();
        sortSelection(creatArray());
        System.out.println(System.currentTimeMillis() - start1);
        sortInsertion(creatArray());
        long start2 = System.currentTimeMillis();
        sortInsertion(creatArray());
        System.out.println(System.currentTimeMillis() - start2);
    }

    public static int[] creatArray() {
        Random random = new Random();
        int arr[] = new int[100000];
        for (int i : arr) {
            arr[i] = random.nextInt();
//            System.out.println(arr[i]);
        }
        return arr;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }


}