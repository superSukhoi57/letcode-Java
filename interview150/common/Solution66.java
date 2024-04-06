package common;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        int now,next;
        digits[len-1]+=1;
        for(int i=len-1;i>0;i--){
            now=digits[i]%10;
            next=digits[i]/10;//进位
            digits[i]=now;
            digits[i-1]+=next;
        }
        if(digits[0]>=10){
            int []answer=new int[len+1];
            answer[0]=1;
            return answer;
        }
        return digits;

    }
}
