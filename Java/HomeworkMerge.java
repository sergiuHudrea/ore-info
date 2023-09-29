import java.util.Arrays;
import java.util.ArrayList;

class HomeworkMerge {
    // 1. https://www.pbinfo.ro/probleme/250/interclasare1
    public static ArrayList<Integer> mergeAsc(int[] arrOne, int[] arrTwo) {
       int counterOne = 0;
       int counterTwo = 0;
       ArrayList<Integer> newArr = new ArrayList<>();
       
       while (counterOne < arrOne.length || counterTwo < arrTwo.length) {
           if (counterOne < arrOne.length && counterTwo < arrTwo.length) {
               if (arrOne[counterOne] < arrTwo[counterTwo]) {
                   newArr.add(arrOne[counterOne]);
                   counterOne++;
               } else if (arrOne[counterOne] > arrTwo[counterTwo]) {
                   newArr.add(arrTwo[counterTwo]);
                   counterTwo++;
               } else {
                   newArr.add(arrOne[counterOne]);
                   counterOne++;
                   counterTwo++;
               }
           } else if (counterOne >= arrOne.length) {
               newArr.add(arrTwo[counterTwo]);
               counterTwo++;
           } else if (counterTwo >= arrTwo.length) {
               newArr.add(arrOne[counterOne]);
               counterOne++;
           }
       }
       
       return newArr;
    }
    
    // 2. https://www.pbinfo.ro/probleme/251/interclasare2
    public static ArrayList<Integer> interclasareDoi(int[] arrOne, int[] arrTwo) {
        int counterOne = 0;
        int counterTwo = 0;
        ArrayList<Integer> newArr = new ArrayList<>();
        
        while (counterOne < arrOne.length || counterTwo < arrTwo.length) {
            if (counterOne < arrOne.length && counterTwo < arrTwo.length) {
                if (arrOne[counterOne] < arrTwo[counterTwo]) {
                    counterOne++;
                } else if (arrOne[counterOne] > arrTwo[counterTwo]) {
                    counterTwo++;
                } else if (arrOne[counterOne] == arrTwo[counterTwo]) {
                    newArr.add(arrOne[counterOne]);
                    counterOne++;
                    counterTwo++;
                }
            } else {
                break;
            }
        }
        
        return newArr;
    }
    
    // 3. https://www.pbinfo.ro/probleme/284/interclasare3
    public static ArrayList<Integer> interclasareTrei(int[] arrOne, int[] arrTwo) {
        int counterOne = 0;
        int counterTwo = arrTwo.length - 1;
        ArrayList<Integer> newArr = new ArrayList<>();
        
        while (counterOne < arrOne.length || counterTwo > -1) {
            System.out.println(counterOne);
            if (counterOne < arrOne.length && counterTwo > -1) {
                if (arrOne[counterOne] > arrTwo[counterTwo]) {
                    if (arrTwo[counterTwo] % 2 == 0) {
                        newArr.add(arrTwo[counterTwo]);
                    } 
                    counterTwo--;
                } else if (arrOne[counterOne] < arrTwo[counterTwo]) {
                    if (arrOne[counterOne] % 2 == 0) {
                        newArr.add(arrOne[counterOne]);
                    } 
                    counterOne++;
                } else if (arrOne[counterOne] == arrTwo[counterTwo]) {
                    if (arrOne[counterOne] % 2 == 0) {
                        newArr.add(arrOne[counterOne]);
                        newArr.add(arrTwo[counterTwo]);
                    } 
                    counterOne++;
                    counterTwo--;
                    
                }
            } else if (counterOne >= arrOne.length) {
                if (arrTwo[counterTwo] % 2 == 0) {
                    newArr.add(arrTwo[counterTwo]);
                }
                counterTwo--;
            } else if (counterTwo <= -1) {
                if (arrOne[counterOne] % 2 == 0) {
                    newArr.add(arrOne[counterOne]);
                }
                counterOne++;
            } 
        }
        
        return newArr;
    }
   
   
   // 4. https://www.pbinfo.ro/probleme/530/multimi1
   public static void multimiUnu(int[] arrOne, int[] arrTwo) {
       ArrayList<Integer> intersectie = new ArrayList<>();
       ArrayList<Integer> reuniune = new ArrayList<>();
       
       int counterOne = 0;
       int counterTwo = 0;
       
       while (counterOne < arrOne.length || counterTwo < arrTwo.length) {
           if (counterOne < arrOne.length && counterTwo < arrTwo.length) {
               if (arrOne[counterOne] > arrTwo[counterTwo]) {
                   reuniune.add(arrTwo[counterTwo]);
                   counterTwo++;
               } else if (arrOne[counterOne] < arrTwo[counterTwo]) {
                   reuniune.add(arrOne[counterOne]);
                   counterOne++;
               } else if (arrOne[counterOne] == arrTwo[counterTwo]) {
                   reuniune.add(arrOne[counterOne]);
                   intersectie.add(arrOne[counterOne]);
                   counterOne++;
                   counterTwo++;
               }
           } else if (counterOne >= arrOne.length) {
               reuniune.add(arrTwo[counterTwo]);
               counterTwo++;
           } else if (counterTwo >= arrTwo.length) {
               reuniune.add(arrOne[counterOne]);
               counterOne++;
           }
       }
       
       System.out.println(reuniune);
       System.out.println(intersectie);
   }
   
