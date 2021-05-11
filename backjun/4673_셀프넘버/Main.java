import java.io.IOException;


public class Main {
    static boolean[] output = new boolean[10001];
	public static void main(String[] args) {
        for(int a = 1 ; a <= 10000 ; a++){
            int temp = selfValue(a);
            if(temp > 10000){
            }else{
                output[temp] = true;
            }
        }
        //output
        for(int a = 1 ; a <= 10000 ; a++){
            if(!output[a])
                System.out.println(a);
        }
    }
    
    public static int selfValue(int n){
        int sum = n;
        while(true){   // 각 자리수의 숫자를 더해야하므로 1의 자리를 계속 더해준다.
 
            if(n == 0) break; //0이 되면 break
            sum += n%10;      //1의 자리 더해주기
            n = n/10;         //한자리씩 없애기
        }
        
        return sum;
    }
}