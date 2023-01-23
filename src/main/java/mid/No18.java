package mid;

import java.util.*;
import java.util.stream.Collectors;

public class No18 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            List<Integer> nums1 = Arrays.asList(integers);

            nums1.sort(Comparator.naturalOrder());
            List<List<Integer>> res = new ArrayList<>();
            int len = nums1.size();



            for (int i = 0; i < len; i++) {
                for (int j = i+1; j < len; j++) {
                    if (nums1.get(i)+nums1.get(j)>Integer.MAX_VALUE){
                        break;
                    }
                    for (int k = j+1; k < len; k++) {
                        if (nums1.get(i)+nums1.get(j)+nums1.get(k)>Integer.MAX_VALUE){
                            break;
                        }
                        for (int l = k+1; l < len; l++) {
                            if (nums1.get(i)+nums1.get(j)+nums1.get(k)+nums1.get(l)>Integer.MAX_VALUE){
                                break;
                            }
                            if (nums1.get(i)+nums1.get(j)+nums1.get(k)+nums1.get(l)==target){
                                int result = nums1.get(i)+nums1.get(j)+nums1.get(k)+nums1.get(l);
                                List<Integer> list1 = new ArrayList<>();
                                list1.add(nums1.get(i));
                                list1.add(nums1.get(j));
                                list1.add(nums1.get(k));
                                list1.add(nums1.get(l));
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

    public static void main(String[] args) {
        No18 no18 = new No18();
        int[] nums ={1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> lists = no18.fourSum(nums, target);
        System.out.println(lists);
    }

}
