public class HomeworkVectoriCaracteristiciSiDeFrecventa {

    // 1. https://www.pbinfo.ro/probleme/1005/numere8
    public static void numereOpt(int[] arr) {
        int[] vectorCara = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            vectorCara[arr[i]] = 1;
        }

        for (int j = 1; j < vectorCara.length; j++) {
            if (vectorCara[j] != 1) {
                System.out.println(j);
            }
        }
    }

    // 2. https://www.pbinfo.ro/probleme/525/numere1
    public static void numereUnu(int[] arr) {
        int[] vectorCara = new int[900];
        int contor = 0;
        int f = 0;
        int s = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 99 && arr[i] < 1000) {
                vectorCara[arr[i] - 100] = 1;
            }

        }

        for (int j = vectorCara.length - 1; j >= 100; j--) {
            if (vectorCara[j] != 1 && contor < 2) {
                if (f == 0) {
                    f = j;
                } else {
                    s = j;
                }
                contor++;
            }
        }
        if (contor == 0) {
            System.out.println("NU EXISTA");
        }

        System.out.println(s + 100);
        System.out.println(f + 100);
    }

    // 3. https://www.pbinfo.ro/probleme/529/cifre4
    public static void cifrePatru(int[] arr) {
        int[] vectorFrecv = new int[10];
        int[] vectorCara = new int[10];

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                vectorFrecv[arr[i] % 10]++;
                arr[i] /= 10;
            }
        }

        for (int i = 0; i < vectorFrecv.length; i++) {
            if (vectorFrecv[i] == 0) {
                vectorCara[i] = 1;
            }
        }

        for (int k = 0; k < vectorFrecv.length; k++) {
            int indexMin = 0;

            while (indexMin < vectorCara.length && vectorCara[indexMin] == 1) {
                indexMin++;
            }

            if (indexMin < vectorCara.length) {
                int valMin = vectorFrecv[indexMin];

                for (int l = 0; l < vectorFrecv.length; l++) {
                    if (vectorFrecv[l] < valMin && vectorCara[l] == 0) {
                        indexMin = l;
                        valMin = vectorFrecv[indexMin];
                    }
                }

                System.out.println(indexMin);
                vectorCara[indexMin] = 1;
            }

        }
    }

    // 4. https://www.pbinfo.ro/probleme/239/nrlipsa
    public static void nrLipsa(int[] arr) {
        int[] vectorCara = new int[900];
        int contor = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 99 && arr[i] < 1000) {
                vectorCara[arr[i] - 100] = 1;
            }
        }

        for (int j = vectorCara.length - 1; j >= 100; j--) {
            if (vectorCara[j] != 1 && contor < 2) {
                System.out.println(j + 100);
                contor++;
            }
        }
    }

    // 5. https://www.pbinfo.ro/probleme/247/cifreord1
    public static void cifreOrdUnu(int[] arr) {
        int[] vectorFrecv = new int[10];

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                vectorFrecv[arr[i] % 10]++;
                arr[i] /= 10;
            }
        }

        for (int j = vectorFrecv.length - 1; j >= 0; j--) {
            for (int k = 0; k < vectorFrecv[j]; k++) {
                System.out.println(j);
            }
        }
    }

    public static void main(String[] args) {
        // 1.
        // int[] arr = {107, 4, 5, 8, 1, 6, 9};
        // numereOpt(arr);

        // 2.
        // int[] arr = {10, 994, 1010, 999, 1010, 998, 1005, 994, 996, 995 };
        // numereUnu(arr);

        // 3.
        int[] arr = { 124, 229, 1322, 4, 534 };
        cifrePatru(arr);

        // 4.
        // int[] arr = {2345, 123, 67, 989, 6, 999, 123, 67, 989, 999};
        // nrLipsa(arr);

        // 5.
        // int[] arr = {301941, 81912, 83392, 776996, 431446};
        // cifreOrdUnu(arr);
    }
}
