public class DifferenceArrays {
    public static void update(int left, int right, int value, int[] d) {
        d[left] += value;
        d[right + 1] -= value;
    }

    public static void print(int[] a, int[] d) {
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                a[i]= d[i];
            } else {
                a[i] = d[i] + a[i - 1];
            }

            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 3, 12, 4, 9};
        int[] d = new int[a.length + 1];

        d[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            d[i] = a[i] - a[i - 1];
        }

        update(0, 1, 10, d);
        update(1, 3, 20, d);

        print(a, d);
    }
}
