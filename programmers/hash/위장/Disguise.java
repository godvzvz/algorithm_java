package alg.hash;

import java.util.*;

public class Disguise {
    public void main(String[] args) {
//        String[][] input = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] input = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println("answer = " + solution(input));
    }
    public  int solution(String[][] clothes) {
        int answer = 1;
        // parsing
        HashMap<String, Integer> cloth = new HashMap<>();
        for(int i = 0 ; i< clothes.length; i++){
            cloth.put(clothes[i][1], cloth.getOrDefault(clothes[i][1],0)+1);
        }
        // counting
//        for(int i = 0 ; i < cloth.size(); i++) {
//            answer += combination(cloth, new boolean[cloth.size()], 0, 0, i+1);
//        }

        // 다른 사람의 풀이
        // (A+1)*(B+1) -1 경우의 수로 해결
        for(String key : cloth.keySet()){
            answer *= cloth.get(key) + 1;
        }
        return answer-1;
    }

//    public static int combination(HashMap<String, Integer> arr, boolean[] visited, int start, int depth, int r){
//        if(depth == r){
//            // 완료 수행 조건
//            int temp = 1;
//            for(int i = 0 ; i < arr.size() ; i++){
//                if(visited[i]) {
//                    String key = (String) arr.keySet().toArray()[i];
//                    temp = temp * arr.get(key);
//                }
//            }
//            return temp;
//        }
//
//        int combination = 0;
//        for(int i=start; i<arr.size(); i++){
//            if(!visited[i]){
//                visited[i] = true;
//                combination += combination(arr, visited, i + 1, depth + 1, r);
//                visited[i] = false;
//            }
//        }
//        return combination;
//    }
}
