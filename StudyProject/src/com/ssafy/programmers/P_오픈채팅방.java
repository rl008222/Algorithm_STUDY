package com.ssafy.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_오픈채팅방 {
	public static void main(String[] args) {
		String []s = solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
		for(int i=0;i<s.length;i++)
			System.out.println(s[i]);
	}
	public static class Name{
		String a;
		String b;
		public Name(String a, String b) {
			super();
			this.a = a;
			this.b = b;
		}
		
	}
	public static String[] solution(String[] record) {
		String[] answer = {};
		HashMap<String, String> map = new HashMap<>();
		Queue<Name> q = new LinkedList<>();
		for(int i=0;i<record.length;i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			String s = st.nextToken();
			String id = st.nextToken();
			String name="";
			if(s.equals("Enter")) {
				name= st.nextToken();
				map.put(id, name);
				q.add(new Name(s, id));
			} else if(s.equals("Leave")) {
				q.add(new Name(s, id));
			} else {
				name= st.nextToken();
				map.put(id, name);
			}
		}
		int i=0;
		answer = new String[q.size()];
		while(!q.isEmpty()) {
			if(q.peek().a.equals("Enter")) answer[i]=map.get(q.poll().b)+"님이 들어왔습니다.";
			else answer[i]=map.get(q.poll().b)+"님이 나갔습니다.";
			i++;
		}
		return answer;
	}
}
