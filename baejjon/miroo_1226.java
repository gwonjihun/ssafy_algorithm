package gwonjihun.baejjon;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.Queue;
public class miroo_1226 {
    static int[][] arr;
    static int[][] visitied;
    static String n;
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
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		   ?¬?¬ κ°μ ??€?Έ μΌ??΄?€κ°? μ£Όμ΄μ§?λ―?λ‘?, κ°κ°? μ²λ¦¬?©??€.*/

        for(int test_case = 1; test_case <= 10; test_case++)
        {

            n = bf.readLine();
            arr = new int [16][16];
            visitied = new int [16][16];
//          μ΄κΈ° κ·Έλ? ?? ₯
            for(int i = 0 ; i< 16; i++) {
                String str = bf.readLine();
                for (int j = 0; j < 16; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            bfs();

        }
    }
    public static void bfs(){
        Queue<Integer[]> q = new LinkedList();
        q.add(new Integer[] {1,1});
        visitied[1][1]= 1;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while(q.size()!=0){
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            if(arr[x][y]==3){
                System.out.printf("#%s 1\n",n);
                return ;
            }
            for(int j=0;j<4;j++){
                int nx = x+dx[j];
                int ny = y + dy[j];

                if(nx<0 || ny <0 || nx>15 || ny >15) continue;
                if(arr[nx][ny]==1)continue;
                if (visitied[nx][ny]==1)continue;
                visitied[nx][ny]=1;
                q.add(new Integer[]{nx,ny});
            }
        }

        System.out.printf("#%s 0\n",n);
    }
}
