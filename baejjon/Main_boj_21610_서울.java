package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_21610_?Ñú?ö∏ {
    static class cloud{
        int x;
        int y;
        cloud(int x, int y ){
            this.x =x;
            this.y = y;
        }
    }
    static int[] dx = {0,0,-1,-1,-1,0,1,1,1} , dy = {0,-1,-1,0,1,1,1,0,-1};
    // ??Í∞ÅÏÑ† Ï≤¥ÌÅ¨?ãú 2?ùò Î∞∞ÏàòÎß? Ï≤¥ÌÅ¨?ïú?ã§.
    static int[][] map;
    static boolean[][] v; // Íµ¨Î¶Ñ?ù¥ ?Ç¥?†§?ò® Ïß??ó≠ Ï≤¥ÌÅ¨
    static int N, M ; // N?? Ïß??èÑ?ùò ?Å¨Í∏? M?? Î™ÖÎ†π?ùò Í∞??àò
    static Deque<cloud> q; // Íµ¨Î¶Ñ ???û• Í≥µÍ∞Ñ

    static Deque<int[]> copymagic; // Íµ¨Î¶Ñ ???û• Í≥µÍ∞Ñ
    static int[][] cmds;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        q = new ArrayDeque<>();
        copymagic = new ArrayDeque<>();

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        v = new boolean[N][N];

        M = Integer.parseInt(st.nextToken());

        cmds = new int[M][2]; // 0?? Î∞©Ìñ• 1?? ?ù¥?èô Í±∞Î¶¨

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // Î∞îÍµ¨?ãà Ï¥àÍ∏∞ ?ç∞?ù¥?Ñ∞ ?ûÖ?†•

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine()," ");
            cmds[i][0] = Integer.parseInt(st.nextToken());
            cmds[i][1] = Integer.parseInt(st.nextToken());
        }//Î™ÖÎ†π?ñ¥?ì§ Î≥µÏÇ¨

        q.addLast(new cloud(N-1,0));
        q.addLast(new cloud(N-1,1));
        q.addLast(new cloud(N-2,0));
        q.addLast(new cloud(N-2,1));
        // Ï¥àÍ∏∞ Íµ¨Î¶Ñ ?ûÖ?†•
        for(int m = 0 ; m < M ; m++){
            while(!q.isEmpty()){
                cloud cur = q.pollFirst();
                int nx = (N+ cur.x+ dx[cmds[m][0]]*(cmds[m][1]%N))%N;
                int ny = (N+ cur.y+ dy[cmds[m][0]]*(cmds[m][1]%N))%N;

                map[nx][ny] +=1;
                copymagic.add(new int[] {nx,ny});
                v[nx][ny]=true;
            }
//            for(int[] a : map){
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println("---------ÎπÑÎÇ¥Î¶¨Í∏∞ ?ã®Í≥? ?Åù---------");
            while(!copymagic.isEmpty()){
                int[] cur = copymagic.pollLast();
                for(int i= 2;i<=8;i+=2){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if(0<=nx && nx< N && 0<=ny && ny < N && map[nx][ny]>=1){
                        map[cur[0]][cur[1]] +=1;
                    }
                }
            }
//            for(int[] a : map){
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println("---------Î¨ºÎ≥µ?Ç¨ ?Åù---------");
//            System.out.print("?Ñ†?Éù ?êú Íµ¨Î¶Ñ Î¶¨Ïä§?ä∏ : ");

            for(int i = 0 ; i<N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(!v[i][j] && map[i][j]>=2){
                        q.addLast(new cloud(i,j));
                        map[i][j]-=2;
//                        System.out.print(i + " " + j + " | ");
                    }
                }
            }
//            System.out.println();
//            for(int[] a : map){
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println("---------aÎßàÏ?Îß? ?ã®Í≥? ?Åù---------");
            v= new boolean[N][N];
        }
//        for(int[] a : map){
//            System.out.println(Arrays.toString(a));
//        }
        int cnt = 0 ;
        for(int i = 0 ; i<N ; i++){
            for(int j = 0 ; j < N ; j++) {
            cnt += map[i][j];
            }
        }
        System.out.println(cnt);
    }
}
