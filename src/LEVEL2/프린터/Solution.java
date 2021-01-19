package LEVEL2.프린터;

import java.util.*;

class Solution {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int n = sc.nextInt();
		int[] p = new int[n];
		for(int i=0; i<n; i++){
			p[i] = sc.nextInt();
		}
		System.out.println(solution(p, l));
	}

	public static int solution(int[] priorities, int location) {

		int answer = 0;
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<priorities.length; i++){
			q.offer(priorities[i]);
		}
		Arrays.sort(priorities);
		for(int i=0; i<priorities.length; i++){
			s.push(priorities[i]);
		}
		while(!q.isEmpty()){
			int print = q.poll();
			location = location-1;
			if(print < s.peek()){
				q.offer(print);
				if(location == -1)location = q.size()-1;
			}
			else if(print == s.peek()){
				answer++;
				if(location == -1) break;
				else s.pop();
			}
		}
		return answer;
	}
}
