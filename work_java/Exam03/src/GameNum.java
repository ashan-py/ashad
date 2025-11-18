//1~100 숫자 입력받고 큰지 작은지 알려줘서 맞추는 게임

import javax.swing.*;//swing쓸때 import

public class GameNum {

    public static void main(String[] args) {
        // 1~100 임이의 정수 생성
        int answer;
        answer = (int)(Math.random() * 100) + 1;
        System.out.print(answer);
        
        int input = 0; //사용자가 입력한 숫
        String tmp = "";//
        int cnt = 0;//시도한 횟수



     do {
            cnt++;
            tmp = JOptionPane.showInputDialog("input a int(1~100), Enter -1 to stop");
            if(tmp.equals("-1") || tmp == null) {
                System.out.print("bye~");
                break;
            }
           System.out.println("input value = "+tmp);
           input = Integer.parseInt(tmp);
           
           if (input > answer)
               System.out.println("the value is large, re- input a small value T.T");
           else if(input < answer)
               System.out.println("the value is small, re- input a large value T.T");
           else {
               System.out.println("congratulations ^.^ try cnt = "+cnt);
               break;
           }
        }while(true);

    }

}

