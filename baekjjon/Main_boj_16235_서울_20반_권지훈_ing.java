package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

class tree {
	int x;
	int y;
	int age;
	tree(int x, int y,int age){
		this.x = x;
		this.y = y;
		this.age = age;

	}

	@Override
	public String toString() {
		return "tree{" +
				"x=" + x +
				", y=" + y +
				", age=" + age +
				'}';
	}
}

public class Main_boj_16235_서울_20반_권지훈_ing {

	public static void main(String[] args) throws Exception{
		
//		long beforeTime = System.currentTimeMillis();
//		long afterTime;
		Deque<tree> die_li = new ArrayDeque<>();
		int[][] arr;
		int N,M,K;
		StringBuilder sb = new StringBuilder();
		Deque<tree> tli = new ArrayDeque<>();
		int eat[][];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] dx = {-1,-1,-1,0,1,1,1,0};
		int[] dy = {-1,0,1,1,1,0,-1,-1};
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N+1][N+1];
		eat = new int[N+1][N+1];
		
		// n*n 10*20 -> 300 
		for(int i=1;i<N+1;i++){
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<N+1;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				eat[i][j]= 5;
				}

			}
		
		// 100
		for(int i = 0;i<tli.size();i++) {
			
		}
		
		
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine()," ");
			tli.add(new tree(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		// 나무 리스트 입력

		// 1000 => 3000
		for(int k=0;k<K;k++){
			//봄
			for(int i = 0; i<tli.size();) {
				tree t = tli.poll();
				if(eat[t.x][t.y]>=t.age) {
					eat[t.x][t.y]-= t.age;
					t.age +=1;//여기서 나이증가시키고 다시 size에 넣어줘야함
					i++;
					tli.offer(t);
				}else {
					die_li.offer(t);
				}// 죽은 나무 리스트를 넣어준다

			}
			
			
			
			
			
			//여름 죽음 처리..?
			while(!die_li.isEmpty()){
				tree t = die_li.poll();
//				System.out.println(3);
				eat[t.x][t.y] += t.age/2;
			}
//			System.out.println(tli.size());
			//가을 
//			temp deque에 있는 나무들은-> 번식해야한다.
// 			그리고 나무를 리스트에 넣어줄때 앞에다가 넣어준다.
			Deque<tree> temp = new ArrayDeque<>();
			for(tree t : tli) {
				if (t.age%5 ==0)
				{
					temp.add(t);
				}
			}
			while(!temp.isEmpty()) {
				tree t = temp.poll();
				for(int i=0;i<8;i++) {
					if(0<t.x+dx[i]&& t.x+dx[i]<=N && 0<t.y+dy[i]&& t.y+dy[i]<=N )
					tli.addFirst(new tree(t.x+dx[i],t.y+dy[i],1));
				}

//				System.out.println("456456456456");
			}
			
			
			// 겨울 
			for(int i=1;i<N+1;i++){
				for(int j=1;j<N+1;j++){
					 eat[i][j]+= arr[i][j];
				}
			}

//			System.out.println(tli.size());
		
		
		}
//		System.out.println("___________________");
		// 
		sb.append(tli.size());
		System.out.println(sb);
	}
	
}
