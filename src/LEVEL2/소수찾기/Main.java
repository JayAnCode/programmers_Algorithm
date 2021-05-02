package LEVEL2.소수찾기;

import java.io.*;
import java.util.HashSet;

public class Main {
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String arg[]) throws  Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numbers = br.readLine();

		System.out.println(solution(numbers));
		br.close();
	}
	public static int solution(String numbers) {
		int answer = 0;

		go("", numbers);
		answer = set.size();

		return answer;
	}
	public static void go(String s, String numbers) {
		int len = numbers.length();

		if(!s.equals("")) {
			if(isPrime(s)) set.add(Integer.parseInt(s));
		}

		for(int i=0; i<len; i++) {
			go(s + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i+1, len));

		}
	}
	public static boolean isPrime(String s) {
		int a = Integer.parseInt(s);

		if(a == 1) return false;

		if(a%2 == 0) {
			if(a == 2) return true;
			else return false;
		}

		for(int i=3; i<=(int)Math.sqrt(a); i+=2) {
			if(a%i == 0) return false;
		}

		return true;
	}
}
