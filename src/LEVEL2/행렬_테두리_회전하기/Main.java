package LEVEL2.행렬_테두리_회전하기;

import java.io.*;
import java.util.*;

public class Main {
	static int min;
	static int map[][];

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rows = Integer.parseInt(br.readLine());
		int colums = Integer.parseInt(br.readLine());

		int len = Integer.parseInt(br.readLine());

		int queries[][] = new int[len][4];
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				queries[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans[] = solution(rows, colums, queries);
		for(int i=0; i<len; i++) {
			System.out.println(ans[i]);
		}

		br.close();
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];

		map = new int[rows+1][columns+1];
		for(int i=1; i<rows+1; i++) {
			for(int j=1; j<columns+1; j++) {
				map[i][j] = (i - 1) * columns + j;
			}
		}

		for(int i=0; i<queries.length; i++) {
			min = Integer.MAX_VALUE;
			map = rotation(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
			answer[i] = min;
		}

		return answer;
	}
	public static int[][] rotation(int y1, int x1, int y2, int x2) {
		int copyMap[][] = map;

		int temp1 = copyMap[y1][x2];
		for(int i=x2; i>x1; i--) {
			copyMap[y1][i] = copyMap[y1][i-1];
			min = Math.min(min, copyMap[y1][i]);
		}		// 위쪽 변 이동


		int temp2 = copyMap[y2][x2];
		for(int i=y2; i>y1+1; i--) {
			copyMap[i][x2] = copyMap[i-1][x2];
			min = Math.min(min, copyMap[i][x2]);
		}		// 오른쪽 변 이동
		copyMap[y1+1][x2] = temp1;


		int temp3 = copyMap[y2][x1];
		for(int i=x1; i<x2-1; i++) {
			copyMap[y2][i] = copyMap[y2][i+1];
			min = Math.min(min, copyMap[y2][i]);
		}		// 아래쪽 변 이동
		copyMap[y2][x2-1] = temp2;


		for(int i=y1; i<y2-1; i++) {
			copyMap[i][x1] = copyMap[i+1][x1];
			min = Math.min(min, copyMap[i][x1]);
		}		// 왼쪽 변 이동
		copyMap[y2-1][x1] = temp3;

		min = Math.min(min, Math.min(temp1, Math.min(temp2, temp3)));

		return copyMap;
	}
}
