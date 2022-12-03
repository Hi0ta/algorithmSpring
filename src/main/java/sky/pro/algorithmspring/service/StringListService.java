package sky.pro.algorithmspring.service;

import java.util.List;

public interface StringListService {
    String addString(String item);

    String addByIndex(int index, String item);

    String setByIndex(int index, String item);

    String remove(String item);

    String removeByIndex(int index);

    boolean contains(String item);

    int indexOf(String item);

    int lastIndexOf(String item);

    String getByIndex(int index);

    boolean stringListEqualsOtherList(List<String> otherList);

    int getSize();

    boolean isEmpty();

    void clearAll();

    String[] toArray();
}
