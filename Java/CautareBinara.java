public class CautareBinara {
    public static int cautareBin(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (right >= left) {
            mid = (left + right) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (val > arr[mid]) {
                left = mid + 1;
            } else if (val < arr[mid]) {
                right = mid - 1;
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
