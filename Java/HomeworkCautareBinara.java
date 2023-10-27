public class HomeworkCautareBinara {
    
    // 1. https://www.pbinfo.ro/probleme/508/cautare-binara
    public static void cautareBinara(int[] arrOne, int[] arrTwo) {
        int left = 0;
        int right = 0;
        int mid = 0;
        int val = 0;
        int res = 0;

        for (int i = 0; i < arrTwo.length; i++) {
            left = 0;
            right = arrOne.length - 1;
            val = arrTwo[i];
            res = 0;
            
            while (right >= left) {
                mid = (left + right) / 2;
                if (arrOne[mid] == val) { 
                    res = 1;
                    break;
                } else if (val > arrOne[mid]) {
                    left = mid + 1;
                } else if (val < arrOne[mid]) {
                    right = mid - 1;
                }
            }
            System.out.println(res);
        }
    }
    
    // 2. https://www.pbinfo.ro/probleme/2644/clase
    public static int clase(int[] arrOne, int[] arrTwo) {
        int left = 0;
        int right = 0;
        int mid = 0;
        
        int val = 0;
        int contor = 0;
        
        for (int i = 0; i < arrTwo.length; i++) {
            left = 0;
            right = arrOne.length - 1;
            val = arrTwo[i];
            
            while (right >= left) {
                mid = (left + right) / 2;
                if (arrOne[mid] == val) {
                    contor++;
                    break;
                } else if (val > arrOne[mid]) {
                    left = mid + 1;
                } else if (val < arrOne[mid]) {
                    right = mid - 1;
                }
            }
        }
        
        return contor;
    }
    
    // 3. https://www.pbinfo.ro/probleme/2276/cb
    public static void cb(int[] arrBaza, int[][] arrIntervale) {
        int from = 0;
        int to = 0;
        int contor = 0;
        int mid = 0;
        
        for (int i = 0; i < arrIntervale.length; i++) {
            contor = 0;
            
            for (int k = 0; k < arrBaza.length; k++) {
                from = arrIntervale[i][0];
                to = arrIntervale[i][1];
                while (from <= to) {
                    mid = (from + to) / 2;
                    if (mid == arrBaza[k]) {
                        contor++;
                        break;
                    } else if (arrBaza[k] > mid) {
                        from = mid + 1;
                    } else if (arrBaza[k] < mid) {
                        to = mid - 1;
                    }
                }
            }
            System.out.println(contor);
        }
    }
    
    // 4. https://www.pbinfo.ro/probleme/2239/pow2
    public static int powTwo(int[] arr, int[] arrPuteri) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int mid = 0;
        int contor = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                left = 0;
                right = arrPuteri.length - 1;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (sum == arrPuteri[mid]) {
                        contor++;
                        break;
                    } else if (sum < arrPuteri[mid]) {
                        right = mid - 1;
                    } else if (sum > arrPuteri[mid]) {
                        left = mid + 1;
                    }
                }
                
            }
        }
        return contor;
    }
    
    
    // 5. https://www.pbinfo.ro/probleme/2443/cb2
    public static void cbTwo(int[] arrBaza, int[][] arrIntrebari) {
        int thanNumber = 0;
        int thanSum = 0;
        int sum = 0;
        int contor = 0;
        
        for (int i = 0; i < arrIntrebari.length; i++) {
            thanNumber = arrIntrebari[i][0];
            thanSum = arrIntrebari[i][1];
            sum = 0;
            contor = 0;
            
            for (int k = 0; k < arrBaza.length; k++) {
                sum += arrBaza[k];
                if (arrBaza[k] > thanNumber || sum > thanSum) {
                    break;
                }
                contor++;
            }
            System.out.println(contor);
        }
    }
  

    public static void main(String[] args) {
        // 1.
        // int[] arrOne = {1, 2, 5, 6, 9, 10, 14};
        // int[] arrTwo = {8, 14, 9, 14, 16, 15, 4, 2};

        // cautareBinara(arrOne, arrTwo);

        // 2.
        // int[] arrOne = {16, 17, 20, 24, 30};
        // int[] arrTwo = {78, 20, 17, 74};
        // System.out.println(clase(arrOne, arrTwo));
        
        // 3.
        // int[] arrBaza = {6, 1, 3, 5, 3, 3, 9, 20, 9};
        // int[][] arrIntervale = { {4, 10}, {0, 100}, {0, 1}, {500, 506}, {3, 3}, {10, 18}, {3, 9} };
        
        // cb(arrBaza, arrIntervale);
        
        // 4,
        // int[] arrPuteri = {1, 2, 4, 8, 16, 32, 64, 128, 256};
        // int[] arr = {3, 5, 3, 13};
        // System.out.println(powTwo(arr, arrPuteri));

        // 5.
        int[] arrBaza = {5, 3, 1, 7, 4, 9, 8, 2, 6};
        int[][] arrIntrebari = {{8, 10}, {4, 20}, {6, 20}, {6, 8}, {10, 100}, {10, 20}};
        
        cbTwo(arrBaza, arrIntrebari);
    }
}
