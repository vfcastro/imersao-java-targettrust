package avancado.excecoes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Desafio {
    //1 - Trate as exceções a seguir:
    public static void main(String args[]) {
        try {
            excecoesNumericas();
        }
        catch (ArithmeticException e){

        }
        nullPointerException();
        indexOfBounds();
        arquivoInexistente();
        erroDeConversao();
        disparoDeExcecao();

        Scanner s = new Scanner(System.in);
        s.nextInt();

    }
    private static void disparoDeExcecao() {
        throw new IllegalArgumentException();
    }
    private static void erroDeConversao() {
        int num = Integer.parseInt ("zero");
        System.out.println(num);
    }
    private static void arquivoInexistente() {
        File file = new File("E://arquivo.txt");
        try {
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void indexOfBounds() {
        String e = "Imersao Java";
        char f = e.charAt(29);
        System.out.println(e);
    }
    private static void nullPointerException() {
        String d = null;
        System.out.println(d.charAt(0));
    }
    private static void excecoesNumericas() {
        int a = 30, b = 0;
        int c = a/b;
        System.out.println ("Resultado = " + c);
    }
}