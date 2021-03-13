package LEVEL2.메뉴_리뉴얼;

import java.io.*;
import java.util.*;

public class Main {
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] orders = new String[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) orders[i] = st.nextToken();
		int[] course = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) course[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<solution(orders,course).length; i++) System.out.println(solution(orders, course)[i]);
		br.close();
	}
	public static String[] solution(String[] orders, int[] course) {
		String[] answer;
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<orders.length; i++) {
			char[] c = orders[i].toCharArray();
			Arrays.sort(c);
			orders[i] = new String(c);
		}
		for(int i=0; i<course.length; i++) {
			map.clear();
			for(int j=0; j<orders.length; j++) {
				dfs(orders[j], course[i], "", 0);
			}
			int max = 2;
			for(Map.Entry<String, Integer> entry : map.entrySet()){
				max = Math.max(max, entry.getValue());
			}
			for(Map.Entry<String, Integer> entry : map.entrySet()){
				if(entry.getValue() == max) {
					list.add(entry.getKey());
				}
			}
		}
		Collections.sort(list);
		answer = new String[list.size()];
		list.toArray(answer);
		return answer;
	}
	static void dfs(String orders, int course, String str, int index) {
		if(str.length() == course) {
			map.put(str, map.getOrDefault(str, 0)+1);
			return;
		}
		if(index<orders.length()) dfs(orders, course, str+orders.charAt(index), index+1);
		if(index<orders.length()) dfs(orders, course, str, index+1);
	}
}
