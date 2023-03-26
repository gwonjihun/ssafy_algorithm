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
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		   ?��?�� 개의 ?��?��?�� �??��?���? 주어�?�?�?, 각각?�� 처리?��?��?��.*/

        for(int test_case = 1; test_case <= 10; test_case++)
        {

            n = bf.readLine();
            arr = new int [16][16];
            visitied = new int [16][16];
//          초기 그래?�� ?��?��
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
