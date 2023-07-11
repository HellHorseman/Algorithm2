package pro.sky.java.course2.Interface;

import pro.sky.java.course2.Exceptions.ArrayIsFullException;
import pro.sky.java.course2.Exceptions.OutOfBoundException;
import pro.sky.java.course2.Exceptions.ParametrIsNullException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] integerArray;
    private int size;

    public IntegerListImpl() {
        integerArray = new Integer[5];
    }

    public IntegerListImpl(int initSize) {
        integerArray = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        integerArray[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            integerArray[size++] = item;
            return item;
        }
        System.arraycopy(integerArray, index, integerArray, index + 1, size - index);
        integerArray[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        integerArray[index] = item;
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
        Integer item = integerArray[index];
        if (index != size) {
            System.arraycopy(integerArray, index + 1, integerArray, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] integerArrayCopy = toArray();
        sort(integerArrayCopy);
        return binarySearch(integerArrayCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integerArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (integerArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return integerArray[index];
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
        return Arrays.copyOf(integerArray, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new ParametrIsNullException("Parameter Is Null!");
        }
    }

    private void validateSize() {
        if (size == integerArray.length) {
            grow();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new OutOfBoundException("Out Of Bound!");
        }
    }

    private void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
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

    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow() {
        integerArray = Arrays.copyOf(integerArray, size + size / 2);
    }
}
