import java.lang.Math;

class HomeworkDividers {
	// 1. https://www.pbinfo.ro/probleme/389/divizoripariinterval
	public static int nrDivPari(int a) {
	    int contor = 0;
	    
	    for (int i = 2; i <= a; i += 2) {
	            if (a % i == 0) {
	                contor++;
	            }
	    }
	    return contor;
	}
	
	public static int maxDivPari(int a, int b) {
	    int nrDivPari;
	    int diviMax = 0;
	    
	    while (a <= b) {
	        nrDivPari = nrDivPari(a);
	        
	        if (nrDivPari > diviMax) {
	            diviMax = nrDivPari;
	        }
	        a++;
	    }
	    
	    return diviMax;
	}
	
	public static void divizoriPariInterval(int a, int b) {
	    int maxDivPari = maxDivPari(a, b);
	    int nrDivPari;
	    int min = 0;
	    int max = 0;
	    
	    while (a <= b) {
	        nrDivPari = nrDivPari(a);
	        if (nrDivPari == maxDivPari & min == 0) {
	            min = a;
	        }
	        if (nrDivPari == maxDivPari & a > max) {
	            max = a;
	        }
	        
	        a++;
	    }
	    System.out.println(maxDivPari);
	    System.out.println(min);
	    System.out.println(max);
	}


    // 2. https://www.pbinfo.ro/probleme/3272/sumdivogl
    public static int kOglindit(int k) {
        int ogl = 0;
        int pow = 0;
        
        while (k > 0) {
            ogl += (k % 10);
            if (k / 10 > 0) {
                ogl *= 10;
            }
            
            k /= 10;
        }
        
        return ogl;
    }
    
    public static int sumDiv(int n) {
        int sumDiv = 0;
        int iterator = 1;
        
        while (iterator <= n) {
            if (n % iterator == 0) {
                sumDiv += iterator;
            }
            iterator++;
        }
        
        return sumDiv;
    }
    
    public static int sumDivOgl(int[] arr) {
        int sum = 0;
        int ogl;
        
        for (int i = 0; i < arr.length; i++) {
            ogl = kOglindit(arr[i]);
            sum += sumDiv(ogl);
        }
        
        return sum;
    }
    
    
    // 3. https://www.pbinfo.ro/probleme/3200/neadragulin
    public static int nrCifre(int n) {
        int contor = 0;
        
        while (n > 0) {
            contor++;
            n /= 10;
        }
        
        return contor;
    }
    
    public static int neaDragulin(int n, int k) {
        int impartitor = 72;
        int nrNou = n;
        int pow = (int)Math.pow(10, nrCifre(n));
        int rest;
        
        while (k > 1) {
            nrNou = (nrNou * pow) + n;
            k--;
        }
        
        rest = nrNou % impartitor;
        return rest;
    }
    
    
    // 4. https://www.pbinfo.ro/probleme/411/primeintreele1
    public static int cmmdc(int a, int b) {
		int auxA = a;
		int auxB = b;

		while (auxA != auxB) {
			if (auxA > auxB) {
				auxA -= auxB;
			} else {
				auxB -= auxA;
			}
		}

		return auxA;
	}
    
    public static int primeIntreEle(int n) {
        int cmmdc;
        int contor = 0;
        
        for (int i = 1; i < n; i++) {
            for (int j = i; j <= n; j++) {
                cmmdc = cmmdc(i, j);
                if ( cmmdc == 1) {
                    contor++;
                }
            }
        }
        
        return contor;
    }
    
    
    
    // 5. https://www.pbinfo.ro/probleme/3271/perechecmmdc
    static class PairMax {
        public int a;
        public int b;
    }
    public static PairMax perecheCmmdc(int[] arr) {
        PairMax pairMax = new PairMax();
        int sumMax = 0;
        int divMax = 0;
        int a = 0;
        int b = 0;
        
        for (int i = 0; i < arr.length - 1; i += 2) {
            int cmmdc = cmmdc(arr[i], arr[i + 1]);
            if (cmmdc == divMax) {
                if ((arr[i] + arr[i + 1]) > sumMax) {
                    sumMax = (arr[i] + arr[i + 1]);
                    a = arr[i];
                    b = arr[i + 1];
                }
            }
            if (cmmdc > divMax) {
                divMax = cmmdc;
                a = arr[i];
                b = arr[i + 1];
            }
        }
        
        pairMax.a = a;
        pairMax.b = b;
        
        return pairMax;
    }
    

	public static void main(String[] args) {
		
        // 1.
        // int a = 10;
        // int b = 20;
        // divizoriPariInterval(10, 20);

        // 2.
        // int[] arr = {12, 23, 30};
        // System.out.println(sumDivOgl(arr));
        
        
        // 3.
        // int nea = neaDragulin(51, 3);
        // System.out.println(nea);
      
    
        // 4.
        // int n = 6;
        // System.out.println(primeIntreEle(n));
    
        // 5. 
        int[] arr = {12, 18, 16, 12, 18, 30, 25, 35};
        PairMax perecheCmmdc = perecheCmmdc(arr);
        System.out.println(perecheCmmdc.a);
        System.out.println(perecheCmmdc.b);
	}
}