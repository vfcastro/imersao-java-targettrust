package stream.exercicio2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercicio2 {

    public static void main(String[] args) {
        // Leitura arquivo de entrada
        InputStream resource = Exercicio2.class.getResourceAsStream("/emails.txt");
        Scanner scanner = new Scanner(resource);
        List<String> emails = new ArrayList<>();

        while(scanner.hasNextLine()){
            emails.add(scanner.nextLine());
        }

        String nomes = emails.stream()
//                .map(e -> e.replaceAll("@.*",""))
                .map(email -> email.split("@")[0])
                .collect(Collectors.joining(","));

        System.out.println(nomes);
    }
}
