package sky.pro.algorithmspring;

public class Main {

    public static void main(String[] args) {

        Integer[] arrOne = generateRandomArray();
        Integer begin = 0;
        Integer end = arrOne.length-1;
        long startOne = System.currentTimeMillis();
        quickSort(arrOne, begin, end);
        System.out.println(System.currentTimeMillis() - startOne);

    }
    public static void quickSort(Integer[] arr, Integer begin, Integer end) {
        if (begin < end) {
            Integer partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static Integer partition(Integer[] arr, Integer begin, Integer end) {
        Integer pivot = arr[end];
        Integer i = (begin - 1);
        for (Integer j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
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
}
