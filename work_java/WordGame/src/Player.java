import java.util.Scanner;

class Player {
    // field
    private String name;
    private String word;
    Scanner scn;

    Player(String name) {
        this.name = name;
        scn = new Scanner(System.in);

    }

    String getName() {
        return name;
    }

    String getWord() {
        return word;
    }

    void inputWordFromUser() {
        System.out.print(name + ": ");

        word = scn.next();
    }

    // 상대방이 말한단어 lastWord와 참가사가 말한단어 비교
    boolean chkSucces(String lastWord) {
        int lastIndex = lastWord.length() - 1; //lastWord의 마지막 index
        if(lastWord.charAt(lastIndex) == word.charAt(0)) 
            return true;
        else
            return false;
    }
}
