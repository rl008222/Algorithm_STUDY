package com.ssafy.SWExpert;

/*
4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어진다.
이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하는 프로그램을 작성한다.
예를 들어 아래와 같은 문자열은 유효하다고 판단할 수 있다.
아래와 같은 문자열은 유효하지 않은 문자열이다. 붉은색으로 표시된 괄호의 짝을 찾을 수 없기 때문이다.
아래 문자열은 열고 닫는 괄호의 개수는 유효하나 짝이 맞지 않는 괄호가 사용 되었기 때문에 유효하지 않다.

[입력]
각 테스트 케이스의 첫 번째 줄에는 테스트케이스의 길이가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.
총 10개의 테스트케이스가 주어진다.

[출력]
#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 유효성 여부를 1 또는 0으로 표시한다 (1 - 유효함, 0 - 유효하지 않음)

[결과]
#1 1
#2 0
#3 1
#4 1
#5 1
#6 0
#7 0
#8 1
#9 0
#10 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P_1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String opener = "<{([";
		
		for (int tc = 1; tc <= 10; tc++) {
			int answer = 1;
			sb.append("#").append(tc).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			Stack<String> stack = new Stack<>();
			for (int i = 0; i < N; i++) {
				String item = line.substring(i, i + 1);  
				if (opener.contains(item)) {
					stack.push(item);
				} else {//끝괄호 이면
					boolean result = false;
					if (!stack.isEmpty()) {
						String prev = stack.pop();
						
						if (item.equals(">") && prev.equals("<")) {
							result = true;
						} else if (item.equals("]") && prev.equals("[")) {
							result = true;
						} else if (item.equals("}") && prev.equals("{")) {
							result = true;
						} else if (item.equals(")") && prev.equals("(")) {
							result = true;
						}
						if (!result) {
							answer = 0;
							break;
						}
					}
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
