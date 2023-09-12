class Fibonacci {

    // 1.
    public static void kFibonacci(int k) {
        int a = 0;
        int b = 1;
        int aux = 0;

        if (k == 1) {
            System.out.println(0);
            return;
        } else if (k == 2) {
            System.out.println(0);
            System.out.println(1);
            return;
        } 

        System.out.println(0);
        while (k > 1) {
            System.out.println(b);
            aux = b;
            b = a + b;
            a = aux;
            k--;
        }
    }



    // 2. https://www.pbinfo.ro/probleme/256/fiboverif
    public static boolean isFibo(int n) {
        int a = 0;
        int b = 1;
        int aux = 0;

        if (n == 0) {
            return true;
        } else if (n == 1) {
            return true;
        }

        while (b < n) {
            aux = b;
            b = a + b;
            a = aux;
            if (n == b) {
                return true;
            }
        }
        return false;
        
    }

    public static void fiboVerif(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isFibo(arr[i])) {
                System.out.println("DA");
            } else {
                System.out.println("NU");
            }
        }
    }

    // 3. https://www.pbinfo.ro/probleme/423/fibonacci1
    public static void fibonacci1(int n) {
        int a = 0;
        int b = 1;
        int aux = 0;

        if (n == 0) {
            System.out.println(0);
            return;
        } else if (n == 1) {
            System.out.println(0);
            System.out.println(1);
            System.out.println(1);
            return;
        }

        System.out.println(0);
        while (true) {
            System.out.println(b);
            aux = b;
            b = a + b;
            a = aux;
            if (b > n) {
                return;
            }
        }
    }

    // 4. https://www.pbinfo.ro/probleme/257/fibosum
    public static void fiboSum(int n) {
        int aux = n - 1;

        while (n > 0) {
            if (isFibo(aux) & ((n - aux) >= 0)){
                n -= aux;
                System.out.println(aux);
                aux++;
            }
            aux--;
        }
    }

    // 5. https://www.pbinfo.ro/probleme/3176/fibo0
    public static int fiboZero(int[] arr) {
        
    }


    public static void main(String[] args) {
        
        // 1.
        // int n = 10;
        // kFibonacci(n);

        // 2.
        // int[] arr = {13, 1, 8, 24, 21, 55, 47, 8};
        // fiboVerif(arr);

        // 3.
        // int n = 40;
        // fibonacci1(n);

        // 4.
        // int n = 30;
        // fiboSum(n);

    }
}