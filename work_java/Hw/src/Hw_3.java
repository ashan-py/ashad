//1~100 숫자 입력받고 큰지 작은지 알려줘서 맞추는 게임

import javax.swing.JOptionPane;

public class Hw_3 {

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
            if(tmp == null || tmp.equals("-1") || tmp.equals("") ) { //사용자가 -1, enter 입력하면 실행종료 
                System.out.print("bye~");
                break;
            }
           System.out.println("input value = "+tmp);
           try {
               input = Integer.parseInt(tmp);
           } catch (NumberFormatException e) {
               System.out.println("invalid input! please input a valid integer.");
               continue;
           }
           
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
