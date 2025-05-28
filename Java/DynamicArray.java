public class DynamicArray {
    private int size;
    private int capacity = 10;
    private int[] arr;
    public DynamicArray(int cap) {
        this.capacity = cap;
        this.arr = new int[capacity];
    }
    public DynamicArray() {
        this.arr = new int[capacity];
    }
    public void append(int n) {
        if(capacity - size == 1) {
            grow();
        }
        arr[size] = n;
        size++;
    }
    public int get(int index) {
        if(index >= size) {
            throw  new IllegalArgumentException("OUT OF INDEX");
        } else {
            return arr[index];
        }
    }
    public int length() {
        return size;
    }
    public int[] reverse() {
        int l = 0;
        int r = size - 1;
        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            r -= 1;
            l += 1;
        }
        return arr;
    }
    public void removeByIndex(int index) {
        if(index >= size) {
            throw  new IllegalArgumentException("OUT OF INDEX");
        } else {
            for(int i = 0; i < size; i++) {
                if(i == index) {
                    for(int j = i; j < size; j++) {
                        arr[j] = arr[j + 1];
                    }
                    size -= 1;
                }
            }
        }
    }
    public void selectionSort() {
        int minIndex;
        for(int i = 0; i < size; i++) {
            minIndex = i;
            for(int j = i + 1; j< size; j++) {
                if(arr[j] < arr[minIndex]) {
                    int temp = arr[minIndex];
                    arr[minIndex] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public int[] bubbleSort() {
        for(int i = size - 1; i >= 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    public int binarySearch(int n) {
        selectionSort();
        int l = 0;
        int r = size - 1;
        while(l <= r) {
            int mid = ((l + r) / 2);
            if (arr[mid] < n) {
                l = mid + 1;
            } else if (arr[mid] > n) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return  -1;
    }
    public int sum() {
        int sum = 0;
        for(int i = 0; i < size; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public int max() {
        int max = arr[0];
        for(int i = 0; i < size; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public int min() {
        int min = arr[0];
        for(int i = 0; i < size; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    public int range() {
        return (max() - min());
    }
    public void insert(int index, int n) {
        if(capacity - size == 1) {
            grow();
        } else if(index >= size) {
            throw  new IllegalArgumentException("OUT OF INDEX");
        } else {
            for(int i = size; i > index; i--) {
                arr[i] = arr[i -1];
            }
            arr[index] = n;
            size += 1;
        }
    }
    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < size; i++) {
            str += arr[i] + ",";
        }
        if(!str.equals("")) {
            str = "[" + str.substring(0, str.length() - 1) + "]";
        } else {
            str = "[]";
        }
        return str;
    }
    public int pop() {
        int pop = arr[size - 1];
        arr[size - 1] = 0;
        size -= 1;
        return  pop;
    }
    private void shrink() {
        int newCap = (int) capacity / 2;
        int[] newArr = new int[newCap];
        for(int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        capacity = newCap;
        arr = newArr;
    }
    private void grow() {
        int newCap = (int) capacity * 2;
        int[] newArr = new int[newCap];
        for(int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        capacity = newCap;
        arr = newArr;
    }
}
