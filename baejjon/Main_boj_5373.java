package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_5373 {
	static char[][] init = { { '-', '-', '-', 'o', 'o', 'o', '-', '-', '-', },
			{ '-', '-', '-', 'o', 'o', 'o', '-', '-', '-', }, { '-', '-', '-', 'o', 'o', 'o', '-', '-', '-', },
			{ 'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b' }, { 'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b' },
			{ 'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b' }, { '-', '-', '-', 'r', 'r', 'r', '-', '-', '-' },
			{ '-', '-', '-', 'r', 'r', 'r', '-', '-', '-' }, { '-', '-', '-', 'r', 'r', 'r', '-', '-', '-' },
			{ '-', '-', '-', 'y', 'y', 'y', '-', '-', '-' }, { '-', '-', '-', 'y', 'y', 'y', '-', '-', '-' },
			{ '-', '-', '-', 'y', 'y', 'y', '-', '-', '-' }, };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			char[][] dice = new char[12][9];
			// dice 초기화
			for (int i = 0; i < 12; i++) {
				dice[i] = init[i].clone();
			}
			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				char[] menu = st.nextToken().toCharArray();
				rotate(menu, dice);
			}
			for (int i = 3; i < 6; i++) {
				for (int j = 3; j < 6; j++) {
					System.out.print(dice[i][j]);
				}
				System.out.println();
			}
		}
	}

	static void rotate(char[] menu, char[][] divice) {
		switch (menu[0]) {
		case 'U':
			if (menu[1] != '-') {
				char[][] tmp = new char[5][5];
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						tmp[i][j] = divice[2 + 5 - j - 1][2 + i];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
//	                    for (int i = 0; i < 5; i++) {
//	                        System.out.println(Arrays.toString(tmp[i]));
//	                    }
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						divice[2 + i][2 + j] = tmp[i][j];
					}
				}

			} else {
				char[][] tmp = new char[5][5];
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						tmp[i][j] = divice[2 + j][2 + 5 - i - 1];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						divice[2 + i][2 + j] = tmp[i][j];
					}
				}
			}
			break;
		case 'D':
			if (menu[1] != '-') {
				char[][] tmp = new char[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmp[i][j] = divice[9 + 3 - j - 1][3 + i];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
//	                    for (int i = 0; i < 5; i++) {
//	                        System.out.println(Arrays.toString(tmp[i]));
//	                    }
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						divice[9 + i][3 + j] = tmp[i][j];
					}
				}
				char temp; // o->b b->r r->g g->o
				for (int i = 0; i < 3; i++) {
					temp = divice[0][3 + i];
					divice[0][3 + i] = divice[5 - i][0];
					divice[5 - i][0] = divice[8][5 - i];
					divice[8][5 - i] = divice[3 + i][8];
					divice[3 + i][8] = temp;
				}

			} else {
				char[][] tmp = new char[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmp[i][j] = divice[9 + j][3 + 3 - i - 1];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
//	                    for (int i = 0; i < 5; i++) {
//	                        System.out.println(Arrays.toString(tmp[i]));
//	                    }
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						divice[9 + i][3 + j] = tmp[i][j];
					}
				}
				char temp; // o->b b->r r->g g->o
				for (int i = 0; i < 3; i++) {
					temp = divice[0][3 + i];
					divice[0][3 + i] = divice[3 + i][8];
					divice[3 + i][8] = divice[8][5 - i];
					divice[8][5 - i] = divice[5 - i][0];
					divice[5 - i][0] = temp;
				}

			}
			break;
		case 'F':
			if (menu[1] != '-') {
				char[][] tmp = new char[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmp[i][j] = divice[3 + 3 + 3 - j - 1][3 + i];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
//	                    for (int i = 0; i < 5; i++) {
//	                        System.out.println(Arrays.toString(tmp[i]));
//	                    }
				char temp; // o->b b->r r->g g->o
				for (int i = 0; i < 3; i++) {
					temp = divice[9][5 - i];
					divice[9][5 - i] = divice[5][6 + i];
					divice[5][6 + i] = divice[5][3 + i];
					divice[5][3 + i] = divice[5][i];
					divice[5][i] = temp;
				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						divice[3 + 3 + i][3 + j] = tmp[i][j];
					}
				}

			} else {
				char[][] tmp = new char[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmp[i][j] = divice[3 + 3 + j][3 + 3 - i - 1];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
//	                    for (int i = 0; i < 5; i++) {
//	                        System.out.println(Arrays.toString(tmp[i]));
//	                    }
				char temp; // o->b b->r r->g g->o
				for (int i = 0; i < 3; i++) {
					temp = divice[9][5 - i];
					divice[9][5 - i] = divice[5][i];
					divice[5][i] = divice[5][3 + i];
					divice[5][3 + i] = divice[5][6 + i];
					divice[5][6 + i] = temp;

				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						divice[3 + 3 + i][3 + j] = tmp[i][j];
					}
				}
			}
			break;
		case 'B':
			if (menu[1] != '-') {
				char[][] tmp = new char[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmp[i][j] = divice[3 - j - 1][3 + i];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
//	                    for (int i = 0; i < 5; i++) {
//	                        System.out.println(Arrays.toString(tmp[i]));
//	                    }
				char temp; // o->b b->r r->g g->o
				for (int i = 0; i < 3; i++) {
					temp = divice[11][5 - i];
					divice[11][5 - i] = divice[3][i];
					divice[3][i] = divice[3][3 + i];
					divice[3][3 + i] = divice[3][6 + i];
					divice[3][6 + i] = temp;
				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						divice[i][3 + j] = tmp[i][j];
					}
				}

			} else {
				char[][] tmp = new char[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmp[i][j] = divice[j][3 + 3 - i - 1];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
//	                    for (int i = 0; i < 5; i++) {
//	                        System.out.println(Arrays.toString(tmp[i]));
//	                    }
				char temp; // o->b b->r r->g g->o
				for (int i = 0; i < 3; i++) {
					temp = divice[11][5 - i];
					divice[11][5 - i] = divice[3][6 + i];
					divice[3][6 + i] = divice[3][3 + i];
					divice[3][3 + i] = divice[3][i];
					divice[3][i] = temp;
				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						divice[i][3 + j] = tmp[i][j];
					}
				}
			}
			break;
		case 'L':
			if (menu[1] != '-') {
				char[][] tmp = new char[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmp[i][j] = divice[3 + 3 - j - 1][i];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
//	                    for (int i = 0; i < 5; i++) {
//	                        System.out.println(Arrays.toString(tmp[i]));
//	                    }
				char temp; // o->b b->r r->g g->o
				for (int i = 0; i < 3; i++) {
					temp = divice[3 + i][3];
					divice[i][3] = divice[9 + i][3];
					divice[9 + i][3] = divice[6 + i][3];
					divice[6 + i][3] = divice[3 + i][3];
					divice[3 + i][3] = temp;
				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						divice[i][3 + j] = tmp[i][j];
					}
				}
			} else {
				char[][] tmp = new char[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmp[i][j] = divice[j][3 + 3 - i - 1];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
//	                    for (int i = 0; i < 5; i++) {
//	                        System.out.println(Arrays.toString(tmp[i]));
//	                    }
				char temp; // o->b b->r r->g g->o
				for (int i = 0; i < 3; i++) {
					temp = divice[3 + i][3];
					divice[i][3] = divice[3 + i][3];
					divice[3 + i][3] = divice[6 + i][3];
					divice[6 + i][3] = divice[9 + i][3];
					divice[9 + i][3] = temp;
				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						divice[i][3 + j] = tmp[i][j];
					}
				}
			}
			break;
		case 'R':
			if (menu[1] != '-') {
				char[][] tmp = new char[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmp[i][j] = divice[3 + 3 - j - 1][6 + i];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
//	                    for (int i = 0; i < 5; i++) {
//	                        System.out.println(Arrays.toString(tmp[i]));
//	                    }
				char temp; // o->b b->r r->g g->o
				for (int i = 0; i < 3; i++) {
					temp = divice[3 + i][5];
					divice[i][5] = divice[9 + i][5];
					divice[9 + i][5] = divice[6 + i][5];
					divice[6 + i][5] = divice[3 + i][5];
					divice[3 + i][5] = temp;
				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						divice[i][3 + j] = tmp[i][j];
					}
				}
			} else {
				char[][] tmp = new char[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmp[i][j] = divice[3 + j][3 + 3 + 3 - i - 1];
//	                            tmp[i][j] = tmp[3+3-j-1][3+i];
						// 이게 원래 90도 회전하는 코드닌깐
					}
				}
