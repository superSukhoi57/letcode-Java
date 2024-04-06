package common;

import java.util.HashMap;

public class Solution205
{

        public boolean isIsomorphic(String s, String t) {
                int len_s=s.length(),len_t=t.length();
                if(len_s!=len_t)
                    return false;
                int i;
                HashMap<Character,Character>map=new HashMap<>();
                for(i=0;i<len_s;i++){
                    if(!map.containsKey(s.charAt(i)))
                    {//哈希表里没有这个键的映射就添加进去；
                        //如果这个值已经被映射过了就不能加入哈希表。
                        if(map.containsValue(t.charAt(i)))
                            return false;
                        map.put(s.charAt(i),t.charAt(i));
                        continue;
                    }
                    //哈希表存在这个键的映射就比较：
                    if(map.get(s.charAt(i))!=t.charAt(i))
                        return false;
                }
                return true;
        }

}
