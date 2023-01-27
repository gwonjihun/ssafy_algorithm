package ssafy_algorithm.baekjjon;

import java.util.Scanner;
class hello {
    public static int[][] rotation(int[][] arr){
        int[][] result = new int[arr.length][arr.length];

        for(int i= 0; i<arr.length;i++){
            for(int j= 0;j<arr.length; j++){
                result[i][j] = arr[arr.length- j-1][i];
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1;tc<=T;tc++){
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int i= 0; i<arr.length;i++){
                for(int j= 0;j<arr.length; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int[][] result_90 = rotation(arr);
            int[][] result_180 = rotation(result_90);
            int[][] result_270 = rotation(result_180);
            System.out.printf("#%d\n",tc);

            for(int i= 0; i<arr.length;i++){
                for(int j= 0;j<arr.length; j++){
                    System.out.printf("%d",result_90[i][j]);
                }
                System.out.printf(" ");
                for(int j= 0;j<arr.length; j++){
                    System.out.printf("%d",result_180[i][j]);
                }
                System.out.printf(" ");
                for(int j= 0;j<arr.length; j++){
                    System.out.printf("%d",result_270[i][j]);
                }
                System.out.printf(" ");
                System.out.println();
            }

        }
    }
}