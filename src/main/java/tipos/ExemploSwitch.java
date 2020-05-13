package tipos;

public class ExemploSwitch {

    public static void main(String[] args) {

        char tipoImposto = 'I';
        float valorInicial = 1000;
        float valorComDesconto = 0;

        switch (tipoImposto){
            case 'I':
                valorComDesconto = (float) (valorInicial*0.94);
                break;
            case 'R':
                valorComDesconto = (float) (valorInicial*0.85);
                break;
            default:
                valorComDesconto = (float) (valorInicial*0.95);
        }

        System.out.println("Com desconto:");
        System.out.println(valorComDesconto);
    }
}
