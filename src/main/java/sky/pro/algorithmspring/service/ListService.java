package sky.pro.algorithmspring.service;
import java.util.List;

public interface ListService {
    Integer addInteger(Integer item);

    Integer addByIndex(int index, Integer item);

    Integer setByIndex(int index, Integer item);

    Integer remove(Integer item);

    Integer removeByIndex(int index);

    boolean contains(Integer item);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    Integer getByIndex(int index);

    boolean integerListEqualsOtherList(List<Integer> otherList);

    int getSize();

    boolean isEmpty();

    void clearAll();

    Integer[] toArray();
}
