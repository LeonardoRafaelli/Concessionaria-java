public class Funcionario extends Pessoa{
    private String senha;
    private double salario = 1250.0;

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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void mudarSalario(double precoAuto){
        this.salario += precoAuto * 0.02;
    }


    public void mudarSalario(double precoAuto, double porc){
        this.salario += precoAuto * porc;
    }


    @Override
    public String toString() {
        return super.toString() + " Funcionario{" +
                "senha='" + senha + '\'' +
                ", salario=" + salario +
                '}';
    }

    public String toString(double num) {
        return super.toString() + " Funcionario{" +
                "senha='" + senha + '\'' +
                ", salario=" + num +
                '}';
    }

}
