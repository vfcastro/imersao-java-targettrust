package tipos;

import java.math.BigDecimal;

public class ExemplosTipos {

    public static void main(String[] args) {
        //Ano atual
        short anoAtual = 2020;

        //Quantidade de vendas de um dia de uma pequena empresa
        int quantidadeVendasDia = 1023;

        //Situação de um boleto (pago/não pago)
        boolean boletoPago = true;

        //Não usar o Boolean null...
        Boolean t = true;
        Boolean f = false;
        Boolean n = null;

        //Tipo de pagamento (Crédito, Débito)
        // Normalmente Enum, mas é comum tb char
        char tipoPagamento = 'C'; //Ou 'D'

        //Dados binários, por exemplo, um documento
        byte[] documento = new byte[]{'a','b','c'};

        //CNPJ
        String cnpj = "84.796.028/0001-77";

        //Valor de um produto, considerando itens de uma farmácia
        float valorProdutoFarmacia = 167.67F;
        BigDecimal valorProdutoBig = BigDecimal.valueOf(167.67);

        //Código de barras de um Produto
        String codigoBarrasProduto = "83282380989230230923";

    }
}
