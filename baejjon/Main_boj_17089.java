package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_17089 {

    public static void main(String[] args) throws Exception {
        // N 명중 3사람, ABC를 고른다, 세사람은 모두 친구여야 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int inputSize = Integer.parseInt(st.nextToken());

        int[] friends = new int[size + 1];
        int[][] map = new int[size + 1][size + 1];

        for (int i = 0; i < inputSize; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a]++;
            friends[b]++;

            map[a][b] = 1;
            map[b][a] = 1;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (i == j || map[i][j] != 1) continue;
                for (int k = 1; k <= size; k++) {
                    if (i == k || j == k || map[i][k] != 1 || map[j][k] != 1) continue;
                    int value = 0;
                    value += friends[i] - 2;
                    value += friends[j] - 2;
                    value += friends[k] - 2;

                    answer = Math.min(value, answer);
                }
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
