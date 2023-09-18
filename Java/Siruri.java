import java.util.ArrayList;

class Siruri {

    // 1. https://www.pbinfo.ro/probleme/2820/sir11
    public static ArrayList<Integer> sir11(int nr) {
        int first = 1;
        int second = -1;
        ArrayList<Integer> arr = new ArrayList<>(); 
        int f = 0;
        // f(n) = 1 − 2 ⋅ f(n−1) − f(n−2)

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



    public static void main(String[] args) {
        
        // 1.
        int nr = 10;
        ArrayList<Integer> sir = sir11(nr);
        System.out.println(sir);
        

        
    }
}
