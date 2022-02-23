import java.util.HashSet;
class Solution {
    // 보통 hashMap이 더 최적화가 되어서 빠르다고 함
    // 모든 문자열을 탐색하면서 하나씩 비교하는 방안 - 비효율적이라고 생각되지만
    // 제한 조건으로 통과할거라 판단되어서 진행
    // 개선할 포인트는 많다고 생각함
    public boolean mySolution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        for (String s : phone_book) {
            set.add(s);
        }
        for (int i = 0 ; i < phone_book.length ; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if(set.contains(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        return true;
    }

    // 프로그래머스 답안
    // boolean startsWith(String) 시작 문자열이 폼하하는지 함수 
    public boolean solution(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
}