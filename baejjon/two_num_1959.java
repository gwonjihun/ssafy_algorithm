package gwonjihun.baejjon;

import java.util.Scanner;
public class two_num_1959 {
    public static void main(String args[]) throws Exception
    {
		/*
		   ?��?��?�� 메소?�� ?��출�? ?��?���? ?���? ?��?��(?��보드) ???�� input.txt ?��?��로�??�� ?��?��?��겠다?�� ?��미의 코드?��?��?��.
		   ?��?��분이 ?��?��?�� 코드�? ?��?��?�� ?�� ?��, ?��?���? ?��?��?�� input.txt?�� ?��?��?�� ???��?�� ?��,
		   ?�� 코드�? ?��로그?��?�� 처음 �?분에 추�??���? ?��?�� ?��?��?�� ?��?��?�� ?�� ?���? ?��?�� ???�� ?��?��로�??�� ?��?��?�� 받아?�� ?�� ?��?��?��?��.
		   ?��?��?�� ?��?��?���? ?��?��?�� ?��?��?�� ?��?�� 주석?�� �??���? ?�� 메소?���? ?��?��?��?��?�� 좋습?��?��.
		   ?��, 채점?�� ?��?�� 코드�? ?��출하?�� ?��?��?�� 반드?�� ?�� 메소?���? �??��거나 주석 처리 ?��?��?�� ?��?��?��.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ?���??��?�� System.in ?��로�??�� ?��캐너�? 만들?�� ?��?��?���? ?��?��?��?��?��.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   ?��?�� 개의 ?��?��?�� �??��?���? 주어�?�?�?, 각각?�� 처리?��?��?��.
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
