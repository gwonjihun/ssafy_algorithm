package gwonjihun.baejjon;

import java.util.Scanner;
import java.util.LinkedList; //import
import java.util.Queue; //import

public class square_1861_bfs_fail {
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
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
		/*
		   ?¬?¬ κ°μ ??€?Έ μΌ??΄?€κ°? μ£Όμ΄μ§?λ―?λ‘?, κ°κ°? μ²λ¦¬?©??€.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int index=100000, max_count = 0;
            for(int i=0;i<N;i++){
                for(int j=0; j<N ; j++){
                    arr[i][j]= sc.nextInt();
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0; j<N ; j++){
//                  ?? ?Έ?±?€ κ°?
                    int temp = arr[i][j];
//                  ?? ?Έ?±?€ μΉ΄μ΄? κ°?
                    int max_c = 1;
                    Queue<Integer[]> q = new LinkedList<>();
                    q.add(new Integer[] {i,j});
                    while (q.size()!=0){
                        int x = q.peek()[0];
                        int y = q.peek()[1];
                        q.poll();

                        for(int k=0;k<4;k++){
                            int nx = x+dx[k];
                            int ny = y+dy[k];

                            if( (0<= nx && nx <N) && (0<=ny && ny<N)){
                                if (arr[x][y] == (arr[nx][ny]+1)){
//                                    System.out.printf(x +" "+y +"\n");
                                    max_c = Math.max(max_c, (Math.abs(i-nx) + Math.abs(j-ny)+1));
//                                    System.out.printf("!!!!!!!!!" + max_c+"\n");
                                    q.add(new Integer[] {nx,ny});
                                }
                            }
                        }

                    }
                    if(max_c >= max_count){
                        max_count=max_c;
                        if(max_c==max_count) {
                            index = Math.min(index, temp);
                        }else{ index = temp;}
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
}
