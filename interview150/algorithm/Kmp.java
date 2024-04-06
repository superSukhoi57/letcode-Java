package algorithm;

public class Kmp {
    public static void main(String[] args) {
        String str="abaabcac";
        int[]next=null;
        next=get_next(str);
        int len=next.length;
        for(int i=0;i<len;i++)
            System.out.print(next[i]);
    }
    public static int[] get_next(String str){
        int len=str.length(),i,j;
        int[] next=new int[len];
        //initialize
        for(i=0;i<len;i++){
            next[i]=0;
        }
        next[0]=-1;
        i=1;//next数组的起点是1，而且一直向后移动！
        j=0;//j的index是0，代表已经匹配的字符的个数！！！
        while(i<len-1){
            if(j==-1||str.charAt(i)==str.charAt(j))
                next[++i]=++j;
            else
                j=next[j];
        }
        return next;
     }
}

