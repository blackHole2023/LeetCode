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
                if (currChar>'9'||currChar<'0'){
                    break;
                }
                //判断越界
                if (res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&(currChar-'0')>Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }

                //合法才转换
                res = res*10+sign*(currChar-'0');

                index++;

            }
            return res;

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

