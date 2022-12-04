package sky.pro.algorithmspring.service;

import org.junit.jupiter.api.Test;
import sky.pro.algorithmspring.exception.IllegalIndexException;
import sky.pro.algorithmspring.exception.SizeDoesNotMatchException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListServiceImplTest {
    StringListServiceImpl stringListServiceImpl = new StringListServiceImpl();

    private String[] stringArr = new String[10];
    private String item;
    private int index;

    @Test
    void checkAddString() {
        item = "str1";
        index = 0;
        String checkedItem = stringListServiceImpl.addString(item);

        assertEquals(checkedItem, "str1");
    }

    @Test
    void checkAddStringWhenSizeEqualsLength() {
        for (index = 0; index < stringArr.length; index++) {
            stringListServiceImpl.addString("str");
        }
        assertThrows(SizeDoesNotMatchException.class,  () -> stringListServiceImpl.addString("str"));
    }

    @Test
    void checkAddStringWhenItemEqualsNull() {
        item = null;
        index = 0;
        assertThrows(NullPointerException.class,  () -> stringListServiceImpl.addString(item));
    }

    @Test
    void checkAddByIndexToBeginning() {
        item = "str00";
        index = 0;
        String checkedItem = stringListServiceImpl.addByIndex(index, item);

        assertEquals(checkedItem, "str00");
    }

    @Test
    void checkAddByIndexToMiddle() {
        stringListServiceImpl.addString("str1");
        stringListServiceImpl.addString("str2");
        stringListServiceImpl.addString("str3");
        stringListServiceImpl.addString("str4");
        stringListServiceImpl.addString("str6");
        stringListServiceImpl.addString("str7");

        item = "str5";
        index = 4;
        String checkedItem = stringListServiceImpl.addByIndex(index, item);

        assertEquals(checkedItem, "str5");
    }

    @Test
    void checkAddByIndexWhenSizeEqualsLength() {
        for (index = 0; index < stringArr.length; index++) {
            stringListServiceImpl.addString("str");
        }
        assertThrows(SizeDoesNotMatchException.class,  () -> stringListServiceImpl.addByIndex(10,"str"));
    }


    @Test
    void checkAddByIndexWhenItemEqualsNull() {
        stringListServiceImpl.addByIndex(0, "str1");
        item = null;
        index = 0;
        assertThrows(NullPointerException.class,  () -> stringListServiceImpl.addByIndex(index, item));
    }

    @Test
    void checkAddByIndexWhenIndexNotFound() {
        item = "str5";
        index = 5;
        assertThrows(IllegalIndexException.class,  () -> stringListServiceImpl.addByIndex(index, item));
    }

    @Test
    void checkSetByIndex() {
        item = "str0";
        index = 0;
        String checkedItem = stringListServiceImpl.setByIndex(index, item);

        assertEquals(checkedItem, "str0");
    }


    @Test
    void checkSetByIndexWhenItemEqualsNull() {
        stringListServiceImpl.setByIndex(0, "str1");
        item = null;
        index = 0;
        assertThrows(NullPointerException.class,  () -> stringListServiceImpl.setByIndex(index, item));
    }

    @Test
    void checkSetByIndexWhenIndexNotFound() {
        item = "str5";
        index = 5;
        assertThrows(IllegalIndexException.class,  () -> stringListServiceImpl.setByIndex(index, item));
    }

    @Test
    void checkRemove() {
        item = "str0";
        stringListServiceImpl.addString(item);
        String checkedItem = stringListServiceImpl.remove(item);

        assertEquals(checkedItem, "str0");
    }

    @Test
    void checkRemoveWhenItemEqualsNull() {
        item = null;
        assertThrows(NullPointerException.class,  () -> stringListServiceImpl.remove(item));
    }

    @Test
    void checkRemoveWhenIndexNotFound() {
        assertThrows(IllegalIndexException.class,  () -> stringListServiceImpl.remove("str1"));
    }

    @Test
    void checkRemoveByIndex() {
        item = "str0";
        stringListServiceImpl.addString(item);
        index = 0;
        String checkedItem = stringListServiceImpl.removeByIndex(index);
        assertEquals(checkedItem, "str0");
    }

    @Test
    void checkRemoveByIndexWhenIndexNotFound() {
        assertThrows(IllegalIndexException.class,  () -> stringListServiceImpl.removeByIndex(5));
    }

    @Test
    void checkContains() {
        item = "str0";
        stringListServiceImpl.addString(item);
        boolean checkedContainsItem = stringListServiceImpl.contains(item);
        assertTrue(checkedContainsItem);
    }

    @Test
    void checkIndexOf() {
        item = "str6";
        stringListServiceImpl.addString(item);
        int checkedIndex = stringListServiceImpl.indexOf(item);
        assertEquals(checkedIndex, 0);
    }

    @Test
    void checkLastIndexOf() {
        item = "str6";
        stringListServiceImpl.addString(item);
        int checkedIndex = stringListServiceImpl.lastIndexOf(item);
        assertEquals(checkedIndex, 0);
    }

    @Test
    void checkLastIndexOfWhenIndexNotFound() {
        item = "str11";
        int checkedIndex = stringListServiceImpl.lastIndexOf(item);
        assertEquals(checkedIndex, -1);
    }

    @Test
    void checkGetByIndex() {
        index = 0;
        item = "str6";
        stringListServiceImpl.addString(item);
        String checkedItem = stringListServiceImpl.getByIndex(index);
        assertEquals(checkedItem, "str6");
    }


    @Test
    void checkGetByIndexWhenIndexNotFound() {
        assertThrows(IllegalIndexException.class,  () -> stringListServiceImpl.getByIndex(5));
    }

    @Test
    void checkStringListEqualsOtherList() {
        List<String> otherList = new ArrayList<>(List.of("str1", "str2", "str3"));
        boolean checkedEqualsList = stringListServiceImpl.stringListEqualsOtherList(otherList);
        assertFalse(checkedEqualsList);
    }

    @Test
    void checkGetSize() {
        stringListServiceImpl.addString("str1");
        stringListServiceImpl.addString("str2");
        stringListServiceImpl.addString("str3");
        int checkedIndex = stringListServiceImpl.getSize();
        assertEquals(checkedIndex, 3);
    }

    @Test
    void checkIsEmpty() {
        boolean checkedIndexIsEmpty = stringListServiceImpl.isEmpty();
        assertTrue(checkedIndexIsEmpty);
    }

    @Test
    void checkClearAll() {
        stringListServiceImpl.clearAll();
        assertEquals(stringListServiceImpl.getSize(), 0);
    }

    @Test
    void checkToArray() {
        stringListServiceImpl.addString("str1");
        stringListServiceImpl.addString("str2");
        stringListServiceImpl.addString("str3");
        String[] stringArrCopy = Arrays.copyOf(stringArr, stringArr.length);
        assertArrayEquals(stringArr, stringArrCopy);
    }
}