package gwonjihun.baekjjon;

import java.util.Scanner;

public class main_boj_17478 {
	static StringBuilder sb = new StringBuilder();

	static void recuir(int n,String s) {
		
		sb.append(s).append("\"재귀함수가 뭔가요?\"\n");
		if(n>0) {
			
			sb.append(s).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			sb.append(s).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			sb.append(s).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
			recuir(n-1,s+"____");
		}
		sb.append(s).append("라고 답변하였지.\n");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		recuir(n,"");
		System.out.print(sb);
	}
	
}
