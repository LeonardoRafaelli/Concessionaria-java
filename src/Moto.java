import java.util.ArrayList;

public class Moto extends Automovel{

    static ArrayList<Moto> listaMotos = new ArrayList<Moto>();


    private int cilindradas, temposMotor;
    private String transmissao;

    public Moto() {
    }

    public Moto(String modelo, String placa, int ano, double preco, int cilindradas, int temposMotor, String transmissao) {
        super(modelo, placa, ano, preco);
        this.cilindradas = cilindradas;
        this.temposMotor = temposMotor;
        this.transmissao = transmissao;
    }

    @Override
    public String toString() {
        return super.toString() + " Moto{" +
                "cilindradas=" + cilindradas +
                ", temposMotor=" + temposMotor +
                ", transmissao='" + transmissao + '\'' +
                '}';
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public int getTemposMotor() {
        return temposMotor;
    }

    public void setTemposMotor(int temposMotor) {
        this.temposMotor = temposMotor;
    }

    public String getTransmissao() {
        return transmissao;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }
}
