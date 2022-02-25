package alg.hash;

import java.util.*;

public class BestAlbum {
    public void main(String[] args) {
//        String[][] input = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        String[][] input = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        String[] input1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] input2 = {500, 600, 150, 800, 2500};
        int[] solution = solution(input1, input2);
        System.out.println("answer = " + Arrays.toString(solution));

    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        // parsing
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, int[][]> albums = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++){
            if(total.containsKey(genres[i]) == false){
                total.put(genres[i],plays[i]);
                int[][] value = new int[2][2];
                value[0][0] = plays[i];
                value[0][1] = i;
                value[1][1] = -1;
                albums.put(genres[i],value);
            }else{
                total.put(genres[i],total.get(genres[i]) + plays[i]);
                int[][] targetValue = albums.get(genres[i]);
                if(targetValue[0][0] < plays[i]){
                    targetValue[1][0] = targetValue[0][0];
                    targetValue[1][1] = targetValue[0][1];
                    targetValue[0][0] = plays[i];
                    targetValue[0][1] = i;
                }else if(targetValue[1][0] < plays[i]){
                    targetValue[1][0] = plays[i];
                    targetValue[1][1] = i;
                }
            }
        }
//        System.out.println("total = " + total);
//        for (String s : albums.keySet()) {
//            int[][] ints = albums.get(s);
//            System.out.println("albums0 = " + Arrays.toString(ints[0]));
//            System.out.println("albums1 = " + Arrays.toString(ints[1]));
//        }

        //print
        ArrayList<Integer> answers = new ArrayList();
        ArrayList<Integer> totals = new ArrayList<>(total.values());
//        Arrays.sort(totals, Collections.reverseOrder());
        Collections.sort(totals,Collections.reverseOrder());
        for (Integer targetGenre : totals) {
            for (String s : total.keySet()) {
                if(total.get(s).equals(targetGenre)){
                    int[][] targetValue = albums.get(s);
                    answers.add(targetValue[0][1]);
                    if(targetValue[1][1] != -1)
                        answers.add(targetValue[1][1]);
                }
            }
        }
        System.out.println("answers = " + answers);
        answer = Arrays.stream(answers.toArray()).mapToInt(i->(int)i).toArray();

        return answer;
    }
}
