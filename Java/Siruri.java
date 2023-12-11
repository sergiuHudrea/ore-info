import java.util.Arrays;
import java.util.ArrayList;

public class Siruri {
    // 1.
    public static void inserare(int[] arr, int index, int nr, int marime) {
        for (int i = marime; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = nr;
    }

    // 2.
    public static void stergere(int[] arr, int index, int marime) {
        for (int i = index; i < marime - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[marime - 1] = -1;
    }

    // 3.
    public static Boolean toatePare(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    // 4.
    public static Boolean existaPar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                return true;
            }
        }

        return false;
    }

    // 5.
    public static void bubbleSortAsc(int[] arr) {
        Boolean isSorted = false;
        int aux = 0;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                    isSorted = false;
                }
            }
        }
    }

    // 6.
    public static void selectionSortAsc(int[] arr) {
        int aux = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }

    // (n - 1) + (n - 2) + (n - 3) + ... + 2 + 1         (n - 1)n / 2 = (n ** 2 / 2) - (n / 2) -> O(n)

    // 7. 
    public static void insertionSortAsc(int[] arr) {
        int aux = 0;
        int index = 0;

        for (int i = 1; i < arr.length; i++) {
            index = i;
            while (index > 0 && arr[index] < arr[index - 1]) {
                aux = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = aux;
                index--;
            }
        }
    }

    // 8.
    public static ArrayList<Integer> mergeAsc(int[] arrOne, int[] arrTwo) {
        int counterOne = 0;
        int counterTwo = 0;
        ArrayList<Integer> rezultat = new ArrayList<>(); 

        while (counterOne < arrOne.length || counterTwo < arrTwo.length) {
            if (counterOne < arrOne.length && counterTwo < arrTwo.length) {
                if (arrOne[counterOne] > arrTwo[counterTwo]) {
                    rezultat.add(arrTwo[counterTwo]);
                    counterTwo++;
                } else {
                    rezultat.add(arrOne[counterOne]);
                    counterOne++;
                }
            } else if (counterOne < arrOne.length) {
                rezultat.add(arrOne[counterOne]);
                counterOne++;
            } else if (counterTwo < arrTwo.length) {
                rezultat.add(arrTwo[counterTwo]);
                counterTwo++;
            }
        }

        return rezultat;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        // int marime = 4;

        // 1.
        // inserare(arr, 2, 7, marime);
        // marime++;
        // System.out.println(Arrays.toString(arr));

        // 2.
        // stergere(arr, 1, marime);
        // System.out.println(Arrays.toString(arr));

        // 3.
        // Boolean toatePare = toatePare(arr);
        // System.out.println(toatePare);

        // 4.
        // Boolean existaPar = existaPar(arr);
        // System.out.println(existaPar);

        // 5.
        int[] array = { 1, 3, 6, 2, 99, 7 };
        // bubbleSortAsc(array);
        // System.out.println(Arrays.toString(array));

        // 6.
        // selectionSortAsc(array);
        // System.out.println(Arrays.toString(array));

        // 7.
        // insertionSortAsc(array);
        // System.out.println(Arrays.toString(array));

        // 8.
        int[] arrOne = {1, 7, 15};
        int[] arrTwo = {2, 5, 25};
        ArrayList<Integer> rezultat = mergeAsc(arrOne, arrTwo);
        System.out.println(rezultat);

    }
}