//	                    for (int i = 0; i < 5; i++) {
//	                        System.out.println(Arrays.toString(tmp[i]));
//	                    }
				char temp; // o->b b->r r->g g->o
				for (int i = 0; i < 3; i++) {
					temp = divice[3 + i][5];
					divice[i][5] = divice[3 + i][5];
					divice[3 + i][5] = divice[6 + i][5];
					divice[6 + i][5] = divice[9 + i][5];
					divice[9 + i][5] = temp;
				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						divice[i][3 + j] = tmp[i][j];
					}
				}
			}
			break;

		}
	}
//	    {'-','-','-','o','o','o','-','-','-',},
//	    {'-','-','-','o','o','o','-','-','-',},
//	    {'-','-','-','o','o','o','-','-','-',},
//	    {'g','g','g','w','w','w','b','b','b'},
//	    {'g','g','g','w','w','w','b','b','b'},
//	    {'g','g','g','w','w','w','b1','b2','b3'},
//	    {'-','-','-','r','r','r','-','-','-'},
//	    {'-','-','-','r','r','r','-','-','-'},
//	    {'-','-','-','r','r','r','-','-','-'},
//	    {'-','-','-','y3','y2','y1','-','-','-'},
//	    {'-','-','-','y','y','y','-','-','-'},
//	    {'-','-','-','y','y','y','-','-','-'},
}
