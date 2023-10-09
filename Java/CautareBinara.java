public class CautareBinara {
    public static int cautareBin(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        int mid = arr.length / 2;

        while (right >= left) {
            if (arr[mid] == val) {
                return mid;
            } else if (val > arr[mid]) {
                left = mid;
                mid = (left + right) / 2;
            } else if (val < arr[mid]) {
                right = mid;
                mid = (left + right) / 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int index = cautareBin(arr, 9);
        System.out.println(index);

    }
}
