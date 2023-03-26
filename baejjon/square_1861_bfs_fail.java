package gwonjihun.baejjon;

import java.util.Scanner;
import java.util.LinkedList; //import
import java.util.Queue; //import

public class square_1861_bfs_fail {
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
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
		/*
		   ?��?�� 개의 ?��?��?�� �??��?���? 주어�?�?�?, 각각?�� 처리?��?��?��.
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
//                  ?��?�� ?��?��?�� �?
                    int temp = arr[i][j];
//                  ?��?�� ?��?��?�� 카운?�� �?
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
				 ?�� �?분에 ?��?��분의 ?��고리�? 구현?�� ?��?��갑니?��.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            System.out.printf("#%d %d %d\n",test_case,index,max_count);
        }
    }
}
