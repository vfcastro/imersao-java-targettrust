package stream.exercicio1;

import colecoes.Exercicio2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercicio1 {

    public static void main(String[] args) {
        // Leitura arquivo de entrada
        InputStream resource = Exercicio1.class.getResourceAsStream("/emails.txt");
        Scanner scanner = new Scanner(resource);
        List<String> emails = new ArrayList<>();

        while(scanner.hasNextLine()){
            emails.add(scanner.nextLine());
        }

        List<String> novaLista = emails.stream()
                .filter(email -> email.contains("@google"))
                .peek(System.out::println)
                .distinct()
                .collect(Collectors.toList());

//        System.out.println(novaLista.toString());
    }
}
