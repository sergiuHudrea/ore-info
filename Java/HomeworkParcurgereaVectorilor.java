import java.util.ArrayList;
import java.util.Arrays;

class HomeworkParcurgereaVectorilor {

    // 1. https://www.pbinfo.ro/probleme/278/maxmin1
    public static Integer sir11(int[] arrOne, int[] arrTwo) {
       int counter = 0;
       Boolean toggle = false;
       
       for (int i = 0; i < arrOne.length; i++) {
           toggle = true;
           for (int j = 0; j < arrTwo.length; j++) {
               if (arrTwo[j] >= arrOne[i]) {
                   toggle = false;
               }
           }
           
           if (toggle) {
               counter++;
           }
       }
       
       return counter;
    }
    
    // 2. https://www.pbinfo.ro/probleme/4383/inlocuire6
    public static boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}

		for (int i = 2; i <= (n / 2); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
    
    public static void inlocuire6(int[] arr) {
        int lastPrimeIndex = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                lastPrimeIndex = i;
            }
        }
        
        arr[lastPrimeIndex] = 0;
    }
    
    // 3. https://www.pbinfo.ro/probleme/633/paritate1
    public static int paritate1(int[] arr) {
        int nrPare = 0;
        int nrImpare = 0;
        
        for (int i = 0; i< arr.length; i++) {
            if (arr[i] % 2 == 0) {
                nrPare++;
            } else {
                nrImpare++;
            }
        }
        
        if (nrPare > nrImpare) {
            return nrPare - nrImpare;
        } else {
            return nrImpare - nrPare;
        }
    }
    
    // 4. https://www.pbinfo.ro/probleme/4105/numararediv
    public static Integer countDividers(int n) {
		int counter = 0;
		
		for (int i = 1; i < (int)Math.sqrt(n); i++) {
			if (n % i == 0) {
				counter += 2;
			}
		}

		if (n % (int)Math.sqrt(n) == 0) {
			counter++;
		}
		
		return counter;
	}
    
    public static int numarareDiv(int[] arr) {
        int counter = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (countDividers(arr[i]) == countDividers(arr[j])) {
                    counter++;
                }
            }
        }
        return counter;
    }
    
    // 5. https://www.pbinfo.ro/probleme/2220/difmax
    public static int difMax(int[] arr) {
        int difMax = 0;
        int dif = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                dif = arr[i] - arr[j];
                if (dif > difMax) {
                    difMax = dif;
                }
            }
        }
        return difMax;
    }
    


    public static void main(String[] args) {
        
        // 1.
        // int[] arrOne = {7, 8, 10, 1, 9};
        // int[] arrTwo = {1, 3, 6, 2, 7, 3};
        // int result = sir11(arrOne, arrTwo);
        // System.out.println(result);
        
        // 2.
        // int[] arr = new int[5];
        // arr[0] = 7;
        // arr[1] = 4;
        // arr[2] = 9;
        // arr[3] = 6;
        // arr[4] = 2;
        // inlocuire6(arr);
        // System.out.println(Arrays.toString(arr));
        
        // 3.
        // int[] arr = {15, 245, 28, 33, 11};
        // int result = paritate1(arr);
        // System.out.println(result);
        
        // 4.
        // int[] arr = {13, 3, 8, 7, 9, 25};
        // int result = numarareDiv(arr);
        // System.out.println(result);
        
        // 5.
        // int[] arr = {3, 5, 2, 7, 6, 3, 9, 8};
        // int result = difMax(arr);
        // System.out.println(result);
        
    }
}