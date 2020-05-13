package codigobarras;

public class CodigoBarrasValidator {
    public static void main(String[] args) {
        String barra = "127919";

        if(validaBarra(barra))
            System.out.println("VALIDA");
        else
            System.out.println("INVALIDA");

    }

    public static boolean validaBarra(String barra){
        if(barra.length() < 22)
            return false;

        int digitosVerificadores = calculaDigitosVerificadores(barra);

        return validaDigitosVerificadores(barra, digitosVerificadores);
    }

    private static int calculaDigitosVerificadores(String barra) {

        int soma = 0;

        for(short i = 0 ; i < 20 ; i++){
            //soma = soma + Integer.parseInt(String.valueOf(barra.charAt(i)));
            soma = soma + Character.getNumericValue(barra.charAt(i));
        }

        if(soma > 99){
            soma = soma % 100;
        }

        System.out.println(soma);
        return soma;
    }
    private static boolean validaDigitosVerificadores(String barra, int digitosVerificadores){

        System.out.println(barra.substring(20,22));
        if(Integer.parseInt(barra.substring(20,22)) == digitosVerificadores)
            return true;
        else
            return false;
    }

}
