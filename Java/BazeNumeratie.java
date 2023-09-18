import java.lang.Math;
import java.util.AbstractMap;
import java.util.Map;
import java.util.ArrayList;

class BazeNumeratie {

    // 1.
    public static int baseTwoToBaseTen(int nr) {
        int pwr = 0;
        int baseTen = 0;

        while (nr > 0) {
            baseTen += Math.pow(2, pwr) * (nr % 10);
            pwr++;
            nr /= 10;
        }

        return baseTen;
    }

    // 2.
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

    // 3.
    public static int baseSixteenToBaseTen(String str) {
        Map<Character, Integer> map = Map.ofEntries(   
            new AbstractMap.SimpleEntry<Character, Integer>('A', 10),   
            new AbstractMap.SimpleEntry<Character, Integer>('B', 11),   
            new AbstractMap.SimpleEntry<Character, Integer>('C', 12),   
            new AbstractMap.SimpleEntry<Character, Integer>('D', 13),
            new AbstractMap.SimpleEntry<Character, Integer>('E', 14),
            new AbstractMap.SimpleEntry<Character, Integer>('F', 15) 
            );

        int baseTen = 0;
        int pwr = str.length() - 1;
        int nr = 0;

        for (int i = 0; i < str.length(); i++) {
            Character charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                nr = Character.getNumericValue(charAt);
            } else {
                nr = map.get(charAt);
            }

            baseTen += Math.pow(16, pwr) * nr;
            pwr--;
        }

        return baseTen;
    }


    public static ArrayList<Character> baseTenToBaseSixteen(int nr) {
         Map<Integer, Character> map = Map.ofEntries(   
            new AbstractMap.SimpleEntry<Integer, Character>(10, 'A'),   
            new AbstractMap.SimpleEntry<Integer, Character>(11, 'B'),   
            new AbstractMap.SimpleEntry<Integer, Character>(12, 'C'),   
            new AbstractMap.SimpleEntry<Integer, Character>(13, 'D'),
            new AbstractMap.SimpleEntry<Integer, Character>(14, 'E'),
            new AbstractMap.SimpleEntry<Integer, Character>(15, 'F') 
            );

        ArrayList<Character> baseSixteen = new ArrayList<>();
        Character myChar;

        while (nr > 0) {
            int rest = nr % 16;

            if (rest <= 9) {
                myChar = (char)(rest + '0');
            } else {
                myChar = map.get(rest);
            }
            baseSixteen.add(0, myChar);
            nr /= 16;
        }

        return baseSixteen;
    }



    public static void main(String[] args) {
        
        // 1.
        // int baseTwo = 11000;
        // int baseTen = baseTwoToBaseTen(baseTwo);
        // System.out.println(baseTen);
     
        // 2.
        // int baseTen = 24;
        // int baseTwo = baseTenToBaseTwo(baseTen);
        // System.out.println(baseTwo);
        
        // 3.
        // String baseSixteen = "1F";
        // int baseTen = baseSixteenToBaseTen(baseSixteen);
        // System.out.println(baseTen);

        // 4.
        int baseTen = 160;
        ArrayList<Character> baseSixteen = baseTenToBaseSixteen(baseTen);
        System.out.println(baseSixteen);
    }
}