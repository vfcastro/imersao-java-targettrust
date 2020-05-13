package funcionarios;

public class SalarioFuncionarios {
    private int id;
    private  String nome;
    private  String sobrenome;
    private float salario;
    private float beneficios;

    public SalarioFuncionarios(int id, String nome, String sobrenome, float salario, float beneficios) {
        this.id = id;
        this.nome = new String(nome);
        this.sobrenome = new String(sobrenome);
        this.salario = salario;
        this.beneficios = beneficios;
    }

    public String getNomeCompleto() {
        return new StringBuilder()
                .append(this.getNome())
                .append(" ")
                .append(this.getSobrenome())
                .toString();
    }

    public float getSalarioTotal() {
        return  this.getSalario() + this.getBeneficios();
    }

    public float getBeneficios() {
        return this.beneficios;
    }

    public float getSalario() {
        return this.salario;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public String getNome() {
        return this.nome;
    }
}



