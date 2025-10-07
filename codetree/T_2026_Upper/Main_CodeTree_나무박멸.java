package CodeTree.T_2026_Upper;

import java.io.*;
import java.util.*;
public class Main_CodeTree_나무박멸 {
    /*
        입력 받아야하는 것 : n,k,m
        1. 나무와 벽정보는 n*n에 있다 ->
        2. 제초제의 경후 k의 범위만큼 대각선으로 퍼지며 벽이 있는경우 가로 막혀서 전파되지 않는다.

        1년동안 성장 억제는 아래와 같이 이뤄진다.
        (성장 -> growTree func)
        1. 상하좌우 4개의 칸에 나무가 있는 만큼 나무가 성장한다 그리고 이건 모든 나무가 동시에 일어난다.
        (번식 -> SpreadTree)
        2. 기존 성장된 나무들은 인접한 4개의 칸중 "벽, 다른 나무, 제초제"가 없는 곳에서 번식한다.
        번식된 개수는 현재 나무 / (번식 가능칸) 나머지는 버림으로 성장

        (제초제 뿌리기 -> dieTree)
        3. 2번까지의 동작이 진행된 뒤로 제초제는 대각선 방향으로 k칸 만큼 전파되는데
        3-1 제초제가 퍼질때 나무가 0인곳, 벽은 뿌려지지만 그뒤칸은 뿌려지지 않는다.
        3-2

    */
    // N: 격자 크기, M: 박멸 진행 년 수, K: 제초제 확산 범위, C: 제초제 잔존 년 수
    static int N, M, K, C;
    // A: 나무 그루 수와 벽의 정보를 담는 격자
    // -1: 벽, 0: 빈 칸, 양수: 나무 그루 수
    static int[][] A;
    // 제초제가 뿌려진 칸의 정보를 담는 격자
    // can_grow[x][y] = year: year부터 자랄 수 있음.
    static int[][] can_grow;

    // 인접 네 방향 (상, 하, 좌, 우)
    static int[][] dxy = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    // 대각선 네 방향
    static int[][] dxy_diagonal = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    // 좌표 저장을 위한 내부 클래스
    static class Pos {
        int x, y;
        Pos(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        can_grow = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long total_killed = 0;
        // M년 동안 시뮬레이션 진행
        for (int year = 1; year <= M; year++) {
            // 1. 나무 성장
            step1_tree_growth();
            // 2. 나무 번식
            step2_tree_propagation(year);
            // 3. 제초제 위치 선정
            Pos pos = step3_pick_position();
            // 4. 제초제 뿌리기 (박멸할 나무가 있는 경우에만)
            if (pos.x != -1) {
                total_killed += step4_spray(year, pos.x, pos.y);
            }
        }
        System.out.println(total_killed);
    }

    static boolean in_range(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    // 1단계: 나무의 성장
    static void step1_tree_growth() {
        // 모든 나무에 대해 동시에 성장 처리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 나무가 없는 칸은 건너뜀
                if (A[i][j] <= 0) continue;

                // 인접한 네 칸 중 나무가 있는 칸의 수만큼 성장
                int cnt = 0;
                for (int[] dir : dxy) {
                    int nx = i + dir[0];
                    int ny = j + dir[1];
                    if (in_range(nx, ny) && A[nx][ny] > 0) {
                        cnt++;
                    }
                }
                A[i][j] += cnt;
            }
        }
    }

    // 2단계: 나무의 번식
    static void step2_tree_propagation(int year) {
        // 번식으로 추가되는 나무를 저장하는 변수(동시 번식이므로 독립적인 처리를 위하여 별도로 선언)
        int[][] added_tree = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 나무가 없는 칸은 건너뜀
                if (A[i][j] <= 0) continue;

                // 번식이 가능한 빈 칸 찾기
                List<Pos> blank = new ArrayList<>();
                for (int[] dir : dxy) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    // 격자 내에 있고, 빈 칸이며, 제초제가 없는 칸
                    if (in_range(x, y) && A[x][y] == 0 && can_grow[x][y] <= year) {
                        blank.add(new Pos(x, y));
                    }
                }

                // 번식 가능한 칸이 있다면
                if (!blank.isEmpty()) {
                    // (현재 나무 그루 수 / 번식 가능 칸 수) 만큼 각 칸에 번식
                    int num_to_add = A[i][j] / blank.size();
                    for (Pos pos : blank) {
                        added_tree[pos.x][pos.y] += num_to_add;
                    }
                }
            }
        }

        // 번식 결과를 원래 격자에 반영
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] += added_tree[i][j];
            }
        }
    }

    // (x, y)에 제초제를 뿌렸을 때 박멸되는 나무의 수를 계산하는 함수
    static int get_score(int x, int y) {
        int score = A[x][y];
        // 네 대각선 방향으로 확산
        for (int[] dir : dxy_diagonal) {
            for (int k = 1; k <= K; k++) {
                int nx = x + dir[0] * k;
                int ny = y + dir[1] * k;
                // 격자를 벗어나거나 벽, 빈 칸을 만나면 확산 중단
                if (!in_range(nx, ny) || A[nx][ny] <= 0) {
                    break;
                }
                score += A[nx][ny];
            }
        }
        return score;
    }

    // 3단계: 제초제를 뿌릴 위치 선정
    static Pos step3_pick_position() {
        int max_score = -1;
        Pos best_pos = new Pos(-1, -1);
        // 격자 전체를 순회하며 최대 박멸 위치 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] > 0) {
                    int score = get_score(i, j);
                    // 최대 점수 갱신 (점수가 같으면 행, 열이 작은 순서가 for문의 순서에 의해 자연스럽게 됨)
                    if (score > max_score) {
                        max_score = score;
                        best_pos = new Pos(i, j);
                    }
                }
            }
        }
        return best_pos;
    }

    // 4단계: 제초제 뿌리기
    static int step4_spray(int year, int x, int y) {
        int total_killed = 0;

        // 제초제를 뿌린 위치의 나무 박멸
        total_killed += A[x][y];
        A[x][y] = 0;
        // 제초제 타이머 설정 (현재 년도 + C + 1년부터 자랄 수 있음)
        can_grow[x][y] = year + C + 1;

        // 네 대각선 방향으로 확산
        for (int[] dir : dxy_diagonal) {
            for (int k = 1; k <= K; k++) {
                int nx = x + dir[0] * k;
                int ny = y + dir[1] * k;
                // 격자를 벗어나거나 벽을 만나면 확산 중단
                if (!in_range(nx, ny) || A[nx][ny] < 0) {
                    break;
                }

                // 제초제 타이머 설정
                can_grow[nx][ny] = year + C + 1;
                total_killed += A[nx][ny];

                // 나무가 없는 칸까지는 제초제가 뿌려지고 그 이후는 전파되지 않음
                if (A[nx][ny] == 0) {
                    break;
                }

                // 나무 박멸
                A[nx][ny] = 0;
            }
        }
        return total_killed;
    }
}