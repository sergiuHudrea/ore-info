import java.util.ArrayList;

class HomeworkSiruri {

    // 1. https://www.pbinfo.ro/probleme/2820/sir11
    public static ArrayList<Integer> sir11(int nr) {
        int first = 1;
        int second = -1;
        ArrayList<Integer> arr = new ArrayList<>(); 
        int f = 0;

        if (nr == 1) {
            arr.add(first);
            return arr;
        } else if (nr == 2) {
            arr.add(first);
            arr.add(second);
            return arr;
        }

        arr.add(first);
        arr.add(second);

        for (int i = 2; i < nr; i++) {
            f = 1 - (2 * second) - first;
            first = second;
            second = f;

            arr.add(f);
        }

        return arr;
    }
    
    // 2. https://www.pbinfo.ro/probleme/806/generare
    public static ArrayList<Integer> generare(int nr) {
        int first = 1;
        int second = 2;
        int third = 0;
        int counter = 3;
        ArrayList<Integer> arr = new ArrayList<>();
        
        if (nr == 1) {
            arr.add(first);
            return arr;
        } else if (nr == 2) {
            arr.add(second);
            arr.add(first);
            return arr;
        }
        
        arr.add(second);
        arr.add(first);
        
        while (third < nr) {
            if (counter % 2 == 0) {
                third = 1 + second;
                first = second;
                second = third;
                arr.add(0, third);
            } else {
                third = 1 + (2 * first);
                first = second;
                second = third;
                arr.add(0, third);
            }
            counter++;
        }
        
        return arr;
    }

    // 3. https://www.pbinfo.ro/probleme/243/sir1
    public static int sir1(int nr) {
        // 1, 2,1, 3,2,1, 4,3,2,1, 5,4,3,2,1, 6,5,4,3,2,1
        int contor = 1;
        int aux = 0;
        int groupNr = 0;
        
        while (contor < nr) {
            while (aux > 0) {
                if (contor == nr) {
                    return aux;
                }
                aux--;
                contor++;
            }
            groupNr++;
            aux = groupNr;
        }
        
        return aux;
    }


    public static void main(String[] args) {
        
        // 1.
        // int nr = 10;
        // ArrayList<Integer> sir = sir11(nr);
        // System.out.println(sir);
        
        // 2.
        // ArrayList<Integer> sir = generare(15);
        // System.out.println(sir);
        
        // 3.
        int result = sir1(14);
        System.out.println(result);
    }
}
