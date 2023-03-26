package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

class pair{
    int x;
    int y;
    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution_swTest_?”„ë¡œì„¸?„œ_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
    private static int T, N, size, min;
    private static int arr[][], dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    private static pair core[];
    private static boolean chk[];

    public static void combination(int idx, int cnt, int R) {
        if(cnt == R) {
            dfs(0, 0);
            return;
        }
        for(int i = idx; i < size; i++) {
            chk[i] = true;
            combination(i + 1, cnt + 1, R);
            chk[i] = false;
        }
    }

    public static void dfs(int idx, int cnt) {
        if(idx == size) {
            min = Math.min(min, cnt); // ë°°ì—´ ?ê¹Œì? ?Œ? ¸?œ¼ë©? ?´?•Œ?˜ ìµœì†Ÿê°? ê°±ì‹ 
            return;
        }
        if(!chk[idx]) { // ë¶?ë¶? ì§‘í•©?— ?¬?•¨?˜?Š” ?• ?“¤ë§? ?‹¤?Œ ?‹¨ê³„ë¡œ ?„˜?–´ê°? ?ˆ˜ ?ˆ?‹¤.
            dfs(idx + 1, cnt);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int x = core[idx].x, y = core[idx].y, tmp = 0;
            boolean success = false;
            while(true) {
                x += dx[i]; y += dy[i];
                if(x < 0 || x >= N || y < 0 || y >= N) { // ë²”ìœ„ ?ê¹Œì? ê°”ìœ¼ë©? ?„±ê³?
                    success = true;
                    break;
                }
                if(arr[x][y] != 0) break; // ? „?„ ?´?‚˜ ì½”ì–´ë¥? ë§Œë‚˜ë©? ?‹¤?Œ¨
                arr[x][y] = 2; // ? „?„  ?‘œ?‹œ
                tmp++; // ? „?„  ê¸¸ì´ ?•©
            }
            if(success) dfs(idx + 1, cnt + tmp);
            while(true) { // ?› ?ƒ?ƒœë¡? ?Œ? ¤?†“ê¸?
                x -= dx[i]; y -= dy[i];
                if(x == core[idx].x && y == core[idx].y) break;
                arr[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            arr = new int[N][N]; core = new pair[12]; chk = new boolean[12];
            size = 0; min = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) arr[i][j] = sc.nextInt();
            for(int i = 1; i < N - 1; i++) for(int j = 1; j < N - 1; j++) if(arr[i][j] == 1) core[size++] = new pair(i, j); // ê°??¥?ë¦? ë¹¼ê³ 

            for(int i = size; i >= 0; i--) {
                combination(0, 0, i);
                if(min < Integer.MAX_VALUE) break; // ìµœì†Ÿê°’ì´ ê°±ì‹ ?˜?–´ ?ˆ?œ¼ë©? ê²°ê³¼ê°? ?‚˜?™”?‹¤?Š” ?œ»?„
            }

            System.out.println("#" + t + " " + min);
        }
    }
}

