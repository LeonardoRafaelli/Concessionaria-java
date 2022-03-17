import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        menuPrincipal();
    }

    public static void menuPrincipal(){
        System.out.print("""
                ---- Menu Principal ----
                1 - Cadastrar veículo;
                2 - Alterar veículo;
                3 - Remover veículo;
                4 - Listar veículo;
                5 - Encerrar;
                Digite aqui:\s""");
        int opcao = sc.nextInt();
        switch (opcao){
            case 1 -> {
                cadastraAlteraVeiculo(1, 0);
                menuPrincipal();
            }
            case 2 -> {
                alterarVeiculo();
                menuPrincipal();
            }
            case 4 -> {
                listarVeiculos();
                menuPrincipal();
            }
        }
    }

    //Altera dados de algum veículo
    public static void alterarVeiculo(){
        int tipo = opcaoTipo("---- Alterar ----");
        switch (tipo){
            case 1 -> {
                System.out.print("Insira a placa do veículo: ");
                String placa = sc.next();
                int i = indicePlaca(1, placa);

                if(i >= 0){
                    System.out.print("Alterar\n1 - Todos os atributos;\n2 - Atributos específicos\nDigite aqui: ");
                    int alterar = sc.nextInt();
                    switch (alterar) {
                        case 1 -> {
                            cadastraAlteraVeiculo(2, i);
                        }
                        case 2 -> {
//                            alterarAtributo();
                        }
                    }
                } else {
                    System.out.println("Placa não encontrada!");
                }
            }
        }
    }

    public static void listarVeiculos(){
        int tipo = opcaoTipo("---- Listar ----");
        switch (tipo){
            case 1 -> {
                for (int i = 0; i < Carro.listaCarros.size(); i++){
                    Carro.listaCarros.get(i).toString();
                    System.out.println("Teste");
                }
            }
            default -> System.out.println("teste11");
        }
    }

    public static void alterarAtributoS(int i){
        Automovel auto = cadastroAuto();

        System.out.print("Cavalos de potência: ");
        int cavalosPotencia = sc.nextInt();
        System.out.print("Tração: ");
        String tracao = sc.next();
        System.out.print("Quantidade de Portas: ");
        int qntdPortas = sc.nextInt();

        Carro car = new Carro(auto.getModelo(), auto.getPlaca(), auto.getAno(), auto.getPreco(), cavalosPotencia, tracao, qntdPortas);
        Carro.listaCarros.set(i, car);
    }

    //Verifica a existência da placa
    public static int indicePlaca(int tipo, String placa){
        switch (tipo){
            case 1 -> {
                for (int i = 0; i < Carro.listaCarros.size(); i++) {
                    if (Carro.listaCarros.get(i).getPlaca().equals(placa)) {
                        return i;
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < Moto.listaMotos.size(); i++) {
                    if (Moto.listaMotos.get(i).getPlaca().equals(placa)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void cadastraAlteraVeiculo(int opcao, int i){
        int tipo = opcaoTipo("---- Cadastrar ----");
        switch (tipo){
            case 1 -> {
                Automovel auto = cadastroAuto();

                System.out.print("Cavalos de potência: ");
                int cavalosPotencia = sc.nextInt();
                System.out.print("Tração: ");
                String tracao = sc.next();
                System.out.print("Quantidade de Portas: ");
                int qntdPortas = sc.nextInt();

                Carro car = new Carro(auto.getModelo(), auto.getPlaca(), auto.getAno(), auto.getPreco(), cavalosPotencia, tracao, qntdPortas);
                if(opcao == 1){
                    Carro.listaCarros.add(car);
                } else {
                    Carro.listaCarros.set(i, car);
                }
            }
        }
    }

    public static int opcaoTipo(String cadastro) {
        System.out.print(cadastro +
                "\n1 - Carro;" +
                "\n2 - Moto." +
                "\nDigite aqui: ");
        return sc.nextInt();
    }

    public static Automovel cadastroAuto(){
        Automovel auto = new Automovel();
        System.out.print("---- Cadastro ----\nInsira as seguintes informações" +
                "Placa do veículo: ");
        auto.setPlaca(sc.next());
        System.out.print("Modelo: ");
        auto.setModelo(sc.next());
        System.out.print("Ano: ");
        auto.setAno(sc.nextInt());
        System.out.print("Preço: ");
        auto.setPreco(sc.nextInt());
        return auto;
    }

}
