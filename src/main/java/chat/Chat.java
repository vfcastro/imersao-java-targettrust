package chat;

import java.util.Scanner;

public class Chat {

    private static Mensagem[] listaMensagens = new Mensagem[50];

    public static void main(String[] args) {
        System.out.println("Username:");

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        Usuario user1 = new Usuario(username);

        System.out.println("Mensagem:");
        String texto = scanner.nextLine();

        Mensagem msg1 = new Mensagem(texto,user1);
        listaMensagens[0] = msg1;

        for(Mensagem msg : listaMensagens){
            if(msg != null)
                System.out.println(msg.getMensagem());
        }

    }
}
