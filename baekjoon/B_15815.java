package a0214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B_15815 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<>();
		String s = br.readLine();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='+' || c=='-'|| c=='*'|| c=='/') {
				int a = stack.pop();
				int b = stack.pop();
				switch(c) {
				case '+':
					stack.push(b+a);
					break;
				case '-':
					stack.push(b-a);
					break;
				case '*':
					stack.push(b*a);
					break;
				case '/':
					stack.push(b/a);
					break;
				}
			}
			else {
				stack.push(c-'0');
			}
		}
		bw.write(stack.pop() + "");
		bw.flush();
		bw.close();
		br.close();

	}

}
