package algorithm;

import java.util.Scanner;
public class two_num_1959 {
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int tc = 1; tc <= T; tc++)
        {
            int a = sc.nextInt();
            int[] arr_s = new int[a];
            int b = sc.nextInt();
            int[] arr_l = new int[b];
            long max_result = 0L;
            for(int i=0; i<a; i++){
                arr_s[i]= sc.nextInt();
            }
            for(int i=0; i<b; i++){
                arr_l[i]= sc.nextInt();
            }
            if(a>b){
                for(int i=0;i<a-b+1;i++){
                    long total = 0;
                    for(int j=0;j<b;j++){
                        total += arr_s[i+j]*arr_l[j];
                    }
                    max_result = Math.max(max_result,total);
                }
            }else if (a<b){
                for(int i=0;i<b-a+1;i++){
                    long total = 0;
                    for(int j=0;j<a;j++){
                        total += arr_l[i+j]*arr_s[j];
                    }
                    max_result = Math.max(max_result,total);
                }
            }else{
                long total = 0;
                for(int i = 0; i<a;i++){
                    total += arr_s[i]*arr_l[i];
                }
                max_result= Math.max(max_result,total);

            }

            System.out.printf("#%d %d\n",tc,max_result);
        }
    }
}
