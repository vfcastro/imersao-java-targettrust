package colecoes;

import java.util.*;

public class Exercicio1 {

    public static void main(String[] args) {
        List<String> pessoas = new ArrayList<>();

        pessoas.add("Kiersten");
        pessoas.add("Zaneta");
        pessoas.add("Frank");
        pessoas.add("Tedi");
        pessoas.add("Bryana");
        pessoas.add("Marigold");
        pessoas.add("Devan");
        pessoas.add("Jerrilyn");
        pessoas.add("Isac");
        pessoas.add("Kathrine");
        pessoas.add("Bryana");

        Collections.sort(pessoas);

        SortedSet<String> setPessoas = new TreeSet<>(pessoas);

        for(String p : setPessoas) {
            System.out.println(p);
        }

        List<String> primeiros = new ArrayList<>();

        int i = 1;
        for(String p : setPessoas){
            if(i++ > 3) {
                break;
            }
            primeiros.add(p);
        }

        System.out.println("--------------");
        for(String p : primeiros){
            System.out.println(p);
        }
    }
}
