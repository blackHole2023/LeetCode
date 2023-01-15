package mid;

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

    public static void main(String[] args) {
        No16 no16 = new No16();
        int[] nums={-1,2,1,-4};
        int target = 1;
        int i = no16.threeSumClosest(nums, target);
        System.out.println(i);
    }

}
