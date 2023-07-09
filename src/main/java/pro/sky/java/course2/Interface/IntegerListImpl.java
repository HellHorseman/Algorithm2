package pro.sky.java.course2.Interface;

import pro.sky.java.course2.Exceptions.ArrayIsFullException;
import pro.sky.java.course2.Exceptions.OutOfBoundException;
import pro.sky.java.course2.Exceptions.ParametrIsNullException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private final Integer[] IntegerArray;
    private int size;

    public IntegerListImpl() {
        IntegerArray = new Integer[5];
    }

    public IntegerListImpl(int initSize) {
        IntegerArray = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        IntegerArray[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            IntegerArray[size++] = item;
            return item;
        }
        System.arraycopy(IntegerArray, index, IntegerArray, index + 1, size - index);
        IntegerArray[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        IntegerArray[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
validateIndex(index);
        Integer item = IntegerArray[index];
        if (index != size) {
            System.arraycopy(IntegerArray, index + 1, IntegerArray, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (IntegerArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (IntegerArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return IntegerArray[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer[] toArray() {
        return Arrays.copyOf(IntegerArray, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new ParametrIsNullException("Parameter Is Null!");
        }
    }

    private void validateSize() {
        if (size == IntegerArray.length) {
            throw new ArrayIsFullException("Array Is Full!");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new OutOfBoundException("Out Of Bound!");
        }
    }
}
