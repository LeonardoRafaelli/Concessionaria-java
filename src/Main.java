import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        menuPrincipal();
    }

    private static void menuPrincipal(){
        System.out.print("""
                \n---- Menu Principal ----
                1 - Cadastrar veículo;
                2 - Alterar veículo;
                3 - Remover veículo;
                4 - Listar veículo;
                5 - Encerrar;
                Digite aqui:\s""");
        int opcao = sc.nextInt();
        switch (opcao){
            case 1 -> {
                cadastraVeiculo();
                menuPrincipal();
            }
            case 2 -> {
                alterarVeiculo();
                menuPrincipal();
            }
            case 3 -> {
                removerVeiculo();
                menuPrincipal();
            }
            case 4 -> {
                listarVeiculos();
                menuPrincipal();
            }
            case 5 -> {
                System.exit(0);
            }
            default -> {
                System.out.print(opcao + ", Não é uma opção válida.");
                menuPrincipal();
            }
        }
    }

    private static void removerVeiculo(){
        int tipo = opcaoTipo("---- Remover ----");
        System.out.print("Insira a placa do veículo: ");
        String placa = sc.next();
        int i = indicePlaca(tipo, placa);
        if(i >= 0){
            switch (tipo){
                case 1 -> {
                    Carro.listaCarros.remove(i);
                    System.out.println("Carro removido com sucesso!");
                }
                case 2 -> {
                    Moto.listaMotos.remove(i);
                    System.out.println("Moto removida com sucesso!");
                }
            }

        } else {
            System.out.println("Placa do veículo não encontrada!");
        }
    }

    //Altera dados de algum veículo
    private static void alterarVeiculo(){
        int tipo = opcaoTipo("---- Alterar ----");
        System.out.print("Insira a placa do veículo: ");
        String placa = sc.next();
        int i = indicePlaca(tipo, placa);
        System.out.print("Alterar\n1 - Todos os atributos;\n2 - Atributos específicos\n3 - Redigitar placa;\n4 - Voltar para o menu principal.\nDigite aqui: ");
        int alterar = sc.nextInt();
        if(i >= 0) {
            switch (tipo) {
                case 1 -> {
                    switch (alterar) {
                        case 1 -> {
                            alterarCarAtributoS(i);
                        }
                        case 2 -> {
                            alterarCarAtributO(i);
                        }
                        case 3 -> {
                            alterarVeiculo();
                        }
                        case 4 -> {
                            menuPrincipal();
                        }
                        default -> {
                            System.out.println(alterar + ", não é uma opção válida.n\n");
                        }
                    }
                }
                case 2 -> {
                    switch (alterar){
                        case 1 -> {
                            alterarMotAtributoS(i);
                        }
                        case 2 -> {
                            alterarMotAtributO(i);
                        }
                        case 3 -> {
                            alterarVeiculo();
                        }
                        case 4 -> {
                            menuPrincipal();
                        }
                        default -> {
                            System.out.println(alterar + ", não é uma opção válida.n\n");
                        }
                    }
                }
            }
        } else {
            System.out.println("Placa do veículo não encontrada!");
        }
    }

    private static void alterarMotAtributO(int i) {
        System.out.print("\nSelecione o atributo que deseja alterar:" +
                "\n1 - Modelo;" +
                "\n2 - Placa;" +
                "\n3 - Ano;" +
                "\n4 - Preço;" +
                "\n5 - Cilindradas;" +
                "\n6 - Tempos do motor;" +
                "\n7 - Transmissão;" +
                "\nDigite aqui: ");
        int opcao = sc.nextInt();;
        switch (opcao){
            case 1 -> { System.out.print("Novo Modelo: "); Moto.listaMotos.get(i).setModelo(sc.next()); }
            case 2 -> { System.out.print("Nova Placa: "); Moto.listaMotos.get(i).setPlaca(sc.next()); }
            case 3 -> { System.out.print("Novo Ano: "); Moto.listaMotos.get(i).setAno(sc.nextInt()); }
            case 4 -> { System.out.print("Novo Preço: "); Moto.listaMotos.get(i).setPreco(sc.nextDouble()); }
            case 5 -> { System.out.print("Novas Cilindradas: "); Moto.listaMotos.get(i).setCilindradas(sc.nextInt()); }
            case 6 -> { System.out.print("Nova Tempos do motor: "); Moto.listaMotos.get(i).setTemposMotor(sc.nextInt()); }
            case 7 -> { System.out.print("Nova Transmissão: "); Moto.listaMotos.get(i).setTransmissao(sc.next()); }
        }
    }

    private static void alterarMotAtributoS(int i) {
        Automovel auto = cadastroAuto();

        System.out.print("Cilindradas: ");
        int cilindradas = sc.nextInt();
        System.out.print("Tempos do motor: ");
        int tempos = sc.nextInt();
        System.out.print("Quantidade de Portas: ");
        String transmissao = sc.next();

        Moto mot = new Moto(auto.getModelo(), auto.getPlaca(), auto.getAno(), auto.getPreco(), cilindradas, tempos, transmissao);
        Moto.listaMotos.set(i, mot);
    }

    private static void alterarCarAtributO(int i){
        System.out.print("\nSelecione o atributo que deseja alterar:" +
                "\n1 - Modelo;" +
                "\n2 - Placa;" +
                "\n3 - Ano;" +
                "\n4 - Preço;" +
                "\n5 - Cavalos de potência;" +
                "\n6 - Tração;" +
                "\n7 - Quantidade de portas;" +
                "\nDigite aqui: ");
        int opcao = sc.nextInt();;
        switch (opcao){
            case 1 -> { System.out.print("Novo Modelo: "); Carro.listaCarros.get(i).setModelo(sc.next()); }
            case 2 -> { System.out.print("Nova Placa: "); Carro.listaCarros.get(i).setPlaca(sc.next()); }
            case 3 -> { System.out.print("Novo Ano: "); Carro.listaCarros.get(i).setAno(sc.nextInt()); }
            case 4 -> { System.out.print("Novo Preço: "); Carro.listaCarros.get(i).setPreco(sc.nextDouble()); }
            case 5 -> { System.out.print("Novo Cavalos de Potência: "); Carro.listaCarros.get(i).setCavalosPotencia(sc.nextInt()); }
            case 6 -> { System.out.print("Nova Tração: "); Carro.listaCarros.get(i).setTracao(sc.next()); }
            case 7 -> { System.out.print("Nova Quantidade de portas: "); Carro.listaCarros.get(i).setQntdPortas(sc.nextInt()); }
        }
    }

    private static void listarVeiculos(){
        int tipo = opcaoTipo("---- Listar ----");
        switch (tipo){
            case 1 -> {
                for (int i = 0; i < Carro.listaCarros.size(); i++){
                    System.out.println(Carro.listaCarros.get(i).toString());
                }
            }
            case 2 -> {
                for (int i = 0; i < Moto.listaMotos.size(); i++){
                    System.out.println(Moto.listaMotos.get(i).toString());
                }
            }
        }
    }

    private static void alterarCarAtributoS(int i){
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
    private static int indicePlaca(int tipo, String placa){
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

    private static void cadastraVeiculo(){
        int tipo = opcaoTipo("---- Cadastrar ----");
        Automovel auto = cadastroAuto();
        switch (tipo){
            case 1 -> {

                System.out.print("Cavalos de potência: ");
                int cavalosPotencia = sc.nextInt();
                System.out.print("Tração: ");
                String tracao = sc.next();
                System.out.print("Quantidade de Portas: ");
                int qntdPortas = sc.nextInt();

                Carro car = new Carro(auto.getModelo(), auto.getPlaca(), auto.getAno(), auto.getPreco(), cavalosPotencia, tracao, qntdPortas);
                Carro.listaCarros.add(car);
            }
            case 2 -> {

                System.out.print("Cilindradas: ");
                int cilindradas = sc.nextInt();
                System.out.print("Tempos do Motor: ");
                int temposMotor = sc.nextInt();
                System.out.print("Transmissão: ");
                String transmissao = sc.next();

                Moto mot = new Moto(auto.getModelo(), auto.getPlaca(), auto.getAno(), auto.getPreco(), cilindradas, temposMotor, transmissao);
                Moto.listaMotos.add(mot);
            }
        }
    }

    private static int opcaoTipo(String cadastro) {
        System.out.print("\n" + cadastro +
                "\n1 - Carro;" +
                "\n2 - Moto." +
                "\nDigite aqui: ");
        return sc.nextInt();
    }

    private static Automovel cadastroAuto(){
        Automovel auto = new Automovel();
        System.out.print("\n---- Cadastro ----" +
                "\nInsira as seguintes informações" +
                "\nPlaca do veículo: ");
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
