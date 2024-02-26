package Boj;

import java.io.*;
import java.util.*;

public class Main_boj_20055_aga {
    static class Robot{
        int y;
    }
    static int N,K;
    static int step;
    static int[] rail;//내구도 파악용
    static boolean[] robot;//true가 있고

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        step = 0;
        rail = new int[2*N];
        robot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <2*N;i++){
            rail[i] = Integer.parseInt(st.nextToken());
        }
        while(true){

//            System.out.println(Arrays.toString(rail));
            step+=1;
            rotate_robot();
            move();

            drop();

            if(end()){
                break;
            }
        }
        System.out.println(step);
    }
    static void move(){
        for (int i = N-2;i>0;i--){
            if(robot[i]&&!robot[i+1]&&rail[i+1]>0){
                robot[i] = false;
                robot[i+1] = true;
                rail[i+1]-=1;
            }
        robot[N-1]= false;
    }}
    static void drop(){
        if(rail[0]>0){
            rail[0]-=1;
            robot[0] =true;
        }
    }
    static void rotate_robot(){
        //로봇이 벨트와 함께 회전할때
        int tmp = rail[2*N-1];
        for(int i = 2*N-1 ; i >0;i--){
            rail[i] = rail[i-1];
        }
        rail[0] = tmp;
        for(int i = N-1; i>0;i--){
            robot[i]= robot[i-1];
        }
        robot[0]=false;//회전하면 비어있어야함.
        robot[N-1]=false;//내려감
    }
    static boolean end(){
        int cnt =0;
        for(int i = 0 ; i <2*N;i++){
            if(rail[i]==0) cnt++;
            if(cnt>=K) return true;
        }
        return false;

    }
}
//4 5
//        10 1 10 6 3 4 8 2
