package mid;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class No43 {

    public String multiply(String num1, String num2) {
        String[] split = num2.split("");
        List<Integer> collect = Arrays.stream(split).map((x) -> Integer.parseInt(x)).collect(Collectors.toList());
        ArrayList<String> strings = new ArrayList<>();
        int size = collect.size();
        for (Integer integer: collect) {
            String s = "0";
            for (int j = 0; j < integer; j++) {
                s = addStrings(num1, s);
            }
            strings.add(s);
        }
        for (int j = 0; j < size; j++) {
            String sb = strings.get(j);
            for (int k = size-j-1; k >0; k--) {
                sb = sb+"0";
            }
            strings.set(j,sb);
        }
        int len = strings.size();
        String result = "0";
        for (int j = 0; j < len; j++) {
            result = addStrings(result,strings.get(j));
        }
        System.out.println(strings);


        return result;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder(num1);
        StringBuilder stringBuilder1 = new StringBuilder(num2);
        String s1 = stringBuilder.reverse().toString();
        String s2 = stringBuilder1.reverse().toString();

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        int len3 = len1>len2?len1:len2;
        int[] int1 = new int[len3];
        int[] int2 = new int[len3];
        for (int i = 0; i < len1; i++) {
            int1[i] = chars1[i]-'0';
        }
        for (int i = 0; i < len2; i++) {
            int2[i] = chars2[i]-'0';
        }

        char[] int3 = new char[len3];
        int flag = 0;
        for (int i = 0; i < len3; i++) {
            int j = int1[i]+int2[i]+flag;
            if (j>=10){
                int3[i]=(char)(j%10+'0');
                flag = j/10;
            }else {
                int3[i]=(char)(j+'0');
                flag=0;
            }
        }
        String s = String.valueOf(int3);
        s=s+flag;
        StringBuilder stringBuilder2 = new StringBuilder(s);
        String s3 = stringBuilder2.reverse().toString();
        String s4 = s3.replaceFirst("^0*", "");
        if (s4.equals("")){
            return "0";
        }
        return s4;
    }

    public static void main(String[] args) {
        No43 no43 = new No43();
        String num1 = "3866762897776739956";
        String num2 = "15975363164662";

        String num3 = "0";
        String num4 = "0";
        String multiply = no43.multiply(num1, num2);
        System.out.println(multiply);
//        String s = no43.addStrings(num3, num4);
//        System.out.println(s);
    }
}
