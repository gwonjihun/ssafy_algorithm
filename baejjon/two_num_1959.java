package gwonjihun.baejjon;

import java.util.Scanner;
public class two_num_1959 {
    public static void main(String args[]) throws Exception
    {
		/*
		   ?•„?ž˜?˜ ë©”ì†Œ?“œ ?˜¸ì¶œì? ?•ž?œ¼ë¡? ?‘œì¤? ?ž…? ¥(?‚¤ë³´ë“œ) ???‹  input.txt ?ŒŒ?¼ë¡œë??„° ?½?–´?˜¤ê² ë‹¤?Š” ?˜ë¯¸ì˜ ì½”ë“œ?ž…?‹ˆ?‹¤.
		   ?—¬?Ÿ¬ë¶„ì´ ?ž‘?„±?•œ ì½”ë“œë¥? ?…Œ?Š¤?Š¸ ?•  ?•Œ, ?Ž¸?˜ë¥? ?œ„?•´?„œ input.txt?— ?ž…? ¥?„ ???ž¥?•œ ?›„,
		   ?´ ì½”ë“œë¥? ?”„ë¡œê·¸?ž¨?˜ ì²˜ìŒ ë¶?ë¶„ì— ì¶”ê??•˜ë©? ?´?›„ ?ž…? ¥?„ ?ˆ˜?–‰?•  ?•Œ ?‘œì¤? ?ž…? ¥ ???‹  ?ŒŒ?¼ë¡œë??„° ?ž…? ¥?„ ë°›ì•„?˜¬ ?ˆ˜ ?žˆ?Šµ?‹ˆ?‹¤.
		   ?”°?¼?„œ ?…Œ?Š¤?Š¸ë¥? ?ˆ˜?–‰?•  ?•Œ?—?Š” ?•„?ž˜ ì£¼ì„?„ ì§??š°ê³? ?´ ë©”ì†Œ?“œë¥? ?‚¬?š©?•˜?…”?„ ì¢‹ìŠµ?‹ˆ?‹¤.
		   ?‹¨, ì±„ì ?„ ?œ„?•´ ì½”ë“œë¥? ? œì¶œí•˜?‹¤ ?•Œ?—?Š” ë°˜ë“œ?‹œ ?´ ë©”ì†Œ?“œë¥? ì§??š°ê±°ë‚˜ ì£¼ì„ ì²˜ë¦¬ ?•˜?…”?•¼ ?•©?‹ˆ?‹¤.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ?‘œì¤??ž…? ¥ System.in ?œ¼ë¡œë??„° ?Š¤ìºë„ˆë¥? ë§Œë“¤?–´ ?°?´?„°ë¥? ?½?–´?˜µ?‹ˆ?‹¤.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   ?—¬?Ÿ¬ ê°œì˜ ?…Œ?Š¤?Š¸ ì¼??´?Š¤ê°? ì£¼ì–´ì§?ë¯?ë¡?, ê°ê°?„ ì²˜ë¦¬?•©?‹ˆ?‹¤.
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
