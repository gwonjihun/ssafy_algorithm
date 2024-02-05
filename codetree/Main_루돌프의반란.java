package gwonjihun.codetree;

import java.io.*;
import java.util.*;
public class Main_루돌프의반란 {
	static int N,M,P,C,D;
	static int[] stun;//기절하게된 라운드값을 넣어준다?
	static int[][] board;// 산타와 루돌프의 위치를 보여주는 변수
	
	static int[] score;
	static Map<Integer, Node> map;
	static Node rudo;// 루돌프의 위치 정보
	static int[] sdx= {0,0,1,-1}, sdy= {1,-1,0,0};
	static int[] rdx= {-1,-1,0,1,1,1,0,-1}, rdy= {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
	}
	static class Node implements Comparable<Node>{
		int x,y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Node o) {
			//거리가 동일하다면 어떤걸 써야하는지를 보여준다.
			// TODO Auto-generated method stub
			if(this.x == o.x) {
				return o.y- this.y;
			}
			return o.x-this.x;
		}
	}
	static void moveAnimal() {
		
	}
	static void movePeople() {
		//stun이 라운드랑 비교해서 라운드보다 작아야지만 움직일 수 있다.
	}
}