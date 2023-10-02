package gwonjihun.baejjon;
import java.io.*;
import java.util.*;
// 84% 널포인터 에러 뭔데 .?
public class Main_boj_1107 {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		boolean[] broken = new boolean[10];
		if(n>0) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i <n;i++) {
			int s  = Integer.parseInt(st.nextToken());
			broken[s]= true;
		}
		}
		//기본적인 max값은 시작에서 target까지 +1하는거야.
		int result = Math.abs(target - 100); //초기값 설정
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            
            boolean isBreak = false;
            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) { //고장난 버튼을 눌러야 하면
                    isBreak = true; 
                    break; //더 이상 탐색하지 않고 빠져나온다.
                }
            }
            if(!isBreak) { //i를 누를때 고장난 버튼을 누르지 않는다면
                int min = Math.abs(target - i) + len; //i를 누른 후(len) target까지 이동하는 횟수(target - i)
                result = Math.min(min, result);
            }
        }        
        System.out.println(result);
    }
}
