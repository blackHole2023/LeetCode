package mid;

import java.util.*;
import java.util.stream.Collectors;

public class No18 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            List<Integer> nums2 = Arrays.asList(integers);


            nums2.sort(Comparator.naturalOrder());
            List<Long> nums1 = nums2.stream().map((x) -> {
                String y = x.toString();
                long l = Long.parseLong(y);
                return l;
            }).collect(Collectors.toList());

            List<List<Integer>> res = new ArrayList<>();
            int len = nums1.size();



            for (int i = 0; i < len; i++) {
                for (int j = i+1; j < len; j++) {
                    for (int k = j+1; k < len; k++) {
                        for (int l = k+1; l < len; l++) {
                            if (nums1.get(i)+nums1.get(j)+nums1.get(k)+nums1.get(l)>Integer.MAX_VALUE){
                                break;
                            }
                            if (nums1.get(i)+nums1.get(j)+nums1.get(k)+nums1.get(l)==target){
                                List<Integer> list1 = new ArrayList<>();
                                list1.add(Integer.valueOf(nums1.get(i).toString()));
                                list1.add(Integer.valueOf(nums1.get(j).toString()));
                                list1.add(Integer.valueOf(nums1.get(k).toString()));
                                list1.add(Integer.valueOf(nums1.get(l).toString()));
                                res.add(list1);
                                break;
                            }
                        }
                    }
                }
            }
            Set<List<Integer>> set = new HashSet<>(res);
            List<List<Integer>> collect = set.stream().collect(Collectors.toList());
            return collect;
        }

        public List<List<Integer>> fourSumOfficial(int[] nums, int target) {
            List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 4) {
                return quadruplets;
            }
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length - 3; i++) {
                //提前去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                //最小的都比target大，肯定直接break，所以这类题中排序是很关键的。
                if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }


                if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }

                //固定第二个值，剩余两个指针
                for (int j = i + 1; j < length - 2; j++) {
                    //去重
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }
                    //双指针
                    int left = j + 1, right = length - 1;
                    while (left < right) {
                        long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            //去重
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            left++;
                            //去重
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return quadruplets;
        }


    public static void main(String[] args) {
        No18 no18 = new No18();
        int[] nums ={10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90};
        int target = 200;
        List<List<Integer>> lists = no18.fourSum(nums, target);
        System.out.println(lists);
    }

}
