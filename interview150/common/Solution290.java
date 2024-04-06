package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        int len_p=pattern.length(),len_s=s.length()-1;
        int original_len_s=len_s+1;
        List<String>strs=new ArrayList<>();
        HashMap<Character,String>map=new HashMap<>();
        int start=0,end=0;

        //对s做预处理，将s首位的空格去掉！
        while(s.charAt(start)==' ')
            start++;
        while(s.charAt(len_s)==' ')
            len_s--;

        //截取单词添加进列表
        end=start;
        while(end<=len_s){
            while(end<original_len_s&&s.charAt(end)!=' ')
                end++;
            strs.add(s.substring(start,end));
            while(end<original_len_s&&s.charAt(end)==' ')
                end++;
            start=end;
        }

//        for(int i=0;i<strs.size();i++)
//            System.out.printf("%s ",strs.get(i));

        if(len_p!=strs.size())
            return false;

        //进行映射。
        for(start=0;start<len_p;start++){
            if(!map.containsKey(pattern.charAt(start))){
                /*if(!map.containsKey(pattern.charAt(start))&&!map.containsValue(strs.get(start)))
            这种判断条件不行，当存在value时，这个映射是不会加入hash的，所以在下面从hash回去元素时会报错！！*/
                if(map.containsValue(strs.get(start)))
                    return false;
                map.put(pattern.charAt(start),strs.get(start));
                continue;
            }
            if(!map.get(pattern.charAt(start)).equals( strs.get(start)))//忘记字符串比较是用equals了！！
                return false;
        }
        return  true;
    }
}
/*
//别人的代码，用两个哈希表，键值对相反来处理。。
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character , String> ch2str = new HashMap<Character , String>();
        Map<String , Character> str2ch = new HashMap<String , Character>();
        int n1 = s.length();
        int n2 = pattern.length();
        int i = 0;
        for(int k = 0; k < n2; ++k)
        {
            char ch = pattern.charAt(k);
            if(i >= n1)
            {
                return false;
            }
            int j = i;
            while(j < n1 && s.charAt(j) != ' ')
            {
                j++;
            }
            String com = s.substring(i , j);
            if((ch2str.containsKey(ch) && !com.equals(ch2str.get(ch))) || (str2ch.containsKey(com) && str2ch.get(com) != ch))
            {
                return false;
            }
            ch2str.put(ch , com);
            str2ch.put(com , ch);
            i = j + 1;
        }
        return i >= n1;
}
}
 */