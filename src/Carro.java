import java.util.ArrayList;

public class Carro extends Automovel{

    static ArrayList<Carro> listaCarros = new ArrayList<Carro>();

    private int cavalosPotencia;
    private String tracao;
    private int qntdPortas;

    public Carro() {
    }

    public Carro(String modelo, String placa, int ano, double preco, int horsePower, String tracao, int qntdPortas) {
        super(modelo, placa, ano, preco);
        this.cavalosPotencia = horsePower;
        this.tracao = tracao;
        this.qntdPortas = qntdPortas;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "cavalosPotencia=" + cavalosPotencia +
                ", tracao='" + tracao + '\'' +
                ", qntdPortas=" + qntdPortas +
                '}';
    }

    public int getCavalosPotencia() {
        return cavalosPotencia;
    }

    public void setCavalosPotencia(int cavalosPotencia) {
        this.cavalosPotencia = cavalosPotencia;
    }

    public String getTracao() {
        return tracao;
    }

    public void setTracao(String tracao) {
        this.tracao = tracao;
    }

    public int getQntdPortas() {
        return qntdPortas;
    }

    public void setQntdPortas(int qntdPortas) {
        this.qntdPortas = qntdPortas;
    }
}
