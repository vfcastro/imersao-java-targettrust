package colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColecoesExemplos {

    public static void main(String[] args) {
        ArrayList<String> linguagens = new ArrayList<>();

        linguagens.add("B");
        linguagens.add("C");
        linguagens.add("D");
        linguagens.add("E");
        linguagens.add("F");
        linguagens.add("A");

        Collections.sort(linguagens);

        for(String ling : linguagens){
            System.out.println(ling);
        }

    }
}
