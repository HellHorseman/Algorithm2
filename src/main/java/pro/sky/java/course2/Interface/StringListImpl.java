package pro.sky.java.course2.Interface;

import pro.sky.java.course2.Exceptions.ArrayIsFullException;
import pro.sky.java.course2.Exceptions.OutOfBoundException;
import pro.sky.java.course2.Exceptions.ParametrIsNullException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] stringArray;
    private int size;

    public StringListImpl() {
        stringArray = new String[5];
    }

    public StringListImpl(int initSize) {
        stringArray = new String[initSize];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        stringArray[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            stringArray[size++] = item;
            return item;
        }
        System.arraycopy(stringArray, index, stringArray, index + 1, size - index);
        stringArray[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        stringArray[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
validateIndex(index);
        String item = stringArray[index];
        if (index != size) {
            System.arraycopy(stringArray, index + 1, stringArray, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (stringArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (stringArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return stringArray[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringArray, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new ParametrIsNullException("Parameter Is Null!");
        }
    }

    private void validateSize() {
        if (size == stringArray.length) {
            throw new ArrayIsFullException("Array Is Full!");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new OutOfBoundException("Out Of Bound!");
        }
    }
}
