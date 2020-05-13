package comandos;
public class ExemploComandos {
    public static void main(String[] args) {
        short a = 3;
        short b = 5;
        // tenho certeza que é short => cast
        short resultado = (short) (a * b);
        boolean leiVenda1050 = resultado > 10;
        if (leiVenda1050) {
            System.out.println("Resultado maior que 10...");
        }else if(resultado == 10){
            System.out.println("Resultado IGUAL  10");
        } else {
            System.out.println("Resultado menor que 10...");
        }
        // Laços:
        //for
        //foreach
        //while
        //do while
        String cnpj = "05.104.996/0001-20";
        char[] cnpjChars = cnpj.toCharArray();
        System.out.println(" For clássico: ");
        for(short contador = 0 ; contador < cnpjChars.length ; contador++ ){
            System.out.println( cnpjChars[contador] );
        }
        System.out.println(" Foreach: ");
        for(char charAtual : cnpjChars){
            System.out.println(charAtual);
        }
        System.out.println(" While: ");
        short contador = 0;
        while (contador < cnpjChars.length){
            System.out.println(cnpjChars[contador]);
//            contador = contador+1;
            contador = (short) (contador+1);
        }
        //Do-while
        System.out.println(" Do While: ");
        contador = 0;
        do{
            System.out.println(cnpjChars[contador]);
            contador++;
        }while (contador < cnpjChars.length);
    }
}