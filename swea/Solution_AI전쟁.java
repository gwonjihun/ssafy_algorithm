package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_AI전쟁 {
    static int n;
    static int result;
    static int[][] agents;
    static int[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // 최정예 요원의 수 입력
            n = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;

            // 최정예 요원들의 능력치를 저장할 배열
            agents = new int[n][3];
            visited = new int[3];
            // 최정예 요원들의 능력치 입력
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    agents[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 갤럭시를 가동할 수 있는지 확인하고 소멸되는 능력치를 최소화
            dfs(0,0);

            // 출력
            System.out.println("#" + (i + 1) + " " + (result== Integer.MAX_VALUE? -1 : result));
        }
    }

    static void dfs(int depth, int sum){
        if(sum>result){
            //손실값이 더 커지는 경우는 필요가 없기 떄문에 중단한다.
            return;
        }
        if(depth == n){
            //n개를 모두 선택한 경우
            for(int i = 0 ; i <3 ;i++){
                //여기의 경우에서는 3개의 능력치 중 하나라도 공유가 안된 경우 중단한다.
                if(visited[i]==0){
                    return;
                }
            }
            result = Math.min(sum,result);
            return;
        }

        for(int i = 0 ; i < 3; i++){
            visited[i]+=1;
            int temp = 0;
            for(int j = 0 ; j < 3;j++){
                if(i==j) continue;
                temp += agents[depth][j];
            }
            dfs(depth+1,sum+temp);
            visited[i]-=1;
        }

    }
}