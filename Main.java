import java.util.Scanner;

class Main {
    static class Produto {
        String nome;
        int codigo;
        String dtFabricacao;
        int qtd;
        String fornecedor;
        double valor;
    }

    static class CadastroFuncOP {
        String nomeA;
        int CPFA;
        int RGA;
        String enderecoA;
        int telefoneA;
        int qntdFilhosA;
    }

    static class CadastroFuncSP {
        String nomeB;
        int CPFB;
        int RGB;
        String enderecoB;
        int telefoneB;
        int qntdFilhosB;
    }

    static class CadastroFuncGR {
        String nomeC;
        int CPFC;
        int RGC;
        String enderecoC;
        int telefoneC;
        int qntdFilhosC;
    }

    static class CadastroFuncDR {
        String nomeD;
        int CPFD;
        int RGD;
        String enderecoD;
        int telefoneD;
        int qntdFilhosD;
    }

    static Produto[] produtos = new Produto[10];
    static CadastroFuncOP[] vetorA = new CadastroFuncOP[100];
    static CadastroFuncSP[] vetorB = new CadastroFuncSP[100];
    static CadastroFuncGR[] vetorC = new CadastroFuncGR[100];
    static CadastroFuncDR[] vetorD = new CadastroFuncDR[100];

    static int qtdProdutos = 0;
    static int qtdOP = 0, qtdSP = 0, qtdGR = 0, qtdDR = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar produtos
        for (int i = 0; i < 10; i++) {
            produtos[i] = new Produto();
        }

        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()

