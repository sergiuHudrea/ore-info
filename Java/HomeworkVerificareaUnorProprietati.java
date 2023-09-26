import java.util.ArrayList;
import java.util.Arrays;

class HomeworkVerificareaUnorProprietati {

    // 1. https://www.pbinfo.ro/probleme/287/veriford
    public static void verifOrd(int[][] arr) {
        Boolean toggle = true;
        for (int i = 0; i < arr.length; i++) {
            toggle = true;
           for (int j = 0; j < arr[i].length - 1; j++) {
               if (arr[i][j] > arr[i][j + 1]) {
                   toggle = false;
               }
           }
           if (toggle) {
               System.out.println(1);
           } else {
               System.out.println(0);
           }
        }
    }
    
    // 2. https://www.pbinfo.ro/probleme/293/cifredistincte
    public static Boolean cifreDistincte(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // 3. https://www.pbinfo.ro/probleme/2689/palxxl
    public static int palXXL(int[] arr) {
        int end = arr.length - 1;
        Boolean pal = true;
        int nr = 0;
        
        for (int i = 0; i < arr.length; i++) {
            nr *= 10;
            nr += arr[i];
        }
        
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[end]) {
                pal = false;
            }
            end--;
        }
        
        if (pal) {
            System.out.println("DA");
        } else {
            System.out.println("NU");
        }
        
        return nr;
    }
    
    // 4. https://www.pbinfo.ro/probleme/291/verifnrparcifre
    public static Boolean nrParCifre(int nr) {
        int contor = 0;
        
        while (nr > 0) {
            contor++;
            nr /= 10;
        }
        
        if (contor % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void verificNrParCifre(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!nrParCifre(arr[i])) {
                System.out.println("NU");
                return ;
            }
        }
        System.out.println("DA");
    }
   
   // 5. https://www.pbinfo.ro/probleme/1329/sir-zigzag
   public static void sirZigZag(int[] arr) {
       boolean toggle = true;
       if (arr[0] > arr[1]) {
           toggle = true;
       } else {
           toggle = false;
       }
       
       for (int i = 0; i < arr.length - 1; i++) {
           if (!toggle) {
               if (arr[i] > arr[i + 1]) {
                   System.out.println("NU");
                   return;
               }
           } else if (toggle) {
                if (arr[i] < arr[i + 1]) {
                   System.out.println("NU");
                   return;
               }
           }
           toggle = !toggle;
       }
       
       System.out.println("DA");
   }
    

    public static void main(String[] args) {
        
        // 1.
        // int[][] arr = {{5, 10, -5, 8, -2, -7, 0, -9, 10}, {-6, -5, -4, 0, 2, 5, 8}, {2, 7, 8, 10, 10}};
        // verifOrd(arr);
        
        // 2.
        // int[] arr = {84, 60, 102, 24, 6, 85};
        // Boolean result = cifreDistincte(arr);
        // System.out.println(result);
        
        // 3. 
        // int[] arr = {1, 2, 3, 2, 1, 4};
        // int result = palXXL(arr);
        // System.out.println(result);
        
        // 4.
        // int[] arr = {2820, 82, 65, 1026, 84};
        // verificNrParCifre(arr);
        
        // 5. 
        // int[] arr = {1, 5, 3, 7, 5};
        // sirZigZag(arr);
    }
}