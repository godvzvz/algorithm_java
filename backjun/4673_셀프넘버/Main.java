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
        while(true){   // �� �ڸ����� ���ڸ� ���ؾ��ϹǷ� 1�� �ڸ��� ��� �����ش�.
 
            if(n == 0) break; //0�� �Ǹ� break
            sum += n%10;      //1�� �ڸ� �����ֱ�
            n = n/10;         //���ڸ��� ���ֱ�
        }
        
        return sum;
    }
}