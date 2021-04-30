package LEVEL2.조이스틱;

import java.io.*;

public class Main {
	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();

		int ans = solution(name);

		System.out.println(ans);
		br.close();
	}
	public static int solution(String name) {
		int answer = 0;

		int len = name.length();
		int lrMove = len-1;
		for(int i=0; i<len; i++) {
			answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

			int next = i+1;
			while(next<len && name.charAt(next) == 'A') next += 1;

			lrMove = Math.min(lrMove, i+(len-next+i));
		}
		answer += lrMove;

		return answer;
	}
}
