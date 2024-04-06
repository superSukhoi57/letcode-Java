package verify;

import java.util.ArrayList;
import java.util.List;

public class List的元素是否按添加顺序排列 {
    public void work(){
        List<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);

        int len= list.size();
        for(int i=0;i<len;i++)
            System.out.printf("%d ",list.get(i));
    }

    public static void main(String[] args) {
        List的元素是否按添加顺序排列 result=new List的元素是否按添加顺序排列();
        result.work();
    }
}


//综上所述，List的元素按添加的顺序排列！！！！而且元素可以重复！