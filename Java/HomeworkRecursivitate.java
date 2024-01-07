import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

        if (n % 10 == 0) {
            flag = 1;
        }

        return flag + nrCifreZeroRec(n / 10);
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
    public static void cntCifKRec(int n, int k, AtomicInteger c) {
        if (n < 1) {
            return;
        }

        if ((n % 10) >= k) {
            int value = c.intValue();
            value++;
            c.set(value);
        }

        cntCifKRec(n / 10, k, c);
    }

    // 5. https://www.pbinfo.ro/probleme/4208/existaimparerec
    public static int existaImpareRec(int n) {
        if (n < 1) {
            return 0;
        }

        if ((n % 10) % 2 == 1) {
            return 1;
        }

        return existaImpareRec(n / 10);
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
    public static void nrCifreZeroRecUnu(int n, AtomicInteger nr) {
        if (n < 1) {
            return;
        }

        if (n % 10 == 0) {
            int value = nr.intValue();
            value++;
            nr.set(value);
        }

        nrCifreZeroRecUnu(n / 10, nr);
    }

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

        int max = cifMax(n / 10);

        if (n % 10 > max) {
            return n % 10;
        } else {
            return max;
        }

        // return Math.max(n % 10, cifMax(n / 10));
    }

    // 12.
    public static int productSumRunner(List<Object> array, int depth) {
        int sum = 0;
        for (Object obj : array) {
            if (obj instanceof Integer) {
                sum += (Integer) obj;
            } else if (obj instanceof ArrayList) {
                List<Object> castedObject = (ArrayList<Object>) obj;
                sum += depth * productSumRunner(castedObject, depth + 1);
            }
        }

        return sum;
    }

    public static int productSum(List<Object> array) {
        return productSumRunner(array, 2);
    }

    public static void main(String[] args) {
        // 1.
        // System.out.println(cmmdcRec(18,24));

        // 2.
        // System.out.println(nrCifreZeroRec(205));

        // 3.
        // System.out.println(cifDivTreiRec(2009376));

        // 4.
        // AtomicInteger c = new AtomicInteger(0);
        // cntCifKRec(2750, 4, c);
        // System.out.println(c);

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

        // 9.
        AtomicInteger nr = new AtomicInteger(0);
        nrCifreZeroRecUnu(2050, nr);
        System.out.println(nr);

        // 10.
        // System.out.println(difParImpar(240));
        // System.out.println(difParImpar(21377));

        // 11.
        // System.out.println(cifMax(2050));

        // 12.
        // List<Object> test = new ArrayList<Object>(Arrays.asList(
        //         5,
        //         2,
        //         new ArrayList<Object>(Arrays.asList(7, -1)),
        //         3,
        //         new ArrayList<Object>(
        //                 Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
        // System.out.println(productSum(test));
    }

}
