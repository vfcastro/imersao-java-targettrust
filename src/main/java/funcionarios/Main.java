package funcionarios;

import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InputStream resource = SalarioFuncionarios.class.getResourceAsStream("/pessoas.csv");
        Scanner scanner = new Scanner(resource);

        if(!scanner.hasNextLine())
            return;
        else
            scanner.nextLine();

        while (scanner.hasNextLine()) {
            String[] linha = scanner.nextLine().split(",");
            int id = Integer.parseInt(linha[0]);
            String nome = linha[1];
            String sobrenome = linha[2];
            float salario = Float.parseFloat(linha[3]);
            float beneficios = Float.parseFloat(linha[4]);

            SalarioFuncionarios funcionario = new SalarioFuncionarios(id,nome,sobrenome,salario,beneficios);

            System.out.printf("%s R$%.2f\n", funcionario.getNomeCompleto(),funcionario.getSalarioTotal());


        }


    }
}
