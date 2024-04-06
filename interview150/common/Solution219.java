package common;

import java.util.HashMap;


public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();//value,index

        for(int i=0;i<len;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],i);
            else{
                if(Math.abs(i-map.get(nums[i]))<=k)
                    return true;
                //要让两个相同的数尽量靠近！
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
