package common;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution49
{
    public List<List<String>> groupAnagrams(String[] strs) {
            int strs_num=strs.length;
            int word_size;
        HashMap<Character,Integer>[]maps=new HashMap[strs_num];//创建了HashMap数组但是没初始化！
        //HashMap<Character,Integer>temp;
        int i,j;
        char ch;
        //为每个字符串数组创建哈希表。
        for(i=0;i<strs_num;i++)
        {
            maps[i]=new HashMap<>();//要初始化，要不然就会报错！！
            word_size=strs[i].length();
            for(j=0;j<word_size;j++){
                ch=strs[i].charAt(j);
                if(!maps[i].isEmpty()&&maps[i].containsKey(ch)){
                    //如果存在这个键的映射就将统计数加一，否则就新建哪个映射且初始值为1！
                    maps[i].put(ch,maps[i].get(ch)+1);
                }else
                maps[i].put(ch,1);
            }

        }
        List<HashMap<Character,Integer>>temp=new ArrayList<>();
        temp.add(maps[0]);

        List<List<String>>answer=new ArrayList<>();
        List<String>inner=new ArrayList<>();
        inner.add(strs[0]);
        answer.add(inner);


        int temp_size;
       for(i=1;i<strs_num;i++){
            temp_size=temp.size();
            for(j=0;j<temp_size;j++){
                if(maps[i].equals(temp.get(j))){
                    answer.get(j).add(strs[i]);
                    break;
                }
            }
            if(j==temp_size)
            {
                //这种情况就是要另开一个
                inner=new ArrayList<>();
                inner.add(strs[i]);
                answer.add(inner);
                temp.add(maps[i]);
            }
       }

        return answer;
    }

}

/*

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        return new AbstractList<List<String>>() {

            private final List<List<String>> list = new ArrayList<>();

            public void initList() {
                if (list.isEmpty()) {
                    Map<String, List<String>> map = new HashMap();
                    for(String s:strs){
            char[] cc=s.toCharArray();
            Arrays.sort(cc);
            String key =Arrays.toString(cc);
            List<String>list=map.getOrDefault(key, new ArrayList());
            list.add(s);
            map.put(key,list);
        }
                    list.addAll(map.values());
                }
            }

            @Override
            public List<String> get(int index) {
                initList();
                return list.get(index);
            }

            @Override
            public int size() {
                initList();
                return list.size();
            }
        };
    }
}
 */
