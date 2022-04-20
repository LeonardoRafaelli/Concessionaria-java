public class Dono extends Funcionario{

    private double salario = 30000.0;

    public Dono(int matricula, int idade, String nome, String cpf, String genero, String telefone, String senha) {
        super(matricula, idade, nome, cpf, genero, telefone, senha);
        this.salario = getSalario();
    }

    @Override
    public double getSalario() {
        return salario;
    }

    @Override
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void mudarSalario(double precoAuto){
        this.setSalario(this.getSalario());
    }

    @Override
    public String toString() {
        return super.toString(this.salario);
    }

    @Override
    public void removerPessoa(int i) {
        if(Pessoa.listaPessoas.get(i) instanceof Funcionario){
            Pessoa.listaPessoas.remove(i);
        } else {
            System.out.println("Matrícula não ligada a algum funcionário.");
        }
    }
}
