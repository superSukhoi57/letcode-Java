package common;
class Solution42 {

        public int trap(int[] height) {
            int len=height.length;
            int []max_left=new int[len],max_right=new int[len];
            int left=height[0],right=height[len-1];

            //找左边最高和右边最近高！
            int i=0;
            max_left[0]=height[0];
            while(++i<len){
                if(height[i]>left)
                    left=height[i];
                max_left[i]=left;
            }
            i=len;
            while(--i>-1){
                if(height[i]>right)
                    right=height[i];
                max_right[i]=right;
            }

            int sum=0,start=0,end=1,level;
            i=-1;
           while(++i<len){
               level=max_left[i]<max_right[i]?max_left[i]:max_right[i];
               sum+=level-height[i];
           }
            return sum;
        }

}
/*
// https://leetcode.cn/problems/trapping-rain-water/solutions/9112/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8

//我的解法是参考了这个大神的解法三！！采用动态规划！


解法四：双指针
动态规划中，我们常常可以对空间复杂度进行进一步的优化。

例如这道题中，可以看到，max_left [ i ] 和 max_right [ i ] 数组中的元素我们其实只用一次，然后就再也不会用到了。所以我们可以不用数组，只用一个元素就行了。我们先改造下 max_left。

public int trap(int[] height) {
    int sum = 0;
    int max_left = 0;
    int[] max_right = new int[height.length];
    for (int i = height.length - 2; i >= 0; i--) {
        max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
    }
    for (int i = 1; i < height.length - 1; i++) {
        max_left = Math.max(max_left, height[i - 1]);
        int min = Math.min(max_left, max_right[i]);
        if (min > height[i]) {
            sum = sum + (min - height[i]);
        }
    }
    return sum;
}

那么什么时候从左到右，什么时候从右到左呢？根据下边的代码的更新规则，我们可以知道

max_left = Math.max(max_left, height[i - 1]);
height [ left - 1] 是可能成为 max_left 的变量， 同理，height [ right + 1 ] 是可能成为 right_max 的变量。

只要保证 height [ left - 1 ] < height [ right + 1 ] ，那么 max_left 就一定小于 max_right。

因为 max_left 是由 height [ left - 1] 更新过来的，而 height [ left - 1 ] 是小于 height [ right + 1] 的，而 height [ right + 1 ] 会更新 max_right，所以间接的得出 max_left 一定小于 max_right。

反之，我们就从右到左更。

优化后：
public int trap(int[] height) {
    int sum = 0;
    int max_left = 0;
    int max_right = 0;
    int left = 1;
    int right = height.length - 2; // 加右指针进去
    for (int i = 1; i < height.length - 1; i++) {
        //从左到右更
        if (height[left - 1] < height[right + 1]) {
            max_left = Math.max(max_left, height[left - 1]);
            int min = max_left;
            if (min > height[left]) {
                sum = sum + (min - height[left]);
            }
            left++;
        //从右到左更
        } else {
            max_right = Math.max(max_right, height[right + 1]);
            int min = max_right;
            if (min > height[right]) {
                sum = sum + (min - height[right]);
            }
            right--;
        }
    }
    return sum;
}

 */