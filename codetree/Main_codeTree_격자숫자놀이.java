package gwonjihun.codetree;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Pair implements Comparable<Pair> {
    int first, second;
    
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair p) {
        // first, second 순으로 오름차순 정렬이 되도록 합니다.
        if(this.first != p.first)
            return this.first - p.first;
        return this.second - p.second;
    }
}

public class Main_codeTree_격자숫자놀이 {
    public static final int MAX_NUM = 100;
    public static final int MAX_N = 100;
    
    public static int n = 3, m = 3;
    public static int r, c, k;
    
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    
    // row 행에 대해 숫자 놀이를 진행합니다.
    public static int rowPlay(int row) {
        // 각 숫자에 대해 빈도수를 구해줍니다.
        // 정렬시 빈도수, 숫자 순으로 오름차순 정렬이 되도록
        // (빈도수, 숫자) 형태로 저장해줍니다.
        ArrayList<Pair> pairs = new ArrayList<>();
        for(int num = 1; num <= MAX_NUM; num++) {
            int frequency = 0;
            for(int col = 1; col <= m; col++)
                if(grid[row][col] == num)
                    frequency++;
            
            if(frequency > 0)
                pairs.add(new Pair(frequency, num));
        }
        
        // 숫자를 새로 적어줘야 하므로,
        // 그 전에 기존 row 행에 있던 숫자들을 전부 0으로 바꿔줍니다.
        for(int col = 1; col <= m; col++)
            grid[row][col] = 0;
        
        Collections.sort(pairs);
        
        // row 행에 새로운 숫자를 차례대로 적어줍니다.
        for(int i = 0; i < pairs.size(); i++) {
            int frequency = pairs.get(i).first;
            int num = pairs.get(i).second;
            grid[row][i * 2 + 1] = num;
            grid[row][i * 2 + 2] = frequency;
        }
    
        return pairs.size() * 2;
    }
    
    // col 열에 대해 숫자 놀이를 진행합니다.
    public static int colPlay(int col) {    
        // 각 숫자에 대해 빈도수를 구해줍니다.
        // 정렬시 빈도수, 숫자 순으로 오름차순 정렬이 되도록
        // (빈도수, 숫자) 형태로 저장해줍니다.
        ArrayList<Pair> pairs = new ArrayList<>();
        for(int num = 1; num <= MAX_NUM; num++) {
            int frequency = 0;
            for(int row = 1; row <= m; row++)
                if(grid[row][col] == num)
                    frequency++;
            
            if(frequency > 0)
                pairs.add(new Pair(frequency, num));
        }
        
        // 숫자를 새로 적어줘야 하므로,
        // 그 전에 기존 col 열에 있던 숫자들을 전부 0으로 바꿔줍니다.
        for(int row = 1; row <= m; row++)
            grid[row][col] = 0;
        
        Collections.sort(pairs);
        
        // col 열에 새로운 숫자를 차례대로 적어줍니다.
        for(int i = 0; i < pairs.size(); i++) {
            int frequency = pairs.get(i).first;
            int num = pairs.get(i).second;
            grid[i * 2 + 1][col] = num;
            grid[i * 2 + 2][col] = frequency;
        }
    
        return pairs.size() * 2;
    }
    
    public static void simulate() {
        // 행의 개수가 열의 개수와 일치하거나 더 많다면
        // 행 단위로 진행 후, 최대로 긴 열의 크기를 구합니다.
        if(n >= m) {
            int maxCol = 0;
            for(int row = 1; row <= n; row++)
                maxCol = Math.max(maxCol, rowPlay(row));
            m = maxCol;
        }
        // 열의 개수가 더 많다면
        // 열 단위로 진행 후, 최대로 긴 행의 크기를 구합니다.
        else {
            int maxRow = 0;
            for(int col = 1; col <= m; col++)
                maxRow = Math.max(maxRow, colPlay(col));
            n = maxRow;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();
        
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                grid[i][j] = sc.nextInt();
        
        int ans = -1;
        // 최대 100초 동안 시뮬레이션을 진행합니다.
        for(int t = 0; t <= 100; t++) {
            if(grid[r][c] == k) {
                ans = t;
                break;
            }
        
            simulate();
        }
        
        System.out.print(ans);
    }
}