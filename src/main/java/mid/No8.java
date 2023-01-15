package mid;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No8 {

    class Solution {
        public int myAtoi(String str) {
            int len = str.length();
            char[] charArray = str.toCharArray();

            //去除前导空格
            int index = 0;
            while (index<len&&charArray[index]==' '){
                index++;
            }

            //针对极端用例
            if(index==len){
                return 0;
            }

            //记录符号
            int sign =1;
            char firstChar = charArray[index];
            if (firstChar=='+'){
                index++;
            }else if (firstChar=='-'){
                index++;
                sign=-1;
            }

            //转换后续出现的数字字符
            int res = 0;
            while (index<len){
                char currChar = charArray[index];
                //判断合法情况
                if ()
            }

        }
    }

    public static void main(String[] args) {
        No8 no8 = new No8();
        Solution solution = no8.new Solution();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String s = scanner.nextLine();
            solution.myAtoi(s);
        }
        }
    }

