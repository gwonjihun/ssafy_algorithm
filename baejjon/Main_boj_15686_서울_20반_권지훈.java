package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main_boj_15686_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {



        static int N, M;
        static int[][] map;
        static ArrayList<Point> person;
        static ArrayList<Point> chicken;
        static int ans;
        static boolean[] open;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            person = new ArrayList<>();
            chicken = new ArrayList<>();

            // ë¯¸ë¦¬ ì§‘ê³¼ ì¹˜í‚¨ì§‘ì— ?•´?‹¹?•˜?Š” ì¢Œí‘œë¥? ArrayList?— ?„£?–´ ?‘ .
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 1) {
                        person.add(new Point(i, j));
                    } else if (map[i][j] == 2) {
                        chicken.add(new Point(i, j));
                    }
                }
            }

            ans = Integer.MAX_VALUE;
            open = new boolean[chicken.size()];

            DFS(0, 0);
            bw.write(ans + "\n");
            bw.flush();
            bw.close();
            br.close();
        }

        public static void DFS(int start, int cnt) {
            if (cnt == M) {
                int res = 0;

                for (int i = 0; i < person.size(); i++) {
                    int temp = Integer.MAX_VALUE;

                    // ?–´?–¤ ì§‘ê³¼ ì¹˜í‚¨ì§? ì¤? open?•œ ì¹˜í‚¨ì§‘ì˜ ëª¨ë“  ê±°ë¦¬ë¥? ë¹„êµ?•œ?‹¤.
                    // ê·? ì¤?, ìµœì†Œ ê±°ë¦¬ë¥? êµ¬í•œ?‹¤.
                    for (int j = 0; j < chicken.size(); j++) {
                        if (open[j]) {
                            int distance = Math.abs(person.get(i).x - chicken.get(j).x)
                                    + Math.abs(person.get(i).y - chicken.get(j).y);

                            temp = Math.min(temp, distance);
                        }
                    }
                    res += temp;
                }
                ans = Math.min(ans, res);
                return;
            }

            // ë°±íŠ¸?˜?‚¹
            for (int i = start; i < chicken.size(); i++) {
                open[i] = true;
                DFS(i + 1, cnt + 1);
                open[i] = false;
            }
        }

    }


