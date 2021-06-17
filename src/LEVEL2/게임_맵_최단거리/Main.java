package LEVEL2.게임_맵_최단거리;

import java.io.*;
import java.util.*;

public class Main {
	static class Move {
		int row;
		int col;
		int count;
		public Move(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());

		int maps[][] = new int[y][x];
		for(int i=0; i<y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<x; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(maps));
		br.close();
	}
	static int n, m, ans;
	static boolean flag;
	static boolean visited[][];
	static int dx[] = {-1, 1, 0 ,0};
	static int dy[] = {0, 0, -1, 1};

	public static int solution(int[][] maps) {
		n = maps.length;
		m = maps[0].length;

		visited = new boolean[n][m];
		bfs(0, 0, maps);

		if(flag) return ans;
		else return -1;
	}

	public static void bfs(int row, int col, int[][] maps) {
		Queue<Move> q = new LinkedList<>();
		q.offer(new Move(row, col, 1));
		visited[row][col] = true;

		while(!q.isEmpty()) {
			Move move = q.poll();
			if(move.col == m-1 && move.row == n-1) {
				flag = true;
				ans = move.count;
				return;
			}
			for(int i=0; i<4; i++) {
				int nx = move.col + dx[i];
				int ny = move.row + dy[i];

				if((nx<0 || nx>=m) || (ny<0 || ny>=n)) continue;
				if(!visited[ny][nx] && maps[ny][nx] == 1) {
					q.offer(new Move(ny, nx, move.count+1));
					visited[ny][nx] = true;
				}

			}
		}
	}
}