            switch (opcao) {
                case 1:
                    cadastroProd();
                    break;
                case 2:
                    exibirProd();
                    break;
                case 3:
                    cadastroFuncionario();
                    break;
                case 4:
                    mostrarDados();
                    break;
                case 5:
                    calcularSalario();
                    break;
                case 6:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            limparConsole(); // Limpa o console após cada operação
        } while (opcao != 6);
    }

    static void exibirMenuPrincipal() {
        System.out.println("Menu Principal:");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Exibir Produtos Cadastrados");
        System.out.println("3 - Cadastro de Funcionários");
        System.out.println("4 - Mostrar Dados dos Funcionários");
        System.out.println("5 - Calcular Salários e Descontos");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    static void cadastroProd() {
        if (qtdProdutos < 10) {
            System.out.print("Digite o Nome do Produto: ");
            produtos[qtdProdutos].nome = scanner.nextLine();

            System.out.print("Digite o Código do Produto: ");
            produtos[qtdProdutos].codigo = scanner.nextInt();
            scanner.nextLine(); // Consumir newline

            System.out.print("Digite a Data de Fabricação do Produto (dd/mm/aaaa): ");
            produtos[qtdProdutos].dtFabricacao = scanner.nextLine();

            System.out.print("Digite o Nome do Fornecedor: ");
            produtos[qtdProdutos].fornecedor = scanner.nextLine();

            System.out.print("Digite a Quantidade do Produto: ");
            produtos[qtdProdutos].qtd = scanner.nextInt();

            System.out.print("Digite o Valor do Produto: ");
            produtos[qtdProdutos].valor = scanner.nextDouble();
            scanner.nextLine(); // Consumir newline

            qtdProdutos++;
            System.out.println("Produto cadastrado com sucesso.");
        } else {
            System.out.println("Limite máximo de produtos cadastrados atingido (10 produtos).");
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera por qualquer tecla
    }

    static void exibirProd() {
        if (qtdProdutos > 0) {
            System.out.println("Produtos Cadastrados:");
            for (int i = 0; i < qtdProdutos; i++) {
                System.out.println("Nome: " + produtos[i].nome);
                System.out.println("Código: " + produtos[i].codigo);
                System.out.println("Data de Fabricação: " + produtos[i].dtFabricacao);
                System.out.println("Fornecedor: " + produtos[i].fornecedor);
                System.out.println("Quantidade: " + produtos[i].qtd);
                System.out.println("Valor: " + produtos[i].valor);
                System.out.println();
            }
        } else {
            System.out.println("Nenhum produto cadastrado.");
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera por qualquer tecla
    }

    static void cadastroFuncionario() {
        int opcFunc;
        do {
            exibirMenuFuncionarios();
            opcFunc = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()

            switch (opcFunc) {
                case 1:
                    cadastroOperarios();
                    break;
                case 2:
                    cadastroSupervisores();
                    break;
                case 3:
                    cadastroGerentes();
                    break;
                case 4:
                    cadastroDiretores();
                    break;
                case 5:
                    System.out.println("Retornando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            limparConsole(); // Limpa o console após cada operação
        } while (opcFunc != 5);
    }

    static void exibirMenuFuncionarios() {
        System.out.println("Menu de Cadastro de Funcionários:");
        System.out.println("1 - Cadastro de Operários");
        System.out.println("2 - Cadastro de Supervisores");
        System.out.println("3 - Cadastro de Gerentes");
        System.out.println("4 - Cadastro de Diretores");
        System.out.println("5 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    static void cadastroOperarios() {
        System.out.print("Digite o número de operários a cadastrar: ");
        int opA = scanner.nextInt();
        scanner.nextLine(); // Consumir newline após o nextInt()

        for (int i = 0; i < opA; i++) {
            vetorA[qtdOP] = new CadastroFuncOP();
            System.out.println(" ");
            System.out.println("Cadastro do Operário " + (i + 1));
            System.out.print("Nome: ");
            vetorA[qtdOP].nomeA = scanner.nextLine();
            System.out.print("CPF: ");
            vetorA[qtdOP].CPFA = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("RG: ");
            vetorA[qtdOP].RGA = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("Endereço: ");
            vetorA[qtdOP].enderecoA = scanner.nextLine();
            System.out.print("Telefone: ");
            vetorA[qtdOP].telefoneA = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("Quantidade de Filhos: ");
            vetorA[qtdOP].qntdFilhosA = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()

            qtdOP++;
            System.out.println("Operário cadastrado com sucesso.");
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera por qualquer tecla
    }

    static void cadastroSupervisores() {
        System.out.print("Digite o número de supervisores a cadastrar: ");
        int opB = scanner.nextInt();
        scanner.nextLine(); // Consumir newline após o nextInt()

        for (int i = 0; i < opB; i++) {
            vetorB[qtdSP] = new CadastroFuncSP();
            System.out.println(" ");
            System.out.println("Cadastro do Supervisor " + (i + 1));
            System.out.print("Nome: ");
            vetorB[qtdSP].nomeB = scanner.nextLine();
            System.out.print("CPF: ");
            vetorB[qtdSP].CPFB = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("RG: ");
            vetorB[qtdSP].RGB = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("Endereço: ");
            vetorB[qtdSP].enderecoB = scanner.nextLine();
            System.out.print("Telefone: ");
            vetorB[qtdSP].telefoneB = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("Quantidade de Filhos: ");
            vetorB[qtdSP].qntdFilhosB = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()

            qtdSP++;
            System.out.println("Supervisor cadastrado com sucesso.");
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera por qualquer tecla
    }

    static void cadastroGerentes() {
        System.out.print("Digite o número de gerentes a cadastrar: ");
        int opC = scanner.nextInt();
        scanner.nextLine(); // Consumir newline após o nextInt()

        for (int i = 0; i < opC; i++) {
            vetorC[qtdGR] = new CadastroFuncGR();
            System.out.println(" ");
            System.out.println("Cadastro do Gerente " + (i + 1));
            System.out.print("Nome: ");
            vetorC[qtdGR].nomeC = scanner.nextLine();
            System.out.print("CPF: ");
            vetorC[qtdGR].CPFC = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("RG: ");
            vetorC[qtdGR].RGC = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("Endereço: ");
            vetorC[qtdGR].enderecoC = scanner.nextLine();
            System.out.print("Telefone: ");
            vetorC[qtdGR].telefoneC = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("Quantidade de Filhos: ");
            vetorC[qtdGR].qntdFilhosC = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()

            qtdGR++;
            System.out.println("Gerente cadastrado com sucesso.");
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera por qualquer tecla
    }

    static void cadastroDiretores() {
        System.out.print("Digite o número de diretores a cadastrar: ");
        int opD = scanner.nextInt();
        scanner.nextLine(); // Consumir newline após o nextInt()

        for (int i = 0; i < opD; i++) {
            vetorD[qtdDR] = new CadastroFuncDR();
            System.out.println(" ");
            System.out.println("Cadastro do Diretor " + (i + 1));
            System.out.print("Nome: ");
            vetorD[qtdDR].nomeD = scanner.nextLine();
            System.out.print("CPF: ");
            vetorD[qtdDR].CPFD = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("RG: ");
            vetorD[qtdDR].RGD = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("Endereço: ");
            vetorD[qtdDR].enderecoD = scanner.nextLine();
            System.out.print("Telefone: ");
            vetorD[qtdDR].telefoneD = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()
            System.out.print("Quantidade de Filhos: ");
            vetorD[qtdDR].qntdFilhosD = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()

            qtdDR++;
            System.out.println("Diretor cadastrado com sucesso.");
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera por qualquer tecla
    }

    static void exibirDadosOperarios() {
        if (qtdOP > 0) {
            System.out.println("Operários Cadastrados:");
            for (int i = 0; i < qtdOP; i++) {
                System.out.println("Nome: " + vetorA[i].nomeA);
                System.out.println("CPF: " + vetorA[i].CPFA);
                System.out.println("RG: " + vetorA[i].RGA);
                System.out.println("Endereço: " + vetorA[i].enderecoA);
                System.out.println("Telefone: " + vetorA[i].telefoneA);
                System.out.println("Quantidade de Filhos: " + vetorA[i].qntdFilhosA);
                System.out.println();
            }
        } else {
            System.out.println("Nenhum operário cadastrado.");
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera por qualquer tecla
    }

    static void exibirDadosSupervisores() {
        if (qtdSP > 0) {
            System.out.println("Supervisores Cadastrados:");
            for (int i = 0; i < qtdSP; i++) {
                System.out.println("Nome: " + vetorB[i].nomeB);
                System.out.println("CPF: " + vetorB[i].CPFB);
                System.out.println("RG: " + vetorB[i].RGB);
                System.out.println("Endereço: " + vetorB[i].enderecoB);
                System.out.println("Telefone: " + vetorB[i].telefoneB);
                System.out.println("Quantidade de Filhos: " + vetorB[i].qntdFilhosB);
                System.out.println();
            }
        } else {
            System.out.println("Nenhum supervisor cadastrado.");
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera por qualquer tecla
    }

    static void exibirDadosGerentes() {
        if (qtdGR > 0) {
            System.out.println("Gerentes Cadastrados:");
            for (int i = 0; i < qtdGR; i++) {
                System.out.println("Nome: " + vetorC[i].nomeC);
                System.out.println("CPF: " + vetorC[i].CPFC);
                System.out.println("RG: " + vetorC[i].RGC);
                System.out.println("Endereço: " + vetorC[i].enderecoC);
                System.out.println("Telefone: " + vetorC[i].telefoneC);
                System.out.println("Quantidade de Filhos: " + vetorC[i].qntdFilhosC);
                System.out.println();
            }
        } else {
            System.out.println("Nenhum gerente cadastrado.");
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera por qualquer tecla
    }

    static void exibirDadosDiretores() {
        if (qtdDR > 0) {
            System.out.println("Diretores Cadastrados:");
            for (int i = 0; i < qtdDR; i++) {
                System.out.println("Nome: " + vetorD[i].nomeD);
                System.out.println("CPF: " + vetorD[i].CPFD);
                System.out.println("RG: " + vetorD[i].RGD);
                System.out.println("Endereço: " + vetorD[i].enderecoD);
                System.out.println("Telefone: " + vetorD[i].telefoneD);
                System.out.println("Quantidade de Filhos: " + vetorD[i].qntdFilhosD);
                System.out.println();
            }
        } else {
            System.out.println("Nenhum diretor cadastrado.");
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera por qualquer tecla
    }

    static void mostrarDados() {
        int opcMostrar;
        do {
            exibirMenuMostrarDados();
            opcMostrar = scanner.nextInt();
            scanner.nextLine(); // Consumir newline após o nextInt()

            switch (opcMostrar) {
                case 1:
                    exibirDadosOperarios();
                    break;
                case 2:
                    exibirDadosSupervisores();
                    break;
                case 3:
                    exibirDadosGerentes();
                    break;
                case 4:
                    exibirDadosDiretores();
                    break;
                case 5:
                    System.out.println("Retornando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            limparConsole(); // Limpa o console após cada operação
        } while (opcMostrar != 5);
    }

    static void exibirMenuMostrarDados() {
        System.out.println("Menu de Mostrar Dados dos Funcionários:");
        System.out.println("1 - Mostrar Dados dos Operários");
        System.out.println("2 - Mostrar Dados dos Supervisores");
        System.out.println("3 - Mostrar Dados dos Gerentes");
        System.out.println("4 - Mostrar Dados dos Diretores");
        System.out.println("5 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    static void calcularSalario() {
        double valorHora = 10.0; // Exemplo de valor da hora
        double salario;

        System.out.println("Cálculo de Salários:");
        System.out.print("Digite o número de horas trabalhadas: ");
        double horasTrabalhadas = scanner.nextDouble();
        scanner.nextLine(); // Consumir newline após o nextDouble()

        // Exemplo de cálculo de salário para operários
        if (qtdOP > 0) {
            System.out.println("Salários dos Operários:");
            for (int i = 0; i < qtdOP; i++) {
                salario = valorHora * horasTrabalhadas;
                System.out.println("Operário: " + vetorA[i].nomeA);
                System.out.println("Salário: R$ " + salario);
                System.out.println();
            }
        } else {
            System.out.println("Nenhum operário cadastrado.");
        }

        // Aqui você pode implementar o cálculo de salário para os outros cargos
        // Supervisor, Gerente e Diretor, seguindo a lógica acima.

        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera por qualquer tecla
    }

    static void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar o console: " + e.getMessage());
        }
    }
}
