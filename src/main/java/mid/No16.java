package mid;

import java.util.Arrays;

public class No16 {

    public int threeSumClosest(int[] nums, int target) {
        int sub = Math.abs(target-nums[0]-nums[1]-nums[2]);
        int sub3 = target-nums[0]-nums[1]-nums[2];
        for (int i = 0; i <nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k <nums.length; k++) {
                    int number = nums[i]+nums[j]+nums[k];
                    int sub1 = target-number;
                    if (Math.abs(sub1)<sub){
                        sub=Math.abs(sub1);
                        sub3 = sub1;
                    }
                }
            }
        }
        return target-sub3;
    }


    public int threeSumClosestOfficial(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }



    public static void main(String[] args) {
        No16 no16 = new No16();
        int[] nums={-1,2,1,-4};
        int target = 1;
        int i = no16.threeSumClosest(nums, target);
        System.out.println(i);
    }

}
