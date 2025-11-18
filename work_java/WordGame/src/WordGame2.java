import java.util.Scanner;

public class WordGame2 {
    final String startWord = "동국대";
    private Player player1,player2;
    Scanner scn;
    
    WordGame2(){
        System.out.println("끝말잇기 시작");
        scn = new Scanner(System.in);
        
    }
    
    void createPlayers() {
        System.out.print("player1 name: ");
        String name = scn.next();
        player1 = new Player(name);
        
        System.out.print("player2 name: ");
        name = scn.next();
        player2 = new Player(name);
    }
    
    void run() {
        createPlayers();
        String lastWord = startWord;
        System.out.println("\n시작 단어: "+ startWord);
        while(true) {
            player1.inputWordFromUser();
            String newWord = player1.getWord();
            if (!player1.chkSucces(lastWord)) {
                System.out.println(player1.getName() +"님이 졌다");
                scn.close();
                break;
            }
            lastWord = newWord;
            
            player2.inputWordFromUser();
            newWord = player2.getWord();
            if(!player2.chkSucces(lastWord) ) {
                System.out.println(player2.getName() +"님이 졌다");
                scn.close();
                break;
            }
            lastWord = newWord;
            
        }
    }
    public static void main(String[] args) {
        
        WordGame2 game = new WordGame2();
        game.run();
    }

}
