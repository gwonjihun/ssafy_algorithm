package algorithm;

import java.util.Scanner;
import java.util.LinkedList; //import
import java.util.Queue; //import

public class square_1861_bfs_fail {
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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
//                  시작 인덱스 값
                    int temp = arr[i][j];
//                  시작 인덱스 카운드 값
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
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            System.out.printf("#%d %d %d\n",test_case,index,max_count);
        }
    }
}
