package ordenacao;

public class Produto implements Comparable<Produto>{
    private String nome;
    private Float custoAquisicao;
    private Float valorVenda;

    public Produto(String nome, Float custoAquisicao, Float valorVenda){
        this.nome = nome;
        this.custoAquisicao = custoAquisicao;
        this.valorVenda = valorVenda;
    }

    Float calculaLucro(){
        return this.valorVenda - this.custoAquisicao;
    }

    String imprimeDescricao(){
        return String.format("%s - R$%.2f - R$%.2f - Lucro: %.2f\n",
                this.nome,
                this.custoAquisicao,
                this.valorVenda,
                this.valorVenda - this.custoAquisicao);
    }

    Float getCustoAquisicao() {
        return this.custoAquisicao;
    }

    public int compareTo(Produto produto) {
        if(produto.nome == null){
            return 1;
        }
        return this.nome.compareTo(produto.nome);
    }
}
