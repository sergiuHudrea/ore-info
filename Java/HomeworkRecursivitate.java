import java.util.List;



// INTOARCE PARAM DE IESIRE????
public class HomeworkRecursivitate {
    

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

    // 1. https://www.pbinfo.ro/probleme/821/cmmdcrec
    public static int cmmdcRec(int nrOne, int nrTwo) {
        int auxOne = nrOne;
		int auxTwo = nrTwo;

        if (auxOne == auxTwo) {
            return auxOne;
        }

        if (auxOne > auxTwo) {
				auxOne -= auxTwo;
			} else {
				auxTwo -= auxOne;
			}

        return cmmdcRec(auxOne, auxTwo);
    }

    // 2. https://www.pbinfo.ro/probleme/822/nrcifrezerorec
    public static int nrCifreZeroRec(int n) {
        int flag = 0;

        if (n < 1) {
            return flag;
        }

        if (n % 10  == 0) {
            flag = 1;
        }

        return flag + nrCifreZeroRec(n/10);
    }

    // 3. https://www.pbinfo.ro/probleme/4206/cifdiv3rec
    public static int cifDivTreiRec(int n) {
        int flag = 0;

        if (n < 1) {
            return flag;
        }

        if ((n % 10) % 3 == 0) {
            flag = 1;
        }

        return flag + cifDivTreiRec(n / 10);
    }

    // 4. https://www.pbinfo.ro/probleme/1862/cntcifkrec
    // public static int cntCifKRec(int n, int k, int c) {

    // }


    // 5. https://www.pbinfo.ro/probleme/4208/existaimparerec
    public static int existaImpareRec(int n) {
        if (n < 1) {
            return 0;
        } 

        if ((n % 10) % 2 == 1) {
            return 1;
        }

        return existaImpareRec( n / 10);
    }

    // 6. https://www.pbinfo.ro/probleme/4210/fcrescrec
    public static int fCrescRec(int n) {
        if (n < 10) {
            return 1;
        }

        if ((n % 10) > (n / 10) % 10) {
            return 0;
        }

        return fCrescRec(n / 10);
    }


    // 7. https://www.pbinfo.ro/probleme/4538/cifdiferiterec
    public static int cifDiferiteRec(int n, int k) {
        int flag = 0;

        if (n < 1) {
            return 0;
        } 

        if (n % 10 != k) {
            flag = 1;
        }

        return flag + cifDiferiteRec(n / 10, k);
    }


    // 8. https://www.pbinfo.ro/probleme/4537/cifegalerec
    public static int cifEgaleRec(int n, int k) {
        if (n < 1) {
            return 1;
        }

        if (n % 10 != k) {
            return 0;
        }

        return cifEgaleRec(n / 10, k);
    }


    // 9. https://www.pbinfo.ro/probleme/919/nrcifrezerorec1
  


    // 10. https://www.pbinfo.ro/probleme/4209/difparimpar
    public static int difParImpar(int n) {
        int flag = 1;

        if (n < 1) {
            return 0;
        }

        if ((n % 10) % 2 != 0) {
            flag = -1;
        }

        return difParImpar(n / 10) + flag;
    }

    // 11. https://www.pbinfo.ro/probleme/824/cifmaxrec
    public static int cifMax(int n) {
        if (n < 1) {
            return 0;
        }

        return Math.max(n % 10, cifMax(n / 10));
    }

    public static void main(String[] args) {
        // 1.
        // System.out.println(cmmdcRec(18,24));

        // 2.
        // System.out.println(nrCifreZeroRec(205));

        // 3.
        // System.out.println(cifDivTreiRec(2009376));

        // 5.
        // System.out.println(existaImpareRec(240));
        // System.out.println(existaImpareRec(2134));

        // 6.
        // System.out.println(fCrescRec(4));
        // System.out.println(fCrescRec(975311));
        // System.out.println(fCrescRec(43711));
        // System.out.println(fCrescRec(24));

        // 7.
        // System.out.println(cifDiferiteRec(4, 4));
        // System.out.println(cifDiferiteRec(222, 2));
        // System.out.println(cifDiferiteRec(43711, 1));
        // System.out.println(cifDiferiteRec(2222, 3));

        // 8.
        // System.out.println(cifEgaleRec(4, 4));
        // System.out.println(cifEgaleRec(222, 2));
        // System.out.println(cifEgaleRec(43711, 1));
        // System.out.println(cifEgaleRec(2222, 3));


        // 10.
        // System.out.println(difParImpar(240));
        // System.out.println(difParImpar(21377));

        // 11.
        System.out.println(cifMax(2050));

    }
}
