//import java.util.ArrayList;

class MinMax {

// 1. Să se scrie un program care citește un șir de n numere naturale şi determină cele mai mari două numere din şir.
    static class TwoMax {
        public int maxA;
        public int maxB;
    }

    public static TwoMax maxTwo(int[] arr) {
        TwoMax twoMax = new TwoMax();

        int maxA;
        int maxB;
        int incrementator = 2;
        if (arr[0] < arr[1]) {
            maxA = arr[1];
            maxB = arr[0];
        } else if (arr[0] > arr[1]) {
            maxA = arr[0];
            maxB = arr[1];
        } else {
            while (arr[incrementator] == arr[0] & incrementator < arr.length) {
                incrementator++;
            }
            if (arr[0] > arr[incrementator]) {
                maxA = arr[0];
                maxB = arr[incrementator]; 
            } else {
                maxA = arr[incrementator];
                maxB = arr[0];
            }
        }


        for (int i = incrementator; i < arr.length; i++) {
            if (arr[i] > maxA) {
                maxB = maxA;
                maxA = arr[i];
            } else if (arr[i] < maxA && arr[i] > maxB) {
                maxB = arr[i];
            }
        }

        twoMax.maxA = maxA;
        twoMax.maxB = maxB;

        return twoMax;
    }



    // 2. Se dau n numere naturale. Determinaţi cele mai mari trei numere dintre cele date.
    static class ThreeMax {
        public int maxA;
        public int maxB;
        public int maxC;
    }
    public static ThreeMax maxThree(int[] arr) {
        ThreeMax threeMax = new ThreeMax();
        TwoMax twoMax = maxTwo(arr);

        int maxA = twoMax.maxA;
        int maxB = twoMax.maxB;
        int maxC = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != maxA & arr[i] != maxB) {
                maxC = arr[i];
                break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
             if (arr[i] != maxA & arr[i] != maxB & arr[i] > maxC) {
                maxC = arr[i];
             }
        }

        threeMax.maxA = maxA;
        threeMax.maxB = maxB;
        threeMax.maxC = maxC;

        return threeMax;
    }





    // 3. Să se scrie un program care citește un șir de n numere naturale şi determină perechea de valori consecutive în șir pentru care valoarea absolută a diferenței este minimă. 
    //    Dacă există mai multe astfel de perechi se va afișa cea pentru care suma este minimă. 
    //    Dacă există mai multe perechi de acest fel se va afișa prima pereche din șir.

    static class DifMinCouple {
        public int a;
        public int b;
    }
    public static DifMinCouple difMin(int[] arr) {
        DifMinCouple difMinCouple = new DifMinCouple();

        int a = 0;
        int b = 0;
        int difMin;
        
        if (arr[0] > arr[1]) {
            difMin = arr[0] - arr[1];
        } else {
            difMin = arr[1] - arr[0];
        }

        for (int i = 0; i < arr.length - 1; i ++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    if (arr[i] - arr[j] < difMin) {
                        difMin = arr[i] - arr[j];
                        a = arr[i];
                        b = arr[j];
                    }
                } else {
                    if (arr[j] - arr[i] < difMin) {
                        difMin = arr[j] - arr[i];
                        a = arr[i];
                        b = arr[j];
                    }
                }
            }
        }

        difMinCouple.a = a;
        difMinCouple.b = b;

        return difMinCouple;
    }


    // 4. Să se determine numărul de ordine al perechii cu grad de disproporționalitate minim.
    // Dacă există mai multe perechi cu grad minim de disproporționalitate, se va afișa numărul de ordine al ultimei perechi.
    public static int perechi1(int[] arr) {
        int indexPereche = 0;
        int gradDisp;
        int index = 0;

        if (arr[0] > arr[1]) {
            gradDisp = arr[0] - arr[1];
        } else {
            gradDisp = arr[1] - arr[0];
        }

        for (int i = 0; i < arr.length - 1; i += 2) {
            index++;
            if (arr[i] > arr[i + 1]) {
                if (arr[i] - arr[i + 1] <= gradDisp) {
                    indexPereche = index;
                    gradDisp = arr[i] - arr[i + 1];
                }
            } else {
                if (arr[i + 1] - arr[i] <= gradDisp) {
                    indexPereche = index;
                    gradDisp = arr[i + 1] - arr[i];
                }
            }
        }

        return indexPereche;
    }


    
    // 5. https://www.pbinfo.ro/probleme/358/plopi
    static class InfoPlopi {
        public int difMax;
        public int nrPerechi;
    }
    public static InfoPlopi plopi(int[] arr) {
        InfoPlopi infoPlopi = new InfoPlopi();
        int difMax = 0;
        int nrPerechi = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] - arr[i + 1] > difMax) {
                    difMax = arr[i] - arr[i + 1];
                }
            } else {
                if (arr[i + 1] - arr[i] > difMax) {
                    difMax = arr[i + 1] - arr[i];
                }
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] - arr[i + 1] == difMax) {
                    nrPerechi++;
                }
            } else {
                if (arr[i + 1] - arr[i] == difMax) {
                    nrPerechi++;
                }
            }
        }

        infoPlopi.difMax = difMax;
        infoPlopi.nrPerechi = nrPerechi;

        return infoPlopi;
    }



    public static void main(String[]  args) {
        // 1.
        // int[] arr = {72, 30, 12, 75, 17};
        // TwoMax twoMax = maxTwo(arr);
        // System.out.println(twoMax.maxA);
        // System.out.println(twoMax.maxB);

        // 2.
        // int[] arr2 = {72, 30, 12, 75, 17};
        // ThreeMax threeMax = maxThree(arr2);
        // System.out.println(threeMax.maxA);
        // System.out.println(threeMax.maxB);
        // System.out.println(threeMax.maxC);

        // 3.
        // int[] arr3 = {72, 30, 12, 165, 725};
        // DifMinCouple difMinCouple = difMin(arr3);
        // System.out.println(difMinCouple.a);
        // System.out.println(difMinCouple.b);

        // 4.
        // int[] arr4 = {7, 9, 6, 7, 8, 12, 11, 10, 10, 6, 11, 13};
        // int indexPerechi = perechi1(arr4);
        // System.out.println(indexPerechi);

        // 5. 
        // int[] arr5 = {5, 3, 7, 4, 6, 2, 6};
        // InfoPlopi infoPlopi = plopi(arr5);
        // System.out.println(infoPlopi.difMax);
        // System.out.println(infoPlopi.nrPerechi);
    }
}