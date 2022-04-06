public class Dono extends Funcionario{

    private double salario = 30000.0;

    public Dono(int matricula, int idade, String nome, String cpf, String genero, String telefone, String senha) {
        super(matricula, idade, nome, cpf, genero, telefone, senha);
    }

    @Override
    public void mudarSalario(double precoAuto){
        this.setSalario(this.getSalario());
    }

}
