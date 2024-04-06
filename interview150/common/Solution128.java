package common;


import java.util.HashSet;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int len=nums.length,answer=0;
        HashSet<Integer>num_set=new HashSet<>();
        for(int i=0;i<len;i++)
            num_set.add(nums[i]);

       int[]arr=new int[len];
       for(int i=0;i<len;i++)
           arr[i]=1;
       
        return answer;
    }
}
