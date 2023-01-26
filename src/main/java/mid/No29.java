package mid;

public class No29 {
    public int divide(int dividend, int divisor) {
        int flag = -1;

        if ((dividend>0&&divisor>0)||(dividend<0&&divisor<0)){
            flag=1;
        }


        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        //相等的情况
        if (absDividend==absDivisor){
            return 1*flag;
        }
        //计数器
        int count = 0;
        //除数-被除数，当他们的差值小于0时，说明到尽头了

        int result = 0;
        if (absDivisor==1){
            result = absDividend*flag;
        }

        else {
            absDividend=absDividend-absDivisor;
            while (absDividend>=0){
                absDividend=absDividend-absDivisor;
                //计数器加1
                count++;

            }
            result = count*flag;
        }

        if (result>=Integer.MAX_VALUE||result<=Integer.MIN_VALUE){
            if (flag==1){
                return Integer.MAX_VALUE;
            }
            if (flag==-1){
                return Integer.MIN_VALUE;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No29 no29 = new No29();
        int dividend=2147483647;
        int divisor=-1;
        int divide = no29.divide(dividend, divisor);
        System.out.println(divide);
    }
}
