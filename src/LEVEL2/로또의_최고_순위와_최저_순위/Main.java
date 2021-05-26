package LEVEL2.로또의_최고_순위와_최저_순위;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int lottos[] = new int[6];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<6; i++) {
				lottos[i] = Integer.parseInt(st.nextToken());
			}

			int win_nums[] = new int[6];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<6; i++) {
				lottos[i] = Integer.parseInt(st.nextToken());
			}

			int ans[] = solution(lottos, win_nums);
			sb.append(ans[0] + " " + ans[1] + "\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		int zeroCount = 0;
		PriorityQueue<Integer> pq_lottos = new PriorityQueue<>();
		for(int i=0; i<6; i++) {
			if(lottos[i] == 0) {
				zeroCount++;
				continue;
			}		// 숫자가 0일때 로또 Queue에 넣지 않고, zeroCount 증가로 기록
			pq_lottos.offer(lottos[i]);
		}

		if(pq_lottos.size() == 0) {
			answer[0] = 1; answer[1] = 6;
			return answer;
		}

		PriorityQueue<Integer> pq_win = new PriorityQueue<>();
		for(int i=0; i<6; i++) {
			pq_win.offer(win_nums[i]);
		}

		int count = 0;
		for(int i : pq_win) {
			for(int j : pq_lottos) {
				if(i == j) count++;
			}
		}		// 로또 숫자와 당첨 숫자 중 일치하는 것이 있으면 맞은 숫자 count+1

		int max = count+zeroCount;
		answer[0] = max >= 2 ? answer[0] = 7-max : 6;		// 최고 순위는 zero가 모두 정답일 때

		int min = count;
		answer[1] = min >= 2 ? answer[1] = 7-min : 6;		// 최저 순위는 zero가 모두 오답일 때

		return answer;
	}
}
