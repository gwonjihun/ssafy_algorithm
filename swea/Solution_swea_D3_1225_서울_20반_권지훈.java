package swea;
import java.nio.Buffer;
import java.util.*;
import java.io.*;
public class Solution_swea_D3_1225_서울_20반_권지훈 {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int T = 1 ;T<11;T++){
            int Tc= Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            Deque<Integer> ps = new ArrayDeque<>();


            sb.append("#").append(Tc).append(" ");
            for(int i=0;i<8;i++) {
                ps.addLast(Integer.parseInt(st.nextToken()));
            }
            int s = 1;
            while(true){
                int temp = ps.pollFirst();
                temp -= s;
                if(temp<=0) {
                    temp = 0;
                    ps.addLast(temp);
                    break;
                }
                ps.addLast(temp);
                s = (s<5) ? s+1: 1;
            }
            while(!ps.isEmpty()){
                int temp= ps.pollFirst();
                sb.append(temp).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
