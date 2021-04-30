package LEVEL1.모의고사;

import java.io.*;
import java.util.*;
public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int answers[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			answers[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		int ans[] = solution(answers);
		for(int i=0; i<ans.length; i++) {
			sb.append(ans[i] + " ");
		}

		System.out.println(sb.toString());
		br.close();
	}
	public static int[] solution(int[] answers) {
		ArrayList<Integer> list = new ArrayList<>();
		int A[] = {1, 2, 3, 4, 5};
		int B[] = {2, 1, 2, 3, 2, 4, 2, 5};
		int C[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int score[] = new int[3];
		for(int i=0; i<answers.length; i++) {
			if(answers[i] == A[i%A.length]) score[0] += 1;
			if(answers[i] == B[i%B.length]) score[1] += 1;
			if(answers[i] == C[i%C.length]) score[2] += 1;
		}

		int max = Math.max(score[0], Math.max(score[1], score[2]));
		for(int i=0; i<3; i++) {
			if(max == score[i]) list.add(i+1);
		}

		int answer[] = new int[list.size()];
		for(int i=0; i<list.size(); i++) answer[i] = list.get(i);

		return answer;
	}
}
