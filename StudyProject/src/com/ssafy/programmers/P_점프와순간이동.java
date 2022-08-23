package com.ssafy.programmers;

import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
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
