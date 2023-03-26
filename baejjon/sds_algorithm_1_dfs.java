package gwonjihun.baejjon;
import java.util.Scanner;
import java.io.*;


public class sds_algorithm_1_dfs {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=sc.nextInt();
        /*
		   ?—¬?Ÿ¬ ê°œì˜ ?…Œ?Š¤?Š¸ ì¼??´?Š¤ê°? ì£¼ì–´ì§?ë¯?ë¡?, ê°ê°?„ ì²˜ë¦¬?•©?‹ˆ?‹¤.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            sc.nextLine();
            char[][] arr = new char[X][Y];
            boolean[][] vis = new boolean[X][Y];

            for(int i=0;i<X;i++){
                String line = br.readLine();
                System.out.println(line);
                for(int j=0;j<Y;j++){
                    arr[i][j] = line.charAt(j);
                    vis[i][j] = false;
                }
            }
            for(int i=0;i<X;i++){
                for(int j=0;j<Y;j++){
                    System.out.println(vis[i][j]);
                }
            }/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 ?´ ë¶?ë¶„ì— ?—¬?Ÿ¬ë¶„ì˜ ?•Œê³ ë¦¬ì¦? êµ¬í˜„?´ ?“¤?–´ê°‘ë‹ˆ?‹¤.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}
