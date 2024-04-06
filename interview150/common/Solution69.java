package common;

public class Solution69 {
    public int mySqrt(int x) {
        int end=x/2,i;
        //当x>=2147395600这个数时，情况比较特殊，sqrt（2147395600）=46340，而比x大的数的返回值大于46340
        //而且46341的平方超出整形范围！！！，用i*i来判断时总出错！！！
        //特殊情况：2147395600
        if(x>=2147395600)
            return 46340;
        if(x==0)
            return 0;
        if(end<=1)
            return 1;

        for( i=1;i<=end;i++){
            if(i*i>=x)//i*i会出现超出整形范围的数！！！！
                break;
        }
        if(i*i==x)
            return i;
        return i-1;
    }
}


/*
*一毫秒优秀代码，运用二分法！！！
class Solution {
    public int mySqrt(int x) {
        int left = 0; int right = x;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if((long) mid * mid > x) {
                right = mid - 1;
            }else if((long) mid * mid < x) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return right;
    }
}
* */