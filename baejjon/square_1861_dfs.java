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
        int T;
        T=sc.nextInt();
		/*
		   ?��?�� 개의 ?��?��?�� �??��?���? 주어�?�?�?, 각각?�� 처리?��?��?��.
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
				 ?�� �?분에 ?��?��분의 ?��고리�? 구현?�� ?��?��갑니?��.
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
