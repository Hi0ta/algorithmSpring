//package sky.pro.algorithmspring.service;
//
//import sky.pro.algorithmspring.exception.IllegalIndexException;
//import sky.pro.algorithmspring.exception.SizeDoesNotMatchException;
//
//import java.util.Arrays;
//import java.util.List;
//
//
//public class StringListServiceImpl implements ListService {
//
//    private final String[] stringArr;
//    private int size;
//
//    public StringListServiceImpl() {
//        this.stringArr = new String[10];
//    }
//
////    public StringListServiceImpl(int initSize) {this.stringArr = new String[initSize];}
//
//    @Override
//    public String addString(String item) {
//        validateSize();
//        validateItem(item);
//        stringArr[size++] = item;
//        return item;
//    }
//
//    @Override
//    public String addByIndex(int index, String item) {
//        validateSize();
//        validateItem(item);
//        validateIndex(index);
//        if (index == size) {
//            stringArr[size++] = item;
//            return item;
//        }
//        System.arraycopy(stringArr, index, stringArr, ++index, size - index);
//        stringArr[index] = item;
//        size++;
//        return item;
//    }
//
//    @Override
//    public String setByIndex(int index, String item) {
//        validateIndex(index);
//        validateItem(item);
//        stringArr[index] = item;
//        return item;
//    }
//
//    @Override
//    public String remove(String item) {
//        validateItem(item);
//        int index = indexOf(item);
//        return removeByIndex(index);
//    }
//
//    @Override
//    public String removeByIndex(int index) {
//        validateIndex(index);
//        String item = stringArr[index];
//        if (index != size) {
//            System.arraycopy(stringArr, index + 1, stringArr, index, size - index);
//        }
//        size--;
//        return item;
//    }
//
//    @Override
//    public boolean contains(String item) {
//        return indexOf(item) != -1;
//    }
//
//    @Override
//    public int indexOf(String item) {
//        for (int i = 0; i < size; i++) {
//            if (stringArr[i].equals(item)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    @Override
//    public int lastIndexOf(String item) {
//        for (int i = size - 1; 0 <= i; i--) {
//            if (stringArr[i].equals(item)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    @Override
//    public String getByIndex(int index) {
//        validateIndex(index);
//        return stringArr[index];
//    }
//
//    @Override
//    public boolean stringListEqualsOtherList(List<String> otherList) {
//        return Arrays.equals(this.toArray(), otherList.toArray());
//    }
//
//    @Override
//    public int getSize() {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    @Override
//    public void clearAll() {size = 0;}
//
//    @Override
//    public String[] toArray() {
//        return Arrays.copyOf(stringArr, size);
//    }
//
//    private void validateItem(String item) {
//        if (item == null) {
//            throw new NullPointerException("строка не должна быть null");
//        }
//    }
//
//    private void validateSize() {
//        if (size == stringArr.length) {
//            throw new SizeDoesNotMatchException("size не должен быть равен длине массива");
//        }
//    }
//
//    private void validateIndex(int index) {
//        if (index < 0 || index > size) {
//            throw new IllegalIndexException("заданого индекса не существует");
//        }
//    }
//}