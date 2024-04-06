package common;

class Solution289 {
    public void gameOfLife(int[][] board) {
        int row=board.length;
        int col=board[0].length;
        //创建二维数组
        int [][]answer=new int[row][col];
        int i,j;
        //初始化二维数组
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                answer[i][j]=0;
            }
        }
        //遍历矩阵
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                int num=count(i,j,board);
                if(board[i][j]==1){
                    //此位置是一个活细胞
                    answer[i][j]=1;
                    if(!(num==2||num==3)){
                        //活细胞死亡的条件
                        answer[i][j]=0;
                    }
                }else{
                    //此位置是一个死细胞！
                    if(num==3)
                        answer[i][j]=1;
                }
            }
        }
        //输出答案矩阵,实际上leetcode那里是不用输出的，只需更改传进来的参数即可。
        //see(answer);
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                board[i][j]=answer[i][j];
            }
        }

    }
    private int count(int row,int col,int[][] graph){
        int row_start=row-1,col_start=col-1;
        int row_end=row+1,col_end=col+1;
        int answer=0,i,j;
        int down=graph.length,right=graph[0].length;
        for(i=row_start;i<=row_end&&i<down;i++){
            if(i<0)
                continue;
            for(j=col_start;j<=col_end&&j<right;j++)
            {
                if(j<0)
                    continue;
                answer+=graph[i][j];
            }
        }
        return answer-graph[row][col];
    }
    public void see(int [][]graph){
        int row=graph.length;
        int col=graph[0].length;
        System.out.print('[');
        for(int i=0;i<row;i++){
            System.out.print('[');
            for(int j=0;j<col;j++){
                if(j!=col-1)
                    System.out.printf("%d%c",graph[i][j],',');
                else
                    System.out.printf("%d%c",graph[i][j],']');
            }
            if(i!=row-1)
                System.out.print(',');
            else
                System.out.print(']');
        }
    }
};