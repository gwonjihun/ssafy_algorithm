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
        int T;
        T=sc.nextInt();
		/*
		   ?—¬?Ÿ¬ ê°œì˜ ?…Œ?Š¤?Š¸ ì¼??´?Š¤ê°? ì£¼ì–´ì§?ë¯?ë¡?, ê°ê°?„ ì²˜ë¦¬?•©?‹ˆ?‹¤.
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
				 ?´ ë¶?ë¶„ì— ?—¬?Ÿ¬ë¶„ì˜ ?•Œê³ ë¦¬ì¦? êµ¬í˜„?´ ?“¤?–´ê°‘ë‹ˆ?‹¤.
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