   // 5. https://www.pbinfo.ro/probleme/242/interclasm
   public static ArrayList<Integer> interclasareM(int m, int[] arrOne, int[] arrTwo) {
       ArrayList<Integer> newArr = new ArrayList<>();
       int counterOne = 0;
       int counterTwo = 0;

       while (counterOne < arrOne.length || counterTwo < arrTwo.length) {
           if (counterOne < arrOne.length && counterTwo < arrTwo.length) {
               if (arrOne[counterOne] < arrTwo[counterTwo]) {
                   if (arrOne[counterOne] % m == 0) {
                      newArr.add(arrOne[counterOne]);
                   }
                   counterOne++;
               } else if (arrOne[counterOne] > arrTwo[counterTwo]) {
                   if (arrTwo[counterTwo] % m == 0) {
                       newArr.add(arrTwo[counterTwo]);
                   }
                   counterTwo++;
               } else {
                   counterOne++;
                   counterTwo++;
               }
           } else if (counterOne >= arrOne.length) {
               if (arrTwo[counterTwo] % m == 0) {
                   newArr.add(arrTwo[counterTwo]);
                   counterTwo++;
               }
           } else if (counterTwo >= arrTwo.length) {
               if (arrOne[counterOne] % m == 0) {
                   newArr.add(arrOne[counterOne]);
                   counterOne++;
               }
           }
       }

       return newArr;
   }
    
    
    public static void main(String[] args) {
    
        // 1.
        // int[] arrOne = {1, 3, 4, 7, 20, 24, 60};
        // int[] arrTwo = {3, 5, 7, 8, 9, 10, 12, 20, 24};
        // System.out.println(mergeAsc(arrOne, arrTwo));
        
        // 2.
        // int[] arrOne = {1, 3, 4, 7, 20, 24, 60};
        // int[] arrTwo = {3, 5, 7, 8, 9, 10, 12, 20, 24};
        // System.out.println(interclasareDoi(arrOne, arrTwo));
        
        // 3.
        // int[] arrOne = {2, 4, 7, 37, 42};
        // int[] arrTwo = {88, 88, 67, 45, 42, 32, 4, 1};
        // System.out.println(interclasareTrei(arrOne, arrTwo));
        
        // 4.
        // int[] arrOne = {3, 6, 8, 9, 12};
        // int[] arrTwo = {2, 5, 6, 7, 8, 9, 11};
        // multimiUnu(arrOne, arrTwo);
        
        // 5.
        int[] arrOne = {1, 2, 3, 4, 7, 20, 60};
        int[] arrTwo = {3, 5, 7, 8, 9, 10, 12, 20, 24};
        int m = 5;
        System.out.println(interclasareM(m, arrOne, arrTwo));
    }
}