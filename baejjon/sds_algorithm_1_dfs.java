package gwonjihun.baejjon;
import java.util.Scanner;
import java.io.*;


public class sds_algorithm_1_dfs {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=sc.nextInt();
        /*
		   ?¬?¬ κ°μ ??€?Έ μΌ??΄?€κ°? μ£Όμ΄μ§?λ―?λ‘?, κ°κ°? μ²λ¦¬?©??€.
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
				 ?΄ λΆ?λΆμ ?¬?¬λΆμ ?κ³ λ¦¬μ¦? κ΅¬ν?΄ ?€?΄κ°λ?€.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}
