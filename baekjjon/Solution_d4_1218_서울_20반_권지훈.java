package baekjjon;
import java.util.*;
import java.io.*;
public class Solution_d4_1218_서울_20반_권지훈 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int T=1;T<=10; T++){
            int len = Integer.parseInt(br.readLine());

            String str = br.readLine();

            if (len%2==1){
                sb.append("#").append(T).append(" ").append(0).append("\n");
                continue;
            }
            Stack<Character> stack = new Stack<>();
            for(int i = 0;i<len;i++){
                char c = str.charAt(i);
                if (c == ')' && !stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else if (c == ']' && !stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else if (c == '}' && !stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else if (c == '>' && !stack.isEmpty() && stack.peek() == '<')
                    stack.pop();
                else // 여는 괄호이거나 닫는 괄호 쌍이 맞지 않은 경우 닫는 괄호도 stack push
                    stack.push(c);
            }

            if (stack.isEmpty()) {
                // 스택이 모두 비워진 경우
                sb.append("#").append(T).append(" ").append(1).append("\n");
            }
            else {
                sb.append("#").append(T).append(" ").append(0).append("\n");
            }
            }
        System.out.println(sb);
        }
    }
