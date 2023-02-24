package gwonjihun.baekjjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_16953_서울_20반_권지훈 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (A != B){
            if (B < A) {
                System.out.println(-1);
                System.exit(0);
            }
            if (B % 10 == 1) B /= 10;
            else if (B % 2 == 0) B /= 2;
            else {
                System.out.println(-1);
                System.exit(0);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
