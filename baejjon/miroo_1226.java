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
		   ?•„?˜?˜ ë©”ì†Œ?“œ ?˜¸ì¶œì? ?•?œ¼ë¡? ?‘œì¤? ?…? ¥(?‚¤ë³´ë“œ) ???‹  input.txt ?ŒŒ?¼ë¡œë??„° ?½?–´?˜¤ê² ë‹¤?Š” ?˜ë¯¸ì˜ ì½”ë“œ?…?‹ˆ?‹¤.
		   ?—¬?Ÿ¬ë¶„ì´ ?‘?„±?•œ ì½”ë“œë¥? ?…Œ?Š¤?Š¸ ?•  ?•Œ, ?¸?˜ë¥? ?œ„?•´?„œ input.txt?— ?…? ¥?„ ???¥?•œ ?›„,
		   ?´ ì½”ë“œë¥? ?”„ë¡œê·¸?¨?˜ ì²˜ìŒ ë¶?ë¶„ì— ì¶”ê??•˜ë©? ?´?›„ ?…? ¥?„ ?ˆ˜?–‰?•  ?•Œ ?‘œì¤? ?…? ¥ ???‹  ?ŒŒ?¼ë¡œë??„° ?…? ¥?„ ë°›ì•„?˜¬ ?ˆ˜ ?ˆ?Šµ?‹ˆ?‹¤.
		   ?”°?¼?„œ ?…Œ?Š¤?Š¸ë¥? ?ˆ˜?–‰?•  ?•Œ?—?Š” ?•„?˜ ì£¼ì„?„ ì§??š°ê³? ?´ ë©”ì†Œ?“œë¥? ?‚¬?š©?•˜?…”?„ ì¢‹ìŠµ?‹ˆ?‹¤.
		   ?‹¨, ì±„ì ?„ ?œ„?•´ ì½”ë“œë¥? ? œì¶œí•˜?‹¤ ?•Œ?—?Š” ë°˜ë“œ?‹œ ?´ ë©”ì†Œ?“œë¥? ì§??š°ê±°ë‚˜ ì£¼ì„ ì²˜ë¦¬ ?•˜?…”?•¼ ?•©?‹ˆ?‹¤.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ?‘œì¤??…? ¥ System.in ?œ¼ë¡œë??„° ?Š¤ìºë„ˆë¥? ë§Œë“¤?–´ ?°?´?„°ë¥? ?½?–´?˜µ?‹ˆ?‹¤.
		 */
        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		   ?—¬?Ÿ¬ ê°œì˜ ?…Œ?Š¤?Š¸ ì¼??´?Š¤ê°? ì£¼ì–´ì§?ë¯?ë¡?, ê°ê°?„ ì²˜ë¦¬?•©?‹ˆ?‹¤.*/

        for(int test_case = 1; test_case <= 10; test_case++)
        {

            n = bf.readLine();
            arr = new int [16][16];
            visitied = new int [16][16];
//          ì´ˆê¸° ê·¸ë˜?”„ ?…? ¥
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
