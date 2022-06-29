
import java.util.Scanner;
import java.util.stream.Stream;


public class mergeSortArray {
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

    static int[] array;

    public mergeSortArray(int[] ar) {
        array = ar;
    }

    public int[] mergeArray(int[] first, int[] second) {
        int[] third = new int[first.length + second.length];
        int posFirst = 0, posSecond = 0;
        for (int i = 0; i < third.length; i++) {
            if (posFirst == first.length) {
                third[i] = second[posSecond];
                posSecond++;
            } else if (posSecond == second.length) {
                third[i] = first[posFirst];
                posFirst++;
            } else if (first[posFirst] < second[posSecond]) {
                third[i] = first[posFirst];
                posFirst++;
            } else {
                third[i] = second[posSecond];
                posSecond++;
            }
        }
        return third;
    }

    public int[] sortArray(int[] first) {
        if (first.length < 2) return first;

        int[] second = new int[first.length / 2];
        System.arraycopy(first, 0, second, 0, first.length / 2);

        int[] third = new int[first.length - first.length / 2];
        System.arraycopy(first, first.length / 2, third, 0, first.length - first.length / 2);

        second = sortArray(second);
        third = sortArray(third);
        return mergeArray(second, third);
    }


    public static void main(String[] args) {
        int[] fromUser = getFromUser();

        mergeSortArray Merge = new mergeSortArray(fromUser);
        System.out.println("Отсортированный массив:");
        printArray(Merge.sortArray(array));
    }

}