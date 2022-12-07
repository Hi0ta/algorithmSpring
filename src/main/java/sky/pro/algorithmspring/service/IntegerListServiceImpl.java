package sky.pro.algorithmspring.service;
import sky.pro.algorithmspring.exception.IllegalIndexException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class IntegerListServiceImpl implements ListService {
    private Integer[] integerArr;
    private int size;

    public IntegerListServiceImpl() {
        this.integerArr = new Integer[10];
    }

    // public IntegerListServiceImpl(int initSize) {this.integerArr = new Integer[initSize];}

    @Override
    public Integer addInteger(Integer item) {
        validateSize();
        validateItem(item);

        integerArr[size++] = item;
        return item;
    }

    @Override
    public Integer addByIndex(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            integerArr[size++] = item;
            return item;
        }
        System.arraycopy(integerArr, index, integerArr, ++index, size - index);
        integerArr[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer setByIndex(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        integerArr[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return removeByIndex(index);
    }

    @Override
    public Integer removeByIndex(int index) {
        validateIndex(index);
        Integer item = integerArr[index];
        if (index != size) {
            System.arraycopy(integerArr, index + 1, integerArr, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer begin = 0;
        Integer end = integerArr.length-1;
        quickSort(integerArr, begin, end);
        int min = 0;
        int max = integerArr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (Objects.equals(item, integerArr[mid])) {
                return true;
            }

            if (item < integerArr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integerArr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; 0 <= i; i--) {
            if (integerArr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer getByIndex(int index) {
        validateIndex(index);
        return integerArr[index];
    }

    @Override
    public boolean integerListEqualsOtherList(List<Integer> otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clearAll() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integerArr, size);
    }


    private void validateSize() {
        if (size == integerArr.length) {
  //          throw new SizeDoesNotMatchException("size не должен быть равен длине массива");
            grow();
        }
    }

    private void grow() {
        int index = integerArr.length;
        size = (int) Math.ceil(integerArr.length * 1.5);
        integerArr = Arrays.copyOf(integerArr,size);
        size = index;
    }


    private void swapElements(Integer[] integerArr, Integer indexA, Integer indexB) {
        Integer tmp = integerArr[indexA];
        integerArr[indexA] = integerArr[indexB];
        integerArr[indexB] = tmp;
    }

    public void quickSort(Integer[] integerArr, Integer begin, Integer end) {
        if (begin < end) {
            Integer partitionIndex = partition(integerArr, begin, end);

            quickSort(integerArr, begin, partitionIndex - 1);
            quickSort(integerArr, partitionIndex + 1, end);
        }
    }

    private Integer partition(Integer[] integerArr, Integer begin, Integer end) {
        Integer pivot = integerArr[end];
        Integer i = (begin - 1);
        for (Integer j = begin; j < end; j++) {
            if (integerArr[j] <= pivot) {
                i++;

                swapElements(integerArr, i, j);
            }
        }
        swapElements(integerArr, i + 1, end);
        return i + 1;
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalIndexException("заданого индекса не существует");
        }
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullPointerException("Integer не должeн быть null");
        }
    }
}
//    @Override
//    public String toString() {
//        return Arrays.toString(integerArr);
//    }