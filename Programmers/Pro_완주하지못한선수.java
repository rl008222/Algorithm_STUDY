package a0310;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Pro_완주하지못한선수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String []participant = {"mislav", "mislav", "stanko"};
		String []completion = {"mislav", "stanko"};
		bw.write(solution(participant, completion));
		bw.flush();
		bw.close();
		br.close();
	
	}
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (Entry<String, Integer> key : hm.entrySet()) {
            if (key.getValue()!= 0){
                answer = key.getKey();
            }
        }
        return answer;
    }
}
