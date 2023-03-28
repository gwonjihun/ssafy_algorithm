package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
public class Main_boj_1911_물웅덩이 {

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine() );
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int []>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int nulpan = 0;	// ?��?��?�� ?��빤�??�� 개수
        int range = 0;	// ?��빤�?�? 물웅?��?��?�� ?��?��?��?��, ?��?�� ?�� ?��?�� 범위
        for(int i=0; i<N; i++) {
            if(arr[i][0] > range)
                range = arr[i][0];
            if(arr[i][1] >= range) {
                while(arr[i][1] > range) {
                    range += L;
                    nulpan ++;
                }
            }
        }

        System.out.println(nulpan);
    }
}
