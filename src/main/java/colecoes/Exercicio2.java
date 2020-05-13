package colecoes;

import java.io.InputStream;
import java.util.*;

public class Exercicio2 {

    public static void main(String[] args) {
        InputStream resource = Exercicio2.class.getResourceAsStream("/campeoes.txt");
        Scanner scanner = new Scanner(resource);

        List<String> campeoes = new ArrayList<>();
        while(scanner.hasNextLine()){
            campeoes.add(scanner.nextLine());
        }

        TreeMap<String,ArrayList<String[]>> quantidadeDeTitulos = new TreeMap<>();
        for(String linha : campeoes){
            String[] anoPais = linha.split(" - ");
            String pais = anoPais[1];

            ArrayList<String[]> titulos = new ArrayList<>();
            titulos.add(anoPais);

            if(quantidadeDeTitulos.containsKey(pais)){
               titulos.addAll(quantidadeDeTitulos.get(pais));
               quantidadeDeTitulos.put(pais,titulos);
            }
            else{
               quantidadeDeTitulos.put(pais,titulos);
            }
        }

        for(Map.Entry<String,ArrayList<String[]>> pais: quantidadeDeTitulos.entrySet())
            System.out.printf("País: %s -> Títulos: %d\n",pais.getKey(),pais.getValue().size());

    }
}