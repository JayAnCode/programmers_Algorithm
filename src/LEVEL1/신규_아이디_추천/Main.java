package LEVEL1.신규_아이디_추천;

import java.io.*;
import java.util.Locale;

public class Main {
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String new_id = br.readLine();
		System.out.println(solution(new_id));
	}
	public static String solution(String new_id) {
		StringBuilder sb = new StringBuilder();
		new_id = new_id.toLowerCase(Locale.ROOT);
		for(int i=0; i<new_id.length(); i++) {
			if(new_id.charAt(i)>=97 && new_id.charAt(i)<=122) {
				sb.append(new_id.charAt(i));
			}
			else if(new_id.charAt(i)>=48 && new_id.charAt(i)<=57) {
				sb.append(new_id.charAt(i));
			}
			else if(new_id.charAt(i)=='.' |  new_id.charAt(i)=='-' || new_id.charAt(i)=='_') {
				if(sb.length()>0 && new_id.charAt(i)=='.' && sb.toString().charAt(sb.length()-1)=='.') continue;
				sb.append(new_id.charAt(i));
			}
		}
		if(sb.length()>0 && sb.toString().charAt(0)=='.') {
			sb.deleteCharAt(0);
		}
		if(sb.length()>0 && sb.toString().charAt(sb.length()-1)=='.') {
			sb.deleteCharAt(sb.length()-1);
		}
		if(sb.length()==0) sb.append("a");
		if(sb.length()>15) {
			sb.delete(15,sb.length());
			if(sb.length()>0 && sb.toString().charAt(sb.length()-1) == '.') {
				sb.deleteCharAt(sb.length()-1);
			}
		}
		while(sb.length()<3) {
			sb.append(sb.toString().charAt(sb.length()-1));
		}
		return sb.toString();
	}
}
