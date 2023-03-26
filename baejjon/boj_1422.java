package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1422 {

	/*
	 * 1. string builder�? ?��?��?��?�� 문자?��?�� ?���? 결합?��주며, 결합?�� string객채 ?��?��?�� ???��?��
	 * 2. ?���? 감소�? ?��?��?��?��
	 * 3. 기존 받�? 값들?�� ?��?��?���??��.
	 * 4. 1,2,3,4,5,6,7,9?���? 9�??�� 먼�??��주다�? ?��?�� 받�? ?��?��값을?�� 목록?��?��  n-1개�?? 추후?�� ?���?
	 * 5. 10?��?��?��?��?��..
	 * 6. 9 10 100?���? 결국 2?���? ?��?��?�� ?��?���? -> 1?��리�??�� ?��거�??�� ?��?���??��
	 * 7. -> ?��리수�? 짧�?�? �??�� ?��?��주는?�� 같�? ?��리수?��?��?�� ?�� 값을 먼�? ?��?���??��.
	 * */
	// 
//	192, 80,20 4
//  99 88 7 9
	// 99 9 99 99 99 9 88 7 
// 100 80 90 10 1 9  2�?
// 99080
//	6 7 8 9 10 60 70 80 90 100 200 300
//	98
//	990
//	8020192192
//	그리?�� --> ?��?�� 방식?��?�� 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] arr = new String[K];
        int max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = br.readLine();
            max = Math.max(max, Integer.parseInt(arr[i]));
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        boolean flag = true;

        StringBuilder answer = new StringBuilder();
        for (String t : arr) {
            answer.append(t);
            if (max == Integer.parseInt(t) && flag) {
                for (int i = K; i < N; i++) {
                    answer.append(t);
                    flag = false;
                }
            }
        }

        System.out.println(answer);
    }
}

