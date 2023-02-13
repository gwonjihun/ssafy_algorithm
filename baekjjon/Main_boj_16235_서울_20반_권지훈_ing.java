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
	static long beforeTime = System.currentTimeMillis();
	static long afterTime;
	static List<tree> die_li;
	static int[][] arr;
	static int N,M,K;
	static StringBuilder sb = new StringBuilder();
	static Queue<tree> tli = new ArrayDeque<>();
	static int eat[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

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
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine()," ");
			tli.add(new tree(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		// 나무 리스트 입력
		
		// 1000 => 3000
		for(int i=0;i<K;i++){
//			System.out.println(tli.size());
			eat();
//			System.out.println(tli.size());
			spread();
//			System.out.println(tli.size());
			food();
//			System.out.println(tli.size());
		}
//		System.out.println("___________________");
		// 
		sb.append(tli.size());
		System.out.println(sb);
		afterTime = System.currentTimeMillis();
		System.out.println((afterTime - beforeTime)+"ms");
	}

	static void eat() {
		die_li = new LinkedList<>();
		
		for(int i = 0 ; i<tli.size();){
//			System.out.println("4");
			tree t = tli.poll();
			if(eat[t.x][t.y]>=t.age) {
				eat[t.x][t.y] -= t.age;
				t.age += 1;
				i++;
				tli.add(t);
			}else{
				die_li.add(t);
			}
//			System.out.println(i);
		}
		die();
//		System.out.println("*********");
	}
	static void die() {
		for(int i=0;i<die_li.size();i++){
//			System.out.println(3);
			tree t = die_li.get(i);
			eat[t.x][t.y] += t.age/2;
		}
	}
	static void spread() {
		//여기서 문제인데
		int[] dx = {-1,-1,-1,0,1,1,1,0};
		int[] dy = {-1,0,1,1,1,0,-1,-1};
		List<tree> temp = new LinkedList<>();
		for(tree t : tli){
//			System.out.println("2");
			if(t.age%5==0){
				temp.add(t);
			}
		}
		
		int tsize = temp.size();
		for(int i=0;i<tsize;i++){
//			System.out.println("!!!!!!!!!!!");
			tree t = temp.get(i);
			if(t.age%5 ==0){
				for(int j = 0 ; j<8; j++){
					if(t.x+dx[j] >=1 && t.x+dx[j]<=N && t.y+dy[j]>=1 && t.y+dy[j]<=N)
					tli.add(new tree(t.x+dx[j], t.y+dy[j], 1));
				}
			}
		}
	}
	static void food() {
		for(int i=1;i<N+1;i++){
			for(int j=1;j<N+1;j++){
				 eat[i][j]+= arr[i][j];
			}
		}
	}
	
}
