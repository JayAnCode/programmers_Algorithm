package LEVEL3.합승_택시_요금;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int fares[][] ={{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.println(solution(n, s, a, b, fares));
		br.close();
	}
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int[][] dp = new int[n+1][n+1];
		int max = 200*10000+1;
		for(int i=1; i<n+1; i++) {
			for(int j = 1; j <n+1; j++) dp[i][j] = max;
			dp[i][i] = 0;
		}
		for(int i=0; i<fares.length; i++) {
			dp[fares[i][0]][fares[i][1]] = fares[i][2];
			dp[fares[i][1]][fares[i][0]] = fares[i][2];
		}
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(dp[i][j] > dp[i][k] + dp[k][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
					}
				}
			}
		}
		int answer = max;
		for(int i=1; i<n+1; i++) answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
		return answer;
	}
}
