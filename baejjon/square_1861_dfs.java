package gwonjihun.baejjon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class square_1861_dfs {

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int cnt;

    public static void main(String args[]) throws Exception
    {
		/*
		   ??? λ©μ? ?ΈμΆμ? ??Όλ‘? ?μ€? ?? ₯(?€λ³΄λ) ???  input.txt ??Όλ‘λ??° ?½?΄?€κ² λ€? ?λ―Έμ μ½λ???€.
		   ?¬?¬λΆμ΄ ??±? μ½λλ₯? ??€?Έ ?  ?, ?Έ?λ₯? ??΄? input.txt? ?? ₯? ???₯? ?,
		   ?΄ μ½λλ₯? ?λ‘κ·Έ?¨? μ²μ λΆ?λΆμ μΆκ??λ©? ?΄? ?? ₯? ???  ? ?μ€? ?? ₯ ???  ??Όλ‘λ??° ?? ₯? λ°μ?¬ ? ??΅??€.
		   ?°?Ό? ??€?Έλ₯? ???  ??? ?? μ£Όμ? μ§??°κ³? ?΄ λ©μ?λ₯? ?¬?©??? μ’μ΅??€.
		   ?¨, μ±μ ? ??΄ μ½λλ₯? ? μΆν?€ ??? λ°λ? ?΄ λ©μ?λ₯? μ§??°κ±°λ μ£Όμ μ²λ¦¬ ???Ό ?©??€.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ?μ€??? ₯ System.in ?Όλ‘λ??° ?€μΊλλ₯? λ§λ€?΄ ?°?΄?°λ₯? ?½?΄?΅??€.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   ?¬?¬ κ°μ ??€?Έ μΌ??΄?€κ°? μ£Όμ΄μ§?λ―?λ‘?, κ°κ°? μ²λ¦¬?©??€.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int index=N*N, max_count = 1;
            for(int i=0;i<N;i++){
                for(int j=0; j<N ; j++){
                    arr[i][j]= sc.nextInt();
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0; j<N ; j++){
                    cnt = 1;
                    dfs(arr,i,j,N,arr[i][j]);
                    if(cnt>=max_count){
                        if(cnt>max_count){
                            max_count=cnt;
                            index=arr[i][j];
                        }else{
                            if(index>arr[i][j]) index =arr[i][j];
                        }
                    }
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 ?΄ λΆ?λΆμ ?¬?¬λΆμ ?κ³ λ¦¬μ¦? κ΅¬ν?΄ ?€?΄κ°λ?€.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            System.out.printf("#%d %d %d\n",test_case,index,max_count);
        }
    }
    public static void dfs(int[][] r, int x, int y, int N, int now_n){
        for(int i =0;i<4; i++){
            int nx= x+dx[i];
            int ny = y+dy[i];
            if((0<=nx && nx<N) && (0<=ny && ny< N) && (r[nx][ny] == now_n+1)){
                cnt++;
                dfs(r,nx,ny,N,now_n+1);
            }
        }
    }
}
