package gwonjihun.baejjon;

import java.util.Scanner;
public class two_num_1959 {
    public static void main(String args[]) throws Exception
    {
		/*
		   ??? λ©μ? ?ΈμΆμ? ??Όλ‘? ?μ€? ?? ₯(?€λ³΄λ) ???  input.txt ??Όλ‘λ??° ?½?΄?€κ² λ€? ?λ―Έμ μ½λ???€.
		   ?¬?¬λΆμ΄ ??±? μ½λλ₯? ??€?Έ ?  ?, ?Έ?λ₯? ??΄? input.txt? ?? ₯? ???₯? ?,
		   ?΄ μ½λλ₯? ?λ‘κ·Έ?¨? μ²μ λΆ?λΆμ μΆκ??λ©? ?΄? ?? ₯? ???  ? ?μ€? ?? ₯ ???  ??Όλ‘λ??° ?? ₯? λ°μ?¬ ? ??΅??€.
		   ?°?Ό? ??€?Έλ₯? ???  ??? ?? μ£Όμ? μ§??°κ³? ?΄ λ©μ?λ₯? ?¬?©??? μ’μ΅??€.
		   ?¨, μ±μ ? ??΄ μ½λλ₯? ? μΆν?€ ??? λ°λ? ?΄ λ©μ?λ₯? μ§??°κ±°λ μ£Όμ μ²λ¦¬ ???Ό ?©??€.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ?μ€??? ₯ System.in ?Όλ‘λ??° ?€μΊλλ₯? λ§λ€?΄ ?°?΄?°λ₯? ?½?΄?΅??€.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   ?¬?¬ κ°μ ??€?Έ μΌ??΄?€κ°? μ£Όμ΄μ§?λ―?λ‘?, κ°κ°? μ²λ¦¬?©??€.
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
