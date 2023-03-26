package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1422 {

	/*
	 * 1. string builderÎ•? ?ôú?ö©?ï¥?Ñú Î¨∏Ïûê?ì§?ùÑ ?âΩÍ≤? Í≤∞Ìï©?ï¥Ï£ºÎ©∞, Í≤∞Ìï©?ãú stringÍ∞ùÏ±Ñ ?Éù?Ñ±?óê ???ï¥?Ñú
	 * 2. ?ãúÍ∞? Í∞êÏÜåÎ•? ?ú†?èÑ?ïú?ã§
	 * 3. Í∏∞Ï°¥ Î∞õÏ? Í∞íÎì§?ùÑ ?†ï?†¨?ï¥Ï§??ã§.
	 * 4. 1,2,3,4,5,6,7,9?ù¥Î©? 9Î∂??Ñ∞ Î®ºÏ??ç®Ï£ºÎã§Í∞? ?ûÖ?†• Î∞õÏ? ?ûÖ?†•Í∞íÏùÑ?ùò Î™©Î°ù?óê?Ñú  n-1Í∞úÎ?? Ï∂îÌõÑ?óê ?Ñ£Í≥?
	 * 5. 10?ù¥?ÉÅ?ùº?ïå?äî..
	 * 6. 9 10 100?ù¥Î©? Í≤∞Íµ≠ 2?ûêÎ¶? ?ù¥?ÉÅ?ù¥ ?ûà?úºÎ©? -> 1?ûêÎ¶¨Î??Ñ∞ ?Å∞Í±∞Î??Ñ∞ ?Ñ£?ñ¥Ï§??ã§
	 * 7. -> ?ûêÎ¶¨ÏàòÍ∞? ÏßßÏ?Í±? Î∂??Ñ∞ ?Ñ£?ñ¥Ï£ºÎäî?ç∞ Í∞ôÏ? ?ûêÎ¶¨Ïàò?óê?Ñú?äî ?Å∞ Í∞íÏùÑ Î®ºÏ? ?Ñ£?ñ¥Ï§??ã§.
	 * */
	// 
//	192, 80,20 4
//  99 88 7 9
	// 99 9 99 99 99 9 88 7 
// 100 80 90 10 1 9  2Í∞?
// 99080
//	6 7 8 9 10 60 70 80 90 100 200 300
//	98
//	990
//	8020192192
//	Í∑∏Î¶¨?ìú --> ?ñ¥?ñ§ Î∞©Ïãù?ù¥?Éê 

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

