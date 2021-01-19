package LEVEL2.일이사나라의숫자;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));
	}

	public static String solution(int n) {

		StringBuilder sb = new StringBuilder();
		int res = 0;
		while(n>0){
			res = n%3;
			n = n/3;
			if(res==0){
				n=n-1;
				res = 4;
			}
			sb.insert(0, res);
		}
		return sb.toString();
	}
}
