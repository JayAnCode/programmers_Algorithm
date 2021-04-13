package LEVEL3.N으로_표현;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int number = Integer.parseInt(st.nextToken());

		System.out.println(solution(N, number));
	}
	static int answer;
	static int num[];
	public static int solution(int N, int number) {
		answer = -1;
		num = new int[9];
		for(int i=1; i<9; i++) num[i] = num[i-1]*10 + N;
		dfs(N, number, 0, 0);
		return answer;
	}
	public static void dfs(int N, int number, int cur, int count) {
		if(count > 8) {
			answer = -1;
			return;
		}
		else if(cur == number) {
			if (answer == -1) answer = count;
			else answer = Math.min(answer, count);
			return;
		}

		for(int i=1; i<9-count; i++) {
			dfs(N, number, cur+num[i], count+i);
			dfs(N, number, cur-num[i], count+i);
			dfs(N, number, cur*num[i], count+i);
			dfs(N, number, cur/num[i], count+i);
		}
	}
}
