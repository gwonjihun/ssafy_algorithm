package gwonjihun.baekjjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1422 {

	/*
	 * 1. string builder를 활용해서 문자들을 쉽게 결합해주며, 결합시 string객채 생성에 대해서
	 * 2. 시간 감소를 유도한다
	 * 3. 기존 받은 값들을 정렬해준다.
	 * 4. 1,2,3,4,5,6,7,9이면 9부터 먼저써주다가 입력 받은 입력값을의 목록에서  n-1개를 추후에 넣고
	 * 5. 10이상일때는..
	 * 6. 9 10 100이면 결국 2자리 이상이 있으면 -> 1자리부터 큰거부터 넣어준다
	 * 7. -> 자리수가 짧은거 부터 넣어주는데 같은 자리수에서는 큰 값을 먼저 넣어준다.
	 * */
	// 
//	192, 80,20 4
//  99 88 7 9
	// 99 9 99 99 99 9 88 7 
// 100 80 90 10 1 9  2개
// 99080
//	6 7 8 9 10 60 70 80 90 100 200 300
//	98
//	990
//	8020192192
//	그리드 --> 어떤 방식이냐 

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

