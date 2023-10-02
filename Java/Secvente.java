import java.util.ArrayList;
import java.util.Arrays;

public class Secvente {
    public static class SequenceResult {
        public int left;
        public int right;
    }

    // 1.
    public static SequenceResult getLongestEvenSqOne(ArrayList<Integer> arr) {
        int lenMax = 0;
        int left = -1;
        int right = -1;
        boolean myFlag = true;
        SequenceResult sequenceResult = new SequenceResult();

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                myFlag = true;
                for (int k = i; k <= j; k++) {
                    if (arr.get(k) % 2 == 1){
                        myFlag = false;
                    }
                }

                if (myFlag) {
                    int len = j - i + 1;
                    if (len > lenMax) {
                        lenMax = len;
                        left = i;
                        right = j;
                    }
                }
            }
        }

        sequenceResult.right = right;
        sequenceResult.left = left;

        return sequenceResult;
    }

    // 2.
    public static Boolean isEven(int nr) {
        if (nr % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static SequenceResult getLongestEvenSqTwo(ArrayList<Integer> arr) {
        int lenMax = 0;
        int left = -1;
        int right = -1;
        int contor = 0;
        SequenceResult sequenceResult = new SequenceResult();


        for (int i = 0; i < arr.size(); i++) {
          if (isEven(arr.get(i))) {
            contor = i;
            while (contor < arr.size() && isEven(arr.get(contor))) {
                contor++;
            }
            int len = contor - i;
                if (len > lenMax) {
                    lenMax = len;
                    left = i;
                    right = contor - 1;
                    }
          }
        }

        sequenceResult.right = right;
        sequenceResult.left = left;

        return sequenceResult;
    }

    // 3.
    public static SequenceResult getLongestEvenSqThree(ArrayList<Integer> arr) {
        int lenMax = 0;
        int left = -1;
        int right = -1;
        int contor = 0;
        SequenceResult sequenceResult = new SequenceResult();


        for (int i = 0; i < arr.size(); i++) {
          if (isEven(arr.get(i))) {
            contor = i;
            while (contor < arr.size() && isEven(arr.get(contor))) {
                contor++;
            }
            int len = contor - i;
            if (len > lenMax) {
                lenMax = len;
                left = i;
                right = contor - 1;
                }
            i = contor;
          }
        }

        sequenceResult.right = right;
        sequenceResult.left = left;

        return sequenceResult;
    }

    // 4.
    public static long sumePartiale(int[] arr, int left, int right) {
        long[] arrS = new long[arr.length];
        long suma = 0;
        
        arrS[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arrS[i] = arrS[i - 1] + arr[i];
        }

        System.out.println(Arrays.toString(arrS));
        if (left - 1 < 0) {
            suma = arrS[right];
        } else {
            suma = arrS[right] - arrS[left - 1];
        }
        
        return suma;
    }

    // 5. 
    public static SequenceResult getLongestSqSumOne(ArrayList<Integer> arr) {
        long sumMax = 0;
        int left = -1;
        int right = -1;
        SequenceResult sequenceResult = new SequenceResult();

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                long sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr.get(k);
                }
                
                if (sum > sumMax) {
                    sumMax = sum;
                    left = i;
                    right = j;
                }
            }
        }

        sequenceResult.right = right;
        sequenceResult.left = left;

        return sequenceResult;
    }

    // 6. 
    public static SequenceResult getLongestSqSumTwo(ArrayList<Integer> arr) {
        long sumMax = Long.MIN_VALUE;
        int left = -1;
        int right = -1;
        SequenceResult sequenceResult = new SequenceResult();

        long[] arrS = new long[arr.size()];
        
        arrS[0] = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            arrS[i] = arrS[i - 1] + arr.get(i);
        }
        System.out.println(Arrays.toString(arrS));

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                long sum = 0;
                if (i == 0) {
                    sum = arrS[j];
                } else {
                    sum = arrS[j] - arrS[i - 1];
                }
                
                if (sum > sumMax) {
                    sumMax = sum;
                    left = i;
                    right = j;
                }
                
            }
        }

        sequenceResult.right = right;
        sequenceResult.left = left;

        return sequenceResult;
    }


     public static void main(String[] args) {
        
        // 1.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 5, 6, 8, 2, 3, 6, 4));
        // SequenceResult res = getLongestEvenSqOne(arr);
        // System.out.println(res.left);
        // System.out.println(res.right);
        

        // 2.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 5, 6, 8, 2, 3, 6, 4));
        // SequenceResult res = getLongestEvenSqTwo(arr);
        // System.out.println(res.left);
        // System.out.println(res.right);

        // 3.
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 5, 6, 8, 2, 3, 6, 4));
        // SequenceResult res = getLongestEvenSqThree(arr);
        // System.out.println(res.left);
        // System.out.println(res.right);

        // 4.
        // int[] arr = {5, 25, 3, 2, 565, 9};
        // long suma = sumePartiale(arr, 2, 4);
        // System.out.println(suma);

        // 5. 
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 1, -7, 3, -6, 2));
        // SequenceResult res = getLongestSqSumOne(arr);
        // System.out.println(res.left);
        // System.out.println(res.right);

        // 6.
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 1, -7, 3, -6, 2));
        SequenceResult res = getLongestSqSumTwo(arr);
        System.out.println(res.left);
        System.out.println(res.right);
    }
}
