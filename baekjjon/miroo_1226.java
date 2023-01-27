package ssafy_algorithm.baekjjon;

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
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.*/

        for(int test_case = 1; test_case <= 10; test_case++)
        {

            n = bf.readLine();
            arr = new int [16][16];
            visitied = new int [16][16];
//          초기 그래프 입력
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
