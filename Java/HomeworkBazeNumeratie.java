import java.lang.Math;
import java.util.AbstractMap;
import java.util.Map;
import java.util.ArrayList;

class HomeworkBazeNumeratie {

    // 1. https://www.pbinfo.ro/probleme/429/cifbin
     public static int baseTenToBaseTwo(int nr) {
        int baseTwo = 0;
        int pwr = 0;
        while (nr > 0) {
            baseTwo += Math.pow(10, pwr) * (nr % 2);
            nr /= 2;
            pwr++;
        }

        return baseTwo;
    }
    
    public static ArrayList<Integer> cifBin(int nr) {
        int baseTwo = baseTenToBaseTwo(nr);
        ArrayList<Integer> zeroesAndOnes = new ArrayList<>();
        int zeroes = 0;
        int ones = 0;
        
        
        while (baseTwo > 0) {
            if (baseTwo % 10 == 0) {
                zeroes++;
            } else {
                ones++;
            }
            
            baseTwo /= 10;
        }
        
        zeroesAndOnes.add(zeroes);
        zeroesAndOnes.add(ones);
        return zeroesAndOnes;
    }

    // 2. https://www.pbinfo.ro/probleme/122/cifrebinare
    public static int nrOfOnes(int nr) {
        int ones = 0;
        
        while (nr > 0) {
            if (nr % 10 == 1) {
                ones++;
            }
            nr /= 10;
        }
        
        return ones;
    }
    
    public static int cifreBinare(int a, int b) {
        int baseTwoA = baseTenToBaseTwo(a);
        int baseTwoB = baseTenToBaseTwo(b);
        
        int onesA = nrOfOnes(baseTwoA);
        int onesB = nrOfOnes(baseTwoB);
        
        if (onesA > onesB) {
            return a;
        } else if (onesA == onesB) {
            if (a > b) {
                return a;
            }
                return b;
        } else {
            return b;
        }
    }
    
    // 3. https://www.pbinfo.ro/probleme/427/bazaminima
    public static int bazaMinima(int[] arr) {
        int bazaMin = 0;
        
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (arr[i] % 10 > bazaMin) {
                    bazaMin = arr[i] % 10;
                }
                arr[i] /= 10;
            }
        }
        bazaMin++;
        return bazaMin;
    }
    
    // 4. https://www.pbinfo.ro/probleme/428/transfb
    public static int transfB(int b, int[] arr) {
        int pwr = 0;
        int baseTen = 0;
        
        for (int i = arr.length - 1; i >= 0; i--) {
            baseTen += Math.pow(b, pwr) * arr[i];
            pwr++;
        }
        
        return baseTen;
    }
    
    // 5. https://www.pbinfo.ro/probleme/945/baze
    
    public static int baze(int[] arr, int fromB, int toB) {
        int pwr = 0;
        int baseTen = transfB(fromB, arr);
        int newBase = 0;
        
        while (baseTen > 0) {
            newBase += Math.pow(10, pwr) * (baseTen % toB);
            baseTen /= toB;
            pwr++;
        }
        
        return newBase;
    }
    
    // 6. https://www.pbinfo.ro/probleme/426/bazab
    public static int baseTenToBaseN(int nr, int newB) {
        int baseN = 0;
        int pwr = 0;
        while (nr > 0) {
            baseN += Math.pow(10, pwr) * (nr % newB);
            nr /= newB;
            pwr++;
        }

        return baseN;
    }

    public static int bazaB(int n, int b) {
        int newNr = baseTenToBaseN(n, b);
        int biggestDig = 0;
        
        while (newNr > 0) {
            if (newNr % 10 > biggestDig) {
                biggestDig = newNr % 10;
            }
            newNr /= 10;
        }
        return biggestDig;
    }
   
   
   // 7. https://www.pbinfo.ro/probleme/1479/pretios
   public static int nrOfDigits(int n) {
       int digits = 0;
       
       while (n > 0) {
           digits++;
           n /= 10;
       }
       
       return digits;
   }
   
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
   
   public static int pretios(int[] arr) {
       int pretioase = 0;
       
       for (int i = 0; i < arr.length; i++) {
           int baseTwo = baseTenToBaseTwo(arr[i]);
           int nrOfDigits = nrOfDigits(baseTwo);
           boolean isPrime = isPrime(nrOfDigits);
           
           if (isPrime) {
               pretioase++;
           }
       }
       
       return pretioase;
   }

