

public class VectoriCaracteristiciSiDeFrecventa {
    // 1.
    public static void VectorCaracteristic (int[] arr, int max) {
        int[] vectorCara = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            vectorCara[arr[i]] = 1; 
        }

        for (int j = 0; j < vectorCara.length; j++) {
            if (vectorCara[j] == 1) {
                System.out.println(j);
            }
        }
    } 

    // 2.
    public static void VectorCaracteristicInterval (int[] arr, int m, int n) {
        int[] vectorCara = new int[n - m + 1];

        for (int i = 0; i < arr.length; i++) {
            vectorCara[arr[i] - m] = 1;
        }

        for (int j = 0; j < vectorCara.length; j++) {
            if (vectorCara[j] == 1) {
                System.out.println(j + m);
            }
        }

    }

    // 3.
    public static void VectorFrecventaInterval (int[] arr, int m, int n) {
        int[] vectorFrec = new int[n - m + 1];

        for (int i = 0; i < arr.length; i++) {
            vectorFrec[arr[i] - m]++;
        }

        for (int j = 0; j < vectorFrec.length; j++) {
            if (vectorFrec[j] > 0) {
                System.out.println("apparitii = " + vectorFrec[j] + " v = " + (j + m));
            }
        }

    }

    // 4. CIURUL LUI ERATOSTENE
    public static void CiurulLuiEratostene(int n) {
        int[] vectorPrime = new int[n + 1];

        vectorPrime[0] = 1;
        vectorPrime[1] = 1;

        for (int i = 2; i <= Math.sqrt((double)n); i++) {
            if (vectorPrime[i] == 0) {
                for (int j = i; j * i <= n; j++) {
                    vectorPrime[j * i] = 1;
                }
            }
        }

        for (int k = 0; k < vectorPrime.length; k++) {
            if (vectorPrime[k] == 0) {
                System.out.println(k);
            }
        }
    }

    public static void CiurulNumarDiv(int n) {
        int[] vectorDiv = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            vectorDiv[i]++;
        }
        
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; i * j <=n; j++) {
                vectorDiv[j * i]++;
            }
        }

        for (int k = 0; k < vectorDiv.length; k++) {
            System.out.println("nrDiv = " + vectorDiv[k] + " nr = " + (k));
        }
    }

    // 6.
    public static void CiurCelMaiMicDivPrim(int n) {
        int[] vectorCelMaiMicDivPrim = new int[n + 1];

        for (int j = 0; j < vectorCelMaiMicDivPrim.length; j++) {
            vectorCelMaiMicDivPrim[j] = j;
        }

        for (int i = 2; i <= Math.sqrt((double)n); i++) {
            if (vectorCelMaiMicDivPrim[i] == i) {
                for (int j = 2; i * j <= n; j++) {
                    if (vectorCelMaiMicDivPrim[j * i] == j * i) {
                    vectorCelMaiMicDivPrim[j * i] = i;
                    }
                }
            } 
        }

         for (int j = 0; j < vectorCelMaiMicDivPrim.length; j++) {
            System.out.println(vectorCelMaiMicDivPrim[j]);
        }

    }

    // 7.
    public static void CiurCelMaiMareDivPrim(int n) {
        int[] vectorCelMaiMareDivPrim = new int[n + 1];

        for (int j = 0; j < vectorCelMaiMareDivPrim.length; j++) {
            vectorCelMaiMareDivPrim[j] = j;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (vectorCelMaiMareDivPrim[i] == i) {
                for (int j = 2; i * j <= n; j++) {
                vectorCelMaiMareDivPrim[j * i] = i;
                }
            } 
        }

         for (int j = 0; j < vectorCelMaiMareDivPrim.length; j++) {
            System.out.println(vectorCelMaiMareDivPrim[j]);
        }

    }


    public static void main(String[] args) {
        // 1.
        // int[] arr = {1, 2, 4, 5, 9, 0};
        // int max = 9;
        // VectorCaracteristic(arr, max);

        // 2.
        // int[] arr = {7, 8, 7, 5, 9, 10};
        // int m = 5;
        // int n = 10;
        // VectorCaracteristicInterval(arr, m, n);

        // 3.
        //  int[] arr = {7, 8, 7, 5, 9, 10};
        // int m = 5;
        // int n = 10;
        // VectorFrecventaInterval(arr, m, n);

        // 4.
        // int n = 20;
        // CiurulLuiEratostene(n);

        // 5.
        // int n = 20;
        // CiurulNumarDiv(n);

        // 6.
        // int n = 20;
        // CiurCelMaiMicDivPrim(n);

        // 7.
        int n = 20;
        CiurCelMaiMareDivPrim(n);
    }
}
