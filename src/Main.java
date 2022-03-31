import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Pessoa.listaPessoas.add(new Dono(1, 45, "Josescreudo", "11209407965", "Masculino", "991964275", "123"));
        Pessoa.listaPessoas.add(new Funcionario(2, 25, "Filipe", "12345678910", "Masculino", "991521540", "321"));
        programa();
    }

    private static void programa(){
        int i = login();
        if(i > -1){
            menuPrincipal(i);
        } else {
            System.out.println("Matrícula e/ou senha inválidos!");
            programa();
        }
    }

    private static int login(){
        System.out.print("Matrícula: ");
        int matricula = sc.nextInt();
        System.out.print("Senha: ");
        String senha = sc.next();

        for(int i = 0; i < Pessoa.listaPessoas.size(); i++){
            if(Pessoa.listaPessoas.get(i).getMatricula() == matricula && ((Funcionario)Pessoa.listaPessoas.get(i)).getSenha().equals(senha)){
                return i;
            }
        }
        return -1;
    }

    private static void menuPrincipal(int i){
        System.out.print("""
                                
                ---- Menu Principal ----
                1 - Cadastrar veículo;
                2 - Alterar veículo;
                3 - Remover veículo;
                4 - Listar veículos;
                5 - Listar veículos vendidos;
                6 - Vender veículo;
                7 - Listar clientes;
                8 - Editar clientes;
                9 - Listar Funcionários;
                10 - Cadastrar clientes;
                11 - Sair <<<< ;
                12 - !!! - Encerrar;""");
        if(Pessoa.listaPessoas.get(i) instanceof Dono){
            System.out.println("\n13 - Cadastrar cliente;");
            System.out.print("14 - Cadastrar funcionário;" +
                    "\n15 - Editar funcionário;" +
                    "\nDigite aqui: ");
        }

        int opcao = sc.nextInt();
        if(opcao <= 13){
            switch (opcao){
                case 1 -> { cadastraVeiculo(); }
                case 2 -> { alterarVeiculo(); }
                case 3 -> { removerVeiculo(); }
                case 4 -> { listarVeiculos(); }
                case 5 -> { listarVeiculosVendidos(); }
                case 6 -> { venderVeiculo(); }
                case 7 -> listarPessoa(1);
                case 8 -> editarPessoa(1);
                case 9 -> listarPessoa(2);
                case 10 -> cadastroPessoa(1);
                case 11 -> programa();
                case 12 -> System.exit(0);
                default -> {
                    System.out.print(opcao + ", Não é uma opção válida.");
                }
            }
        } else if(opcao <= 15) {
            if(Pessoa.listaPessoas.get(i) instanceof Dono){
                if(opcao == 14){
                    cadastroPessoa(2);
                } else {
                    editarPessoa(2);
                }
            } else {
                System.out.println("Opção inválida!");
            }
        } else {
            System.out.println("Opção inválida!");
        }
        menuPrincipal(i);
    }

    private static void cadastroPessoa(int tipo){
        Pessoa.listaPessoas.add(coletaDadosPessoa(tipo));
    }

    private static Pessoa coletaDadosPessoa(int tipo){
        System.out.println("--- CADASTRO ---");
        System.out.print("Matrícula: ");
        int matricula = sc.nextInt();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("Gênero: ");
        String genero = sc.next();
        System.out.print("Telefone: ");
        String telefone = sc.next();
        if(tipo == 1){
           return new Cliente(matricula, idade, nome, cpf, genero, telefone);
        } else {
            System.out.print("Senha: ");
            return new Funcionario(matricula, idade, nome, cpf, genero, telefone, sc.next());
        }
    }

    private static void editarPessoa(int tipo){
        System.out.print("Insira a matrícula da pessoa que deseja editar: ");
        int matricula = sc.nextInt();
        for (int i = 0; i < Pessoa.listaPessoas.size(); i++){
            if(Pessoa.listaPessoas.get(i).getMatricula() == matricula){
                Pessoa.listaPessoas.set(i, coletaDadosPessoa(tipo));
            }
        }
    }

    private static void listarPessoa(int tipo){
        if(tipo == 1){
            Pessoa.listaPessoas.forEach(pessoa -> {
                if(pessoa instanceof Cliente){
                    System.out.println(pessoa);
                }
            });
        } else {
            Pessoa.listaPessoas.forEach(pessoa -> {
                if(pessoa instanceof Funcionario){
                    System.out.println(pessoa);
                }
            });
        }
    }

    private static void venderVeiculo(){
        System.out.print("Insira a placa do veículo vendido: ");
        String placa = sc.next();
        int i = indicePlaca(placa);
       if(i > -1){
           Automovel.listaAutomoveisVendidos.add(Automovel.listaAutomoveis.get(i));
           Automovel.listaAutomoveis.remove(i);
           System.out.println("Automóvel vendido com sucesso!");
       } else {
           System.out.println("Placa não encontrada!");
       }
    }

    private static void removerVeiculo(){
        System.out.print("Insira a placa do veículo: ");
        String placa = sc.next();
        int i = indicePlaca(placa);
        if(i >= 0){
            Automovel.listaAutomoveis.remove(i);
        } else {
            System.out.println("Placa do veículo não encontrada!");
        }
    }

    //Altera dados de algum veículo
    private static void alterarVeiculo(){
        int tipo = opcaoTipo("---- Alterar ----");
        System.out.print("Insira a placa do veículo: ");
        String placa = sc.next();
        int i = indicePlaca(placa);
        System.out.print("Alterar\n1 - Todos os atributos;\n2 - Atributos específicos\n3 - Redigitar placa;\n4 - Voltar para o menu principal.\nDigite aqui: ");
        int alterar = sc.nextInt();
        if(i >= 0) {
            switch (alterar) {
                case 1 -> alteraTodosAtrb(tipo, i);
                case 2 -> alterarAtributO(tipo, i);
                case 3 -> alterarVeiculo();
                case 4 -> menuPrincipal(i);
                default -> {
                    System.out.println(alterar + ", não é uma opção válida.n\n");
                    alterarVeiculo();
                }
            }
        } else {
            System.out.println("Placa do veículo não encontrada!");
        }
    }

    private static void alteraTodosAtrb(int tipo, int i) {
        Automovel.listaAutomoveis.set(i, cadastroAuto(tipo));
    }

    private static void alterarAtributO(int tipo, int i){
        System.out.print("""

                Selecione o atributo que deseja alterar:
                1 - Modelo;
                2 - Placa;
                3 - Ano;
                4 - Preço;""");
        switch (tipo){
            case 1 ->
                System.out.println(
                    "\n5 - Cavalos de potência;" +
                    "\n6 - Tração;" +
                    "\n7 - Quantidade de portas;" +
                    "\nDigite aqui: ");
            case 2 ->
                System.out.println(
                    "\n5 - Cilindradas;" +
                    "\n6 - Tempos do motor;" +
                    "\n7 - Transmissão;" +
                    "\nDigite aqui: ");

        }
        int opcao = sc.nextInt();
        switch (opcao){
            case 1 -> { System.out.print("Novo Modelo: "); Automovel.listaAutomoveis.get(i).setModelo(sc.next()); }
            case 2 -> { System.out.print("Nova Placa: "); Automovel.listaAutomoveis.get(i).setPlaca(sc.next()); }
            case 3 -> { System.out.print("Novo Ano: ");Automovel.listaAutomoveis.get(i).setAno(sc.nextInt()); }
        }
        if(tipo == 1){
            switch (opcao){
                case 4 -> { System.out.print("Novos cavalos de potência: "); ((Carro) Automovel.listaAutomoveis.get(i)).setCavalosPotencia(sc.nextInt()); }
                case 5 -> { System.out.print("Nova tração: "); ((Carro) Automovel.listaAutomoveis.get(i)).setTracao(sc.next()); }
                case 6 -> { System.out.print("Nova quantidade de portas: "); ((Carro) Automovel.listaAutomoveis.get(i)).setQntdPortas(sc.nextInt()); }
            }
        } else {
            switch (opcao){
                case 4 -> { System.out.print("Novas cilindradas: "); ((Moto) Automovel.listaAutomoveis.get(i)).setCilindradas(sc.nextInt()); }
                case 5 -> { System.out.print("Novo tempos do motor: "); ((Moto) Automovel.listaAutomoveis.get(i)).setTemposMotor(sc.nextInt()); }
                case 6 -> { System.out.print("Nova transmissão: "); ((Moto) Automovel.listaAutomoveis.get(i)).setTransmissao(sc.next()); }
            }
        }
    }

    private static void listarVeiculos(){
        int tipo = opcaoTipo("---- Listar ----");
        switch (tipo){
            case 1 ->
                Automovel.listaAutomoveis.forEach(auto -> {
                    if(auto instanceof Carro){
                        System.out.println(auto);
                    }
                });
            case 2 ->
                Automovel.listaAutomoveis.forEach(auto -> {
                    if(auto instanceof Moto){
                        System.out.println(auto);
                    }
                });

        }
    }

    private static void listarVeiculosVendidos(){
        int tipo = opcaoTipo("---- Listar ----");
        switch (tipo) {
            case 1 -> Automovel.listaAutomoveisVendidos.forEach(auto -> {
                if (auto instanceof Carro) {
                    System.out.println(auto);
                }
            });
            case 2 -> Automovel.listaAutomoveisVendidos.forEach(auto -> {
                if (auto instanceof Moto) {
                    System.out.println(auto);
                }
            });
        }
    }

    //Verifica a existência da placa
    private static int indicePlaca(String placa){
        for(int i = 0; i < Automovel.listaAutomoveis.size(); i++){
            if(Automovel.listaAutomoveis.get(i).getPlaca().equals(placa)){
                return i;
            }
        }
        return -1;
    }

    private static void cadastraVeiculo(){
        int tipo = opcaoTipo("---- Cadastrar ----");
        Automovel.listaAutomoveis.add(cadastroAuto(tipo));
        System.out.println("Deu boa guri!!!!!!!!");
    }

    private static int opcaoTipo(String titulo) {
        System.out.print("\n" + titulo +
                "\n1 - Carro;" +
                "\n2 - Moto." +
                "\nDigite aqui: ");
        return sc.nextInt();
    }

    private static Automovel cadastroAuto(int tipo){
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
        if(tipo == 1){
            System.out.print("Cavalos de potência: ");
            int cavalosPotencia = sc.nextInt();
            System.out.print("Tração: ");
            String tracao = sc.next();
            System.out.print("Quantidade de Portas: ");
            int qntdPortas = sc.nextInt();

            return new Carro(auto.getModelo(), auto.getPlaca(), auto.getAno(), auto.getPreco(), cavalosPotencia, tracao, qntdPortas);
        } else {
            System.out.print("Cilindradas: ");
            int cilindradas = sc.nextInt();
            System.out.print("Tempos do Motor: ");
            int temposMotor = sc.nextInt();
            System.out.print("Transmissão: ");
            String transmissao = sc.next();

            return new Moto(auto.getModelo(), auto.getPlaca(), auto.getAno(), auto.getPreco(), cilindradas, temposMotor, transmissao);
        }
    }
}