package gwonjihun.baejjon;
import java.util.Scanner;
import java.io.*;


public class sds_algorithm_1_dfs {
    public static void main(String args[]) throws Exception
    {
		/*
		   ?��?��?�� 메소?�� ?��출�? ?��?���? ?���? ?��?��(?��보드) ???�� input.txt ?��?��로�??�� ?��?��?��겠다?�� ?��미의 코드?��?��?��.
		   ?��?��분이 ?��?��?�� 코드�? ?��?��?�� ?�� ?��, ?��?���? ?��?��?�� input.txt?�� ?��?��?�� ???��?�� ?��,
		   ?�� 코드�? ?��로그?��?�� 처음 �?분에 추�??���? ?��?�� ?��?��?�� ?��?��?�� ?�� ?���? ?��?�� ???�� ?��?��로�??�� ?��?��?�� 받아?�� ?�� ?��?��?��?��.
		   ?��?��?�� ?��?��?���? ?��?��?�� ?��?��?�� ?��?�� 주석?�� �??���? ?�� 메소?���? ?��?��?��?��?�� 좋습?��?��.
		   ?��, 채점?�� ?��?�� 코드�? ?��출하?�� ?��?��?�� 반드?�� ?�� 메소?���? �??��거나 주석 처리 ?��?��?�� ?��?��?��.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ?���??��?�� System.in ?��로�??�� ?��캐너�? 만들?�� ?��?��?���? ?��?��?��?��?��.
		 */
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=sc.nextInt();
        /*
		   ?��?�� 개의 ?��?��?�� �??��?���? 주어�?�?�?, 각각?�� 처리?��?��?��.
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
				 ?�� �?분에 ?��?��분의 ?��고리�? 구현?�� ?��?��갑니?��.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}
