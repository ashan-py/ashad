//1~100 숫자 입력받고 큰지 작은지 알려줘서 맞추는 게임

import javax.swing.*;//swing쓸때 import

public class NumGame {

    public static void main(String[] args) {
        String re = "yes";
        while (re.equals("yes")) {
            // 1~100 임이의 정수 생성
            int answer;
            answer = (int) (Math.random() * 100) + 1;
            System.out.print(answer);

            int input = 0; // 사용자가 입력한 숫
            String tmp = "";//
            int cnt = 0;// 시도한 횟수

            do {
                if (cnt == 0)
                    tmp = JOptionPane.showInputDialog("input a int(1~100), Enter -1 to stop");
                else {
                    if (input > answer)
                        tmp = JOptionPane.showInputDialog("the value is large, re - input a small value T.T");
                    else if (input < answer)
                        tmp = JOptionPane.showInputDialog("the value is small, re - input a large value T.T");
                    else {
                        re = JOptionPane.showInputDialog("congratulations ^.^ try cnt = " + cnt+"\nif you want again?");
                        break;
                    }

                }

                cnt++;
                if (tmp.equals("-1") || tmp == null) {
                    System.out.print("bye~");
                    re = "no";
                    break;
                }
                System.out.println("input value = " + tmp);
                input = Integer.parseInt(tmp);

            } while (true);
            
        }

    }

}