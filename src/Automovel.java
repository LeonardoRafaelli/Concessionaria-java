public class Automovel {

    private String modelo, placa;
    private int ano;
    private double preco;

    public Automovel() {
    }

    public Automovel(String modelo, String placa, int ano, double preco) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return super.toString() + " Automovel{" +
                "modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", ano=" + ano +
                ", preco=" + preco +
                '}';
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}