// 8.https://www.pbinfo.ro/probleme/946/douabaze
   public static int douaBaze(int baseTwo) {
       ArrayList<Integer> baseFourList = new ArrayList<>();
       int baseFour = 0;
       // 100011
       
       while (baseTwo > 0) {
            if (baseTwo / 10 < 1) {
               baseFourList.add(baseTwo % 10);
               baseTwo /= 10;
           } else {
               if (baseTwo % 100 == 0) {
                   baseFourList.add(0);
               } else {
                   baseFourList.add(baseTwo % 100);
               }
               
               baseTwo /= 100;
           }
       }
    
       
       for (int i = baseFourList.size() - 1; i >= 0; i--) {
           if (baseFourList.get(i) == 0) {
               baseFour += 0;
           } else if (baseFourList.get(i) == 1) {
               baseFour += 1;
           } else if (baseFourList.get(i) == 10) {
               baseFour += 2;
           } else if (baseFourList.get(i) == 11) {
               baseFour += 3;
           }
           
           if (i > 0) {
               baseFour *= 10;
           }
       }
       
       return baseFour;
   }
   
   
    // 9. https://www.pbinfo.ro/probleme/1300/hex
    public static ArrayList<Character> hex(int baseTwo) {
        Map<Integer, Character> map = Map.ofEntries(   
            new AbstractMap.SimpleEntry<Integer, Character>(1010, 'A'),   
            new AbstractMap.SimpleEntry<Integer, Character>(1011, 'B'),   
            new AbstractMap.SimpleEntry<Integer, Character>(1100, 'C'),   
            new AbstractMap.SimpleEntry<Integer, Character>(1101, 'D'),
            new AbstractMap.SimpleEntry<Integer, Character>(1110, 'E'),
            new AbstractMap.SimpleEntry<Integer, Character>(1111, 'F') 
            );

        ArrayList<Integer> baseSixteenList = new ArrayList<>();
        ArrayList<Character> baseSixteen = new ArrayList<>();
        Character myChar = 'A';
        
         while (baseTwo > 0) {
            if (baseTwo / 10 < 1) {
               baseSixteenList.add(baseTwo % 10);
               baseTwo /= 10;
           } else if (baseTwo / 100 < 1) {
               baseSixteenList.add(baseTwo % 100);
               baseTwo /= 100;
           } else if (baseTwo / 1000 < 1) {
               baseSixteenList.add(baseTwo % 1000);
               baseTwo /= 1000;
           } else {
               if (baseTwo % 10000 == 0) {
                   baseSixteenList.add(0);
               } else {
                   baseSixteenList.add(baseTwo % 10000);
               }
               
               baseTwo /= 10000;
           }
       }
       
       
       for (int i = baseSixteenList.size() - 1; i >= 0; i--) {
           int baseTwoNr = baseSixteenList.get(i);
           
           if (baseTwoNr == 0) {
               myChar = 0;
           } else if (baseTwoNr == 1) {
               myChar = (char)(1 + '0');
           } else if (baseTwoNr == 10) {
               myChar = (char)(2 + '0');
           } else if (baseTwoNr == 11) {
               myChar = (char)(3 + '0');
           } else if (baseTwoNr == 100) {
               myChar = (char)(4 + '0');
           } else if (baseTwoNr == 101) {
               myChar = (char)(5 + '0');
           } else if (baseTwoNr == 110) {
               myChar = (char)(6 + '0');
           } else if (baseTwoNr == 111) {
               myChar = (char)(7 + '0');
           } else if (baseTwoNr == 1000) {
               myChar = (char)(8 + '0');
           } else if (baseTwoNr == 1001) {
               myChar = (char)(9 + '0');
           } else {
               myChar = map.get(baseTwoNr);
           }
           
           baseSixteen.add(myChar);
       }
       
       return baseSixteen;
        
        
    }



    public static void main(String[] args) {
        
        // 1.
        // int baseTen = 174;
        // ArrayList<Integer> zeroesAndOnes = cifBin(baseTen);
        // System.out.println(zeroesAndOnes);
        
        // 2.
        // int a = 125;
        // int b = 1250;
        // int cifreBinare = cifreBinare(a, b);
        // System.out.println(cifreBinare);
        
        // 3.
        // int[] arr = {1524, 300024, 10001, 2034, 543201};
        // int nrBazMin = bazaMinima(arr);
        // System.out.println(nrBazMin);
     
        // 4.
        // int[] arr = {1, 0, 2, 2, 4, 1};
        // int baza = 5;
        // int transfB = transfB(baza, arr);
        // System.out.println(transfB);
        
        // 5.
        // int[] arr = {2, 0, 1, 3};
        // int base = baze(arr, 4, 7);
        // System.out.println(base);
        
        // 6.
        // int biggestDig = bazaB(878, 6);
        // System.out.println(biggestDig);
        
        // 7.
        // int[] arr = {1, 2, 3, 4};
        // int pretioase = pretios(arr);
        // System.out.println(pretioase);
        
        // 8.
        // int baseFour = douaBaze(1111010);
        // System.out.println(baseFour);
        
        // 9.
        ArrayList<Character> hex = hex(1100010111);
        System.out.println(hex);
    }
}