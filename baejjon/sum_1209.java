package gwonjihun.baejjon;

import java.util.Scanner;
import java.io.FileInputStream;
public class sum_1209 {
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

		/*
		   ?��?�� 개의 ?��?��?�� �??��?���? 주어�?�?�?, 각각?�� 처리?��?��?��.
		*/
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt();
            int max_sum = 0;
            int[][] arr = new int[100][100];
//          ?��?��?�� 먼�? ?��?��?��
            for(int i=0;i<100;i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                   }
            }
            // 2�? ?��문을 ?��?��?��?��?�� 2�? ?��리는거는 ?��간이 ?��?��걸림
            for(int i=0;i<100;i++) {
                int x_sum =0, y_sum = 0;
                for (int j = 0; j < 100; j++) {
                    x_sum+=arr[i][j];
                    y_sum+=arr[j][i];
                }
                max_sum = Math.max(max_sum,Math.max(y_sum,x_sum));
            }
            int left_sum=0,right_sum = 0;
            for(int i=0;i<100;i++){
                left_sum+=arr[i][i];
                right_sum+=arr[i][arr.length-1-i];
            }
            max_sum=Math.max(max_sum,Math.max(left_sum,right_sum));

            System.out.println("#"+test_case+" "+max_sum);
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 ?�� �?분에 ?��?��분의 ?��고리�? 구현?�� ?��?��갑니?��.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}
