package colecoes;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class ColecoesExemploSet {

    public static void main(String[] args) {
        HashSet<String> pessoas = new HashSet<>();

        pessoas.add("Joao");
        pessoas.add("Maria");
        pessoas.add("Pedro");

        for(String p : pessoas){
            System.out.println(p);
        }
    }
}
