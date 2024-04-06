package common;

import java.util.ArrayList;
//import java.util.HashSet;
//不能重复的，要是有重复的单词就不行！！！
import java.util.List;

class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
            int s_len=s.length();
            int word_num=words.length;
            int word_size=words[0].length();
            int window_size=word_size*word_num;

        List<Integer>answer=new ArrayList<>();


        if(window_size>s_len)
            return answer;

            //针对超时
        boolean all_equal=true;

        for(int i=1;i<word_num;i++){
            if(!words[i].equals(words[0])){
                all_equal=false;
                break;
            }
        }

        for(int i=1;i<word_num;i++)
        {
            if(!words[i].equals(words[1]))
            {
                all_equal=false;
                break;
            }
        }

        if(all_equal) {
            char ch1 = words[0].charAt(0);
            for (int i = 0; i < s_len; i++) {
                if (ch1 == s.charAt(i))
                    answer.add(i);
                else {
                    answer.clear();
                    break;
                }
                //System.out.println(i);

            }

            if (!answer.isEmpty()) {
                int delete=s_len-1;
                while(delete>s_len-word_num*word_size){
                    //System.out.println(delete);
                    answer.remove(delete--);
                }
                return answer;
            }
        }



            //定义滑动窗口的边界：
            int begin=0;//是一个闭区间[]
            int end=window_size;//是一个开区间()
            //HashSet<Integer>flag=new HashSet<>();
            int[]flag=new int[word_num];

            boolean successful;
            String temp;
           int index;//s匹配时单词的索引
            //窗口开始滑动，此时已经有边界了！
            while(end<=s_len){

                //先初始化这个标记的哈希表！
                init_flag(flag,word_num);
              //在窗口里截取和单词长度相同的字符串，
                for( index=0;index<word_num;index++){
                    if(begin+(index+1)*word_size>s.length())
                        break;
                    temp=s.substring(begin+index*word_size,begin+(index+1)*word_size);
                    //并与words里面的单词逐个比较。
                    successful=false;
                    for(int i=0;i<word_num;i++){
                        if(temp.equals(words[i]))
                        {
                            if(flag[i]==0)
                            flag[i]=1;
                            else
                                continue;
                            successful=true;
                                break;

                        }
                    }
                    if(!successful)
                        break;
                }
                int sum=0;
                for(int i=0;i<word_num;i++)
                    sum+=flag[i];
                 if(sum==word_num){
                    answer.add(begin);
                    begin++;
                    end++;
                }else{
                    begin++;
                    end++;
                }
            }
        return answer;
    }
    //重置哈希表。
    public void init_flag(int[]flag,int len){
        for(int i=0;i<len;i++)
            flag[i]=0;
    }
}
/*
//运行时间21ms的优秀代码！！
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordCnt = words.length;
        int wordLength = words[0].length();
        // 特殊条件判断
        if (s.length() < wordCnt * wordLength) {
            return res;
        }

        // 统计words 中每个单词的数量
        Map<String, Integer> wordCntMap = new HashMap<>();
        for (String word :words) {
            wordCntMap.put(word, wordCntMap.getOrDefault(word, 0) + 1);
        }

        int sLen = s.length();
        for (int i = 0; i < wordLength; i++) {

            // 临时单词存储
            Map<String, Integer> tmp = new HashMap<>();

            for (int j = i; j + wordLength <= sLen; j = j + wordLength) {
                String curWord = s.substring(j, j + wordLength);
                tmp.put(curWord, tmp.getOrDefault(curWord, 0) + 1);

                // 这里还需要判断 是否需要删除前面加入的单词,即，当前的单词已经超出了滑动窗口，需要将滑动窗口后移，那么窗口左侧的单词就要删除
                if (j >= i + (wordCnt * wordLength)) {
                    int idx = j - wordCnt * wordLength;
                    String pre = s.substring(idx, idx + wordLength);
                    if (tmp.get(pre) == 1) {
                        tmp.remove(pre);
                    } else {
                        tmp.put(pre, tmp.get(pre) - 1);
                    }
                    // pre 单词变动，如果这两个数量不同，不用比较两个 map
                    if (!tmp.getOrDefault(pre, 0).equals(wordCntMap.getOrDefault(pre, 0))) {
                        continue;
                    }
                }

                // 当前 curWord 是是否相同
                if (!tmp.getOrDefault(curWord, 0).equals(wordCntMap.getOrDefault(curWord, 0))) {
                    continue;
                }

                // 比较两个map是否相同
                if (wordCntMap.equals(tmp)) {
                    res.add(j - wordCnt * wordLength + wordLength);
                }
            }
        }

        return res;
    }
}
* */