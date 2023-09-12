import java.util.ArrayList;
import java.lang.Math;

class DigitsOfANumber {
	// n = 12345 -> arr = [5, 4, 3, 2, 1]
	public static ArrayList<Integer> getDigitsReverse(int n) {
		ArrayList<Integer> digRevArr = new ArrayList<Integer>();
		
		while (n > 0) {
		    digRevArr.add(n % 10);
		    n /= 10;
		}
		
		return digRevArr;
	} 	
	
	public static int getMirrorNr(int n) {
	    int mirrored = 0;
	    
	    while (n > 0) {
	        mirrored += n % 10;
	        n /= 10;
	        if ( n > 0) {
	            mirrored *= 10;
	        }
	    }
	    
	    return mirrored;
	}
	
	public static boolean isPalindrome(int n) {
	    int nrCifre = 0;
	    int aux = n;
	    while (aux > 0) {
	        nrCifre += 1;
	        aux /= 10;
	    }
	    
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

	public static void main(String[] args) {
		int n = 12345;

		ArrayList<Integer> arr = DigitsOfANumber.getDigitsReverse(n);
		int mirr = DigitsOfANumber.getMirrorNr(n);
		
		System.out.println("getDigitsReverse(" + n + ") = " + arr.toString());
		System.out.println(mirr);


        int pB = 1234321;
        int pR = 52316321;

        System.out.println(isPalindrome(pR));
        System.out.println(isPalindrome(pB));
	}
}