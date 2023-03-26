package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_2669 {
    static int[][] arr = new int[100][100];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;

        for(int T = 0;T<4;T++){
            int sx,sy,ex,ey;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            for(int i = sx-1;i<ex-1;i++){
                for(int j = sy-1;j<ey-1;j++){
                    if (arr[i][j]!=1){
                    arr[i][j]=1;
                    cnt++;
                    }
                }
            }

        }

        System.out.println(cnt);
    }
}
