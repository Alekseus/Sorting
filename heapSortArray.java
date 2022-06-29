import java.util.Scanner;
import java.util.stream.Stream;

public class heapSortArray {
    public static void swap(int[]array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
    public static void printArray(int array[]) {
        int length = array.length;
        for (int i = 0; i < length; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    public static int[] getFromUser(){
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите числа через пробел: ");
        int myArray[] = Stream.of(iScanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        iScanner.close();
        return myArray;
    }

    void heapyfi(int[] array, int lenArray, int i) {
        int largestNumber = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < lenArray && array[leftChild] > array[largestNumber])
            largestNumber = leftChild;
        if (rightChild < lenArray && array[rightChild] > array[largestNumber])
            largestNumber = rightChild;
        if (largestNumber != i) {
            swap(array, i, largestNumber);
            heapyfi(array, lenArray, largestNumber);
        }
    }

    public void nowWeCanSort(int[] array) {
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--)
            heapyfi(array, length, i);
        for (int i = length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapyfi(array, i, 0);
        }
    }

    public static void main(String args[]) {
        int[] myArray = getFromUser();

        heapSortArray mySorting = new heapSortArray();
        mySorting.nowWeCanSort(myArray);

        System.out.println("Отсортированный массив:");
        printArray(myArray);
    }

}