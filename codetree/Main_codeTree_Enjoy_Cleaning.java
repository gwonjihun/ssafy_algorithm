package CodeTree;


import java.io.*;
import java.util.StringTokenizer;

public class Main_codeTree_Enjoy_Cleaning {

    static int n;
    static int[][] arr;//지도
    static int[] dx = {0,1,0,-1}, dy = {-1,0,1,0};
    static int sx,sy,dir;
    static int[][][] dir_divide = {
            {
                    {0,0,2,0,0},
                    {0,10,7,1,0},
                    {5,0,0,0,0},
                    {0,10,7,1,0},
                    {0,0,2,0,0}
            },
            {
                    {0,0,0,0,0},
                    {0,1,0,1,0},
                    {2,7,0,7,2},
                    {0,10,0,10,0},
                    {0,0,5,0,0}
            },
            {
                    {0,0,2,0,0},
                    {0,1,7,10,0},
                    {0,0,0,0,5},
                    {0,1,7,10,0},
                    {0,0,2,0,0}
            },
            {
                    {0,0,5,0,0},
                    {0,10,0,10,0},
                    {2,7,0,7,2},
                    {0,1,0,1,0},
                    {0,0,0,0,0}
            }
    };
    static int ans;
    static int w_max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        sx= n/2;
        sy = n/2;
        dir = 0;
        int size= 1;
        while(sx!=0||sy!=0){

            for(int i = 0 ;i<size;i++){
                //여기서 청소기가 이동하는거고
                move();
                //조기 중단 처리해줘야하고
                if(sx==0&&sy==0){
                    break;
                }
            }

            dir =  (dir+1)%4;

            if(dir == 0 || dir == 2){
                size +=1;
            }
        }
        System.out.println(ans);
    }
    //
    //57 -( 5,5,1 ,1 ,3 ,3 ,0,0,2)->37인디요?이닌깐
    //결국 그냥 저 비율 맞춰서 조져주면되는거고
    //이걸 계산해주는 방법은?아 어차피 노상관이구나.
    //
    static void move(){
        sx+=dx[dir];
        sy +=dy[dir];

        int addDust = 0;
        for(int i = 0 ; i<5;i++){
            for(int j = 0 ; j < 5;j++){
                int dust = arr[sx][sy]*dir_divide[dir][i][j]/100;
                int tx = sx+i-2;
                int ty = sy+j-2;
                if(0<=tx&&tx<n&&0<=ty&&ty<n){
                    arr[tx][ty]+=dust;
                }else{
                    ans +=dust;
                }
                addDust +=dust;
            }
        }
        int ax = sx+dx[dir];
        int ay = sy+dy[dir];
        int aDust = arr[sx][sy] - addDust;
        if(0<=ax&&ax<n&&0<=ay&&ay<n){
            arr[ax][ay]+=aDust;
        }else{
            ans +=aDust;
        }
//        int
    }
}
