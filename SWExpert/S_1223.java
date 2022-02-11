package a0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class S_1223 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc=1;tc<=10;tc++) {
			int length = Integer.parseInt(br.readLine());
			char []c = br.readLine().toCharArray();
			Queue<Character> q = new LinkedList<>();
			Stack<Character> op = new Stack<>();
			//후위 연산 변환
			for(int i=0;i<length;i++) {
				if(c[i]=='*') {
					while(!op.isEmpty()) {
						if(op.peek()=='+') break;
						q.add(op.pop());
					}
					op.push(c[i]);
				
				} else if(c[i]=='+') {
					while(!op.isEmpty()) q.add(op.pop());
					op.push(c[i]);
				} else {
					q.add(c[i]);
				}
			}
			//남은 연산자 넣기
			while(!op.isEmpty()) q.add(op.pop());
			
			//while(!q.isEmpty()) System.out.print(q.poll() + "");
			
			int result=0;
			Stack<Integer> n = new Stack<>();
			//후위 연산 계산
			while(!q.isEmpty()) {
				if(q.peek() == '*') {
					result = n.pop()*n.pop();
				} else if(q.peek() == '+') {
					result =  n.pop()+n.pop();
				} else {
					result = q.peek()-'0';
				}
				q.poll();
				n.push(result);
			}
			bw.write("#" + tc + " " + n.pop());
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
