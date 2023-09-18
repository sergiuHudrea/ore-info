
import java.lang.Math;
// import java.util.ArrayList;

class HomeworkDigitsOfANumber {
    
    // 1. https://www.pbinfo.ro/probleme/4018/moscraciun3
    public static int mosCraciun3(int nr, int b, int e) {
        int nrCifre = nrCifre(nr);
        int left = 0;
        int right = 0;
        int mid = 0;
        int lengthMid = 0;
        int newNr;
        
        for (int i = 0; i < b; i++) {
            left += ((nr / (int)Math.pow(10, (nrCifre - b + i))) % 10) * Math.pow(10, (b - i - 1));
        }
        left *= Math.pow(10, (nrCifre - b));
        
        for (int i = 0; i < e; i++) {
            right += ((nr / (int)Math.pow(10, i)) % 10) * (int)Math.pow(10, (e - i - 1));
        }
        
        lengthMid = nrCifre - (b + e);
        mid = (nr / (int)Math.pow(10, e)) % (int)Math.pow(10, lengthMid) * (int)Math.pow(10, e);
        
        newNr = left + mid + right;

        return newNr;
    }

    // 2. https://www.pbinfo.ro/probleme/3251/asociat-par
    // I WANT TO USE IT FROM THE OTHER CLASS
    public static int nrCifre(int n) {
        int nrCifre = 0;
	    int aux = n;
	    while (aux > 0) {
	        nrCifre += 1;
	        aux /= 10;
	    }

        return nrCifre;
    }

    public static boolean isPalindrome(int n) {
	    int nrCifre = nrCifre(n);
	    
	    int bModulo = 10;
        int bDivider = 1;

        int fPower = nrCifre - 1;

        for (int i = 0; i < nrCifre / 2; i++) {
            int backDigit = (n % bModulo) / bDivider;
            int frontDigit = (n / (int)Math.pow(10, fPower)) % 10;

            if (backDigit != frontDigit) {
                return false;
            }
        }
	    
        return true;
	    
	}

    public static int asociatPar(int[] arr) {
        int nrPal = 0;

        for (int i = 0; i < arr.length; i++) {
            int asociatPar = 0;
            int pow = 0;
            while (arr[i] > 0) {
                if ((arr[i] % 10) % 2 == 0) {
                    asociatPar += (arr[i] % 10) * (int)Math.pow(10, pow);
                    pow++;
                    
                }
                arr[i] /= 10;
            }
            if (asociatPar > 0 & isPalindrome(asociatPar)) {
                nrPal++;
            }
        }

        return nrPal;
    }

    // 3. https://www.pbinfo.ro/probleme/2687/ultimacifraprimacifra
    public static int primaCifra(int nr) {
        int primaCifra  = 0;
        while (nr > 0) {
            if (nr / 10 < 1) {
                primaCifra = nr ;
            }
            nr /= 10;
        }

        return primaCifra;
    }
    public static void ultimaCifraPrimaCifra(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (primaCifra(arr[i + 1]) == arr[i] % 10) {
                System.out.println(arr[i]);
                System.out.println(arr[i + 1]);
            }
        }
    }


    // 4. https://www.pbinfo.ro/probleme/3927/cmmnr
    public static int cmmnr(int n) {
        int aux = n;
        int nrMin = n % 10;
        int newNr = 0;
        int power = 0;
        int contor = 0;

        while (aux > 0) {
            if ((aux % 10) < nrMin) {
                nrMin = aux % 10;
                contor = 1;
            } else if ((aux % 10) == nrMin) {
                contor++;
            }
            aux /= 10;
        }

        while (n > 0) {
            if (n % 10 == nrMin) {
                if (contor == 1) {
                    n /= 10;
                } 
                contor--; 
            }
            newNr = newNr + (n % 10) * (int)Math.pow(10, power);
            power++;
            n /= 10;
        }

        return newNr;
    }


    // 5. https://www.pbinfo.ro/probleme/1582/max-min
    static class MinMax {
        public int min;
        public int max;
    }
    public static int sumaCifra(int n) {
        int suma = 0;
        while (n > 0) {
            suma += n % 10;
            n /= 10;
        }

        return suma;

    }
    public static MinMax minMaxSum(int[] arr) {
        MinMax minMax = new MinMax();
        int sumMin;
        int sumMax;
        int max = arr[0];
        int min = arr[0];
     
        sumMin = sumMax = sumaCifra(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            if (sumaCifra(arr[i]) > sumMax) {
                max = arr[i];
                sumMax = sumaCifra(arr[i]);
            } else if (sumaCifra(arr[i]) < sumMin) {
                min = arr[i];
                sumMin = sumaCifra(arr[i]);
            }
        }

        minMax.max = max;
        minMax.min = min;

        return minMax;

    }
    
    public static void main(String[] args) {
        
        // 1.
        int cod = mosCraciun3(1428429, 2, 3);
        System.out.println(cod);
        
        // 2.
        // int[] arr2 = {45456, 474, 201102, 2352345, 234};
        // int nrPal = asociatPar(arr2);
        // System.out.println(nrPal);

        // 3.
        // int[] arr3 = {12, 213, 214, 412, 212};
        // ultimaCifraPrimaCifra(arr3);

        // 4.
        // int n = 4182;
        // System.out.println(cmmnr(n));
        // int n2 = 1234;
        // System.out.println(cmmnr(n2));
        // int n3 = 12314;
        // System.out.println(cmmnr(n3));


        // 5.
        // int[] arr4 = {145, 225, 198, 326, 874};
        // MinMax minMax = minMaxSum(arr4);
        // System.out.println(minMax.min);
        // System.out.println(minMax.max);
    }
}