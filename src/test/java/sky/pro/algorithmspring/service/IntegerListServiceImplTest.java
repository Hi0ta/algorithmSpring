package sky.pro.algorithmspring.service;
import org.junit.jupiter.api.Test;
import sky.pro.algorithmspring.exception.IllegalIndexException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerListServiceImplTest {

    IntegerListServiceImpl integerListServiceImpl = new IntegerListServiceImpl();

    private Integer[] integerArr = new Integer[10];
    private Integer item;
    private int index;

    @Test
    void checkAddInteger() {
        item = 1;
        Integer checkedItem = integerListServiceImpl.addInteger(item);

        assertEquals(checkedItem, item);
    }

    @Test
    void checkAddIntegerWhenSizeEqualsLength() {
        integerListServiceImpl.addInteger(6);
        integerListServiceImpl.addInteger(2);
        integerListServiceImpl.addInteger(7);
        integerListServiceImpl.addInteger(3);
        integerListServiceImpl.addInteger(4);
        integerListServiceImpl.addInteger(1);
        integerListServiceImpl.addInteger(7);
        integerListServiceImpl.addInteger(3);
        integerListServiceImpl.addInteger(4);
        integerListServiceImpl.addInteger(1);
        item = 11;

        Integer checkedItem = integerListServiceImpl.addInteger(item);

        assertEquals(checkedItem, item);
    }

    @Test
    void checkAddIntegerWhenItemEqualsNull() {
        item = null;
        index = 0;
        assertThrows(NullPointerException.class,  () -> integerListServiceImpl.addInteger(item));
    }

    @Test
    void checkAddByIndexToBeginning() {
        item = 11;
        index = 0;
        Integer checkedItem = integerListServiceImpl.addByIndex(index, item);

        assertEquals(checkedItem, 11);
    }

    @Test
    void checkAddByIndexToMiddle() {
        integerListServiceImpl.addInteger(1);
        integerListServiceImpl.addInteger(2);
        integerListServiceImpl.addInteger(3);
        integerListServiceImpl.addInteger(4);
        integerListServiceImpl.addInteger(6);
        integerListServiceImpl.addInteger(7);

        item = 5;
        index = 4;
        Integer checkedItem = integerListServiceImpl.addByIndex(index, item);

        assertEquals(checkedItem, 5);
    }

    @Test
    void checkAddByIndexWhenSizeEqualsLength() {
        item = 11;
        for (index = 0; index == integerArr.length; index++){
            integerListServiceImpl.addInteger(item);
        }
            Integer checkedItem = integerListServiceImpl.addInteger(item);

        assertEquals(checkedItem, item);
    }


    @Test
    void checkAddByIndexWhenItemEqualsNull() {
        integerListServiceImpl.addByIndex(0, 1);
        item = null;
        index = 0;
        assertThrows(NullPointerException.class,  () -> integerListServiceImpl.addByIndex(index, item));
    }

    @Test
    void checkAddByIndexWhenIndexNotFound() {
        item = 5;
        index = 5;
        assertThrows(IllegalIndexException.class,  () -> integerListServiceImpl.addByIndex(index, item));
    }

    @Test
    void checkSetByIndex() {
        item = 0;
        index = 0;
        Integer checkedItem = integerListServiceImpl.setByIndex(index, item);

        assertEquals(checkedItem, 0);
    }


    @Test
    void checkSetByIndexWhenItemEqualsNull() {
        integerListServiceImpl.setByIndex(0, 1);
        item = null;
        index = 0;
        assertThrows(NullPointerException.class,  () -> integerListServiceImpl.setByIndex(index, item));
    }

    @Test
    void checkSetByIndexWhenIndexNotFound() {
        item = 5;
        index = 5;
        assertThrows(IllegalIndexException.class,  () -> integerListServiceImpl.setByIndex(index, item));
    }

    @Test
    void checkRemove() {
        item = 0;
        integerListServiceImpl.addInteger(item);
        Integer checkedItem = integerListServiceImpl.remove(item);

        assertEquals(checkedItem, 0);
    }

    @Test
    void checkRemoveWhenItemEqualsNull() {
        item = null;
        assertThrows(NullPointerException.class,  () -> integerListServiceImpl.remove(item));
    }

    @Test
    void checkRemoveWhenIndexNotFound() {
        assertThrows(IllegalIndexException.class,  () -> integerListServiceImpl.remove(1));
    }

    @Test
    void checkRemoveByIndex() {
        item = 0;
        integerListServiceImpl.addInteger(item);
        index = 0;
        Integer checkedItem = integerListServiceImpl.removeByIndex(index);
        assertEquals(checkedItem, 0);
    }

    @Test
    void checkRemoveByIndexWhenIndexNotFound() {
        assertThrows(IllegalIndexException.class,  () -> integerListServiceImpl.removeByIndex(5));
    }

    @Test
    void checkContainsMax() {
        integerListServiceImpl.addInteger(6);
        integerListServiceImpl.addInteger(2);
        integerListServiceImpl.addInteger(7);
        integerListServiceImpl.addInteger(3);
        integerListServiceImpl.addInteger(4);
        integerListServiceImpl.addInteger(1);
        integerListServiceImpl.addInteger(7);
        integerListServiceImpl.addInteger(3);
        integerListServiceImpl.addInteger(4);
        integerListServiceImpl.addInteger(1);
        item = 7;
        boolean checkedContainsItem = integerListServiceImpl.contains(item);
        assertTrue(checkedContainsItem);
    }

    @Test
    void checkContainsMin() {
        integerListServiceImpl.addInteger(6);
        integerListServiceImpl.addInteger(2);
        integerListServiceImpl.addInteger(7);
        integerListServiceImpl.addInteger(3);
        integerListServiceImpl.addInteger(4);
        integerListServiceImpl.addInteger(0);
        integerListServiceImpl.addInteger(7);
        integerListServiceImpl.addInteger(3);
        integerListServiceImpl.addInteger(4);
        integerListServiceImpl.addInteger(1);
        item = 0;
        boolean checkedContainsItem = integerListServiceImpl.contains(item);
        assertTrue(checkedContainsItem);
    }

    @Test
    void checkContainsWhenItemNotFound() {
        integerListServiceImpl.addInteger(6);
        integerListServiceImpl.addInteger(2);
        integerListServiceImpl.addInteger(7);
        integerListServiceImpl.addInteger(3);
        integerListServiceImpl.addInteger(4);
        integerListServiceImpl.addInteger(1);
        integerListServiceImpl.addInteger(7);
        integerListServiceImpl.addInteger(3);
        integerListServiceImpl.addInteger(4);
        integerListServiceImpl.addInteger(1);
        item = 33;
        boolean checkedContainsItem = integerListServiceImpl.contains(item);
        assertFalse(checkedContainsItem);
    }

    @Test
    void checkIndexOf() {
        item = 6;
        integerListServiceImpl.addInteger(item);
        int checkedIndex = integerListServiceImpl.indexOf(item);
        assertEquals(checkedIndex, 0);
    }

    @Test
    void checkLastIndexOf() {
        item = 6;
        integerListServiceImpl.addInteger(item);
        int checkedIndex = integerListServiceImpl.lastIndexOf(item);
        assertEquals(checkedIndex, 0);
    }

    @Test
    void checkLastIndexOfWhenIndexNotFound() {
        item = 11;
        int checkedIndex = integerListServiceImpl.lastIndexOf(item);
        assertEquals(checkedIndex, -1);
    }

    @Test
    void checkGetByIndex() {
        index = 0;
        item = 6;
        integerListServiceImpl.addInteger(item);
        Integer checkedItem = integerListServiceImpl.getByIndex(index);
        assertEquals(checkedItem, 6);
    }


    @Test
    void checkGetByIndexWhenIndexNotFound() {
        assertThrows(IllegalIndexException.class,  () -> integerListServiceImpl.getByIndex(5));
    }

    @Test
    void checkStringListEqualsOtherList() {
        List<Integer> otherList = new ArrayList<>(List.of(1, 2, 3));
        boolean checkedEqualsList = integerListServiceImpl.integerListEqualsOtherList(otherList);
        assertFalse(checkedEqualsList);
    }

    @Test
    void checkGetSize() {
        integerListServiceImpl.addInteger(1);
        integerListServiceImpl.addInteger(2);
        integerListServiceImpl.addInteger(3);
        int checkedIndex = integerListServiceImpl.getSize();
        assertEquals(checkedIndex, 3);
    }

    @Test
    void checkIsEmpty() {
        boolean checkedIndexIsEmpty = integerListServiceImpl.isEmpty();
        assertTrue(checkedIndexIsEmpty);
    }

    @Test
    void checkClearAll() {
        integerListServiceImpl.clearAll();
        assertEquals(integerListServiceImpl.getSize(), 0);
    }

    @Test
    void checkToArray() {
        integerListServiceImpl.addInteger(1);
        integerListServiceImpl.addInteger(2);
        integerListServiceImpl.addInteger(3);
        Integer[] integerArrCopy = Arrays.copyOf(integerArr, integerArr.length);
        assertArrayEquals(integerArr, integerArrCopy);
    }
}
