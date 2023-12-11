import java.util.List;

public class Recursivitate {
    public static int inmultitorul(int n) {
        if (n == 1) {
            return n;
        }

        return n * inmultitorul(n - 1);
    }


    // 0, 1, 1, 2, 3, 5, 8, 13, ...
    // f(0) = 0 si f(1) = 1
    // f(n) = f(n - 1) + f(n - 2)
    public static int fibo(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    // Tip: You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer.
    public static int productSum(List<Object> array) {
        // Write your code here.
        return -1;
    }

    public static int binarySearch(int[] arr, int val, int l, int r) {
        int mid = (l +  r) / 2;

        if (arr[mid] == val) {
            return mid;
        }

        if (l > r) {
            return -1;
        }

        if (val > arr[mid]) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }

        return binarySearch(arr, val, l, r);
    }


    // https://www.pbinfo.ro/probleme/4207/sumprodrec
    // n = 4
    // s = 4 * 3 + 3 * 2 + 2 * 1 = 20
    // n * (n - 1) + f(n - 1)
    public static int sumProdRec(int n) {
        if (n == 1) {
            return 0;
        }

        return n * (n - 1) + sumProdRec(n - 1);
    }


    // https://www.pbinfo.ro/probleme/823/sumcifrec
    public static int sumCifRec(int n) {
        if (n / 10 < 1) {
            return n;
        }

        return n % 10 + sumCifRec(n / 10);
    }

    public static void main(String[] args) {
        // System.out.println(inmultitorul(5));

        // System.out.println(fibo(6));

        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        // System.out.println(binarySearch(arr, 8, 0, arr.length - 1));

        
        // System.out.println(sumProdRec(2));

        System.out.println(sumCifRec(2050));
    }
}

