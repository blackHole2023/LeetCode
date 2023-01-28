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

    //二分法有点难懂啊。。
    public int divideOfficial(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        //看rev来判断是不是正负。ans是最终的答案
        return rev ? -ans : ans;
    }

    // 快速乘
    public boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }




    public static void main(String[] args) {
        No29 no29 = new No29();
        int dividend=2147483647;
        int divisor=-1;
        int divide = no29.divide(dividend, divisor);
        System.out.println(divide);
    }
}
