public class Funcionario extends Pessoa{
    private String senha;

    public Funcionario(int matricula, int idade, String nome, String cpf, String genero, String telefone, String senha) {
        super(matricula, idade, nome, cpf, genero, telefone);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return super.toString() + " --- Funcionario{" +
                "senha='" + senha + '\'' +
                '}';
    }
}
