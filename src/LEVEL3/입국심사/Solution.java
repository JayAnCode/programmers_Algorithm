package LEVEL3.입국심사;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] times = new int[2];
		for(int i=0; i<2; i++){
			times[i] = sc.nextInt();
		}
		System.out.println(solution(n, times));
	}

	public static long solution(int n, int[] times) {

		long answer = 0;
		int max = 0;
		for(int i=0; i<times.length; i++) {
			if(max < times[i]) max = times[i];
		}
		long right = (long)max*(long)n;
		long left = 0;
		while(true){
			if(left >= right){
				answer = left;
				break;
			}
			long mid = left + (right-left)/2;
			long count = 0;
			for(int i=0; i<times.length; i++) count += mid/times[i];
			if(count >= n) right = mid;
			else left = mid+1;
		}
		return answer;
	}

}
