package mid;

import java.util.Scanner;

public class No12 {
    class Solution {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols =  {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            StringBuffer roman = new StringBuffer();
            for (int i = 0; i < values.length; i++) {
                int value = values[i];
                String symbol = symbols[i];
                while (num>=value){
                    num-=value;
                    roman.append(symbol);
                }
                if (num==0){
                    break;
                }
            }
            return roman.toString();
        }
    }

    public static void main(String[] args) {
        No12 no12 = new No12();
        No12.Solution solution = no12.new Solution();
        Scanner scanner = new Scanner(System.in);
        while(true){
            int s = scanner.nextInt();
            solution.intToRoman(s);
        }

    }
}
