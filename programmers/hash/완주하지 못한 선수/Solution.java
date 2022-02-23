import java.util.Arrays;

//
class Solution {
    // 내 생각한 풀이법은 Sort후 하나씩 비교 방법
    public String mySolution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0 ; i < participant.length-1; i++){
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        answer = participant[participant.length-1];
        return answer;
    }

    // 프로그래머스 답안
    // getOrDefault(Object key, V DefaultValue) - 해당 키 값을 있으면 조회하고 아니면 기본값 반환 함수
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}