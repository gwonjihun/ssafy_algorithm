package gwonjihun.baejjon;

import java.util.Scanner;
import java.util.LinkedList; //import
import java.util.Queue; //import

public class square_1861_bfs_fail {
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
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
		/*
		   ?—¬?Ÿ¬ ê°œì˜ ?…Œ?Š¤?Š¸ ì¼??´?Š¤ê°? ì£¼ì–´ì§?ë¯?ë¡?, ê°ê°?„ ì²˜ë¦¬?•©?‹ˆ?‹¤.
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
//                  ?‹œ?‘ ?¸?±?Š¤ ê°?
                    int temp = arr[i][j];
//                  ?‹œ?‘ ?¸?±?Š¤ ì¹´ìš´?“œ ê°?
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
				 ?´ ë¶?ë¶„ì— ?—¬?Ÿ¬ë¶„ì˜ ?•Œê³ ë¦¬ì¦? êµ¬í˜„?´ ?“¤?–´ê°‘ë‹ˆ?‹¤.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            System.out.printf("#%d %d %d\n",test_case,index,max_count);
        }
    }
}
