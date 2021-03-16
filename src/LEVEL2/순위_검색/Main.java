package LEVEL2.순위_검색;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String[] info = new String[N];
		for(int i=0; i<N; i++) info[i] = br.readLine();
		String[] query = new String[M];
		for(int i=0; i<M; i++) query[i] = br.readLine();
		for(int i=0; i<query.length; i++) System.out.println(solution(info, query)[i]);
	}
	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		String[][] s1= new String[info.length][5];
		for(int i=0; i<info.length; i++) {
			s1[i] = info[i].split(" ");
		}
		String[][] s2 = new String[query.length][5];
		StringTokenizer st;
		for(int i=0; i<query.length; i++) {
			st = new StringTokenizer(query[i]," ");
			for(int j=0; j<5; j++) {
				String s = st.nextToken();
				if(s.equals("and")) s2[i][j] = st.nextToken();
				else s2[i][j] = s;
			}

		}
		for(int j=0; j<s2.length; j++) {
			for(int i=0; i<s1.length; i++) {
				if(s2[j][0].equals(s1[i][0]) || s2[j][0].equals("-")) {
					if(s2[j][1].equals(s1[i][1]) || s2[j][1].equals("-")) {
						if(s2[j][2].equals(s1[i][2]) || s2[j][2].equals("-")) {
							if(s2[j][3].equals(s1[i][3]) || s2[j][3].equals("-")) {
								if(Integer.valueOf(s2[j][4]) <= Integer.valueOf(s1[i][4])) {
									answer[j]++;
								}
							}
						}
					}
				}
			}
		}
		return answer;
	}
}