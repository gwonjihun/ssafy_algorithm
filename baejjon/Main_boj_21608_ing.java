package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_21608_ing {
	 
    static int n;
    static int[][] map;
    static int[] order;
    static List<Integer>[] list;
    static PriorityQueue<Point> queue = new PriorityQueue<>();
    static int[] y = {1, -1, 0, 0}, x = {0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
 
        map = new int[n + 1][n + 1];
        order = new int[n*n+1];
 
        list = new ArrayList[n*n+1];
 
        for (int i = 1; i <= n*n; i++) {
            list[i] = new ArrayList<>();
        }
 
        for (int i = 1; i <= n * n; i++) {
            String[] s = br.readLine().split(" ");
            order[i] = Integer.parseInt(s[0]);
            for (int j = 1; j < 5; j++) {
                list[Integer.parseInt(s[0])].add(Integer.parseInt(s[j]));
            }
        }
 
 
        for (int i = 1; i <= n * n; i++) {
            solve(order[i]);
            queue.clear();
        }
 
        int result=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                result += getPrice(i,j);
            }
        }
        System.out.println(result);
 
    }
 
    private static int getPrice(int a, int b){
        int num = map[a][b];
 
        int ny, nx, likeCount=0;
        for(Integer now : list[num]){
            for (int i = 0; i < 4; i++) {
                ny = a + y[i];
                nx = b + x[i];
                if (ny >= 1 && ny <= n && nx >= 1 && nx <= n) {
                    if(map[ny][nx]==now){
                        likeCount++;
                    }
                }
            }
        }
        if(likeCount==0){
            return 0;
        }
        else if(likeCount==1){
            return 1;
        }
        else if(likeCount==2){
            return 10;
        }
        else if(likeCount==3){
            return 100;
        }
        else{
            return 1000;
        }
    }
 
    private static void solve(int num) {
 
        int ny, nx;
        int nearCount, likeCount;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                nearCount = 0;
                likeCount = 0;
                if (map[i][j] != 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    ny = i + y[k];
                    nx = j + x[k];
                    if (ny >= 1 && ny <= n && nx >= 1 && nx <= n) {
                        for (Integer now : list[num]) {
                            if (now == map[ny][nx]) {
                                likeCount++;
                            }
                        }
                        if (map[ny][nx] == 0) {
                            nearCount++;
                        }
                    }
                }
                queue.add(new Point(i, j, nearCount, likeCount));
            }
        }
 
        Point poll = queue.poll();
        map[poll.y][poll.x] = num;
    }
}
