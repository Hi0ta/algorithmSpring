package sky.pro.algorithmspring;

import sky.pro.algorithmspring.service.IntegerListServiceImpl;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        Integer[] arrOne = generateRandomArray();
        Integer[] arrTwo = Arrays.copyOf(arrOne, arrOne.length);
        Integer[] arrThree = Arrays.copyOf(arrOne, arrOne.length);
        System.out.println(Arrays.equals(arrOne, arrTwo));
        System.out.println(Arrays.equals(arrOne, arrThree));
        System.out.println(Arrays.equals(arrTwo, arrThree));

        long startOne = System.currentTimeMillis();
        sortBubble(arrOne);
        System.out.println(System.currentTimeMillis() - startOne);

       // System.out.println(Arrays.toString(arrOne));

        long startTwo = System.currentTimeMillis();
        sortSelection(arrTwo);
        System.out.println(System.currentTimeMillis() - startTwo);

       // System.out.println(Arrays.toString(arrTwo));

        long startThree = System.currentTimeMillis();
        sortInsertion(arrThree);
        System.out.println(System.currentTimeMillis() - startThree);

      //  System.out.println(Arrays.toString(arrThree));


    }
    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }



    public static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arrRandom = new Integer[100_000];
        for (int i = 0; i < arrRandom.length; i++) {
            arrRandom[i] = random.nextInt(99);
        }
        return arrRandom;
    }

    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
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

    public static void sortInsertion(Integer[] arr) {
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
