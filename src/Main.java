// 
package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        int deu_certo = menu(agencia);
       
        if (deu_certo == -1) {
            System.out.println("Erro no programa.");
        }

        else {
            System.out.println("Programa encerrado com sucesso.");
        }
    }

    public int selecionar_opcao(Scanner scanner) {
        return -1;
    }

    public static int mostrar_opcoes(Scanner scanner) {
        System.out.println("\n=== MENU MONSTROS S.A. ===");
        System.out.println("1 - Criar Monstro");
        System.out.println("2 - Criar Porta");
        System.out.println("3 - Criar Gabinete");
        System.out.println("4 - Criar Criança");
        System.out.println("5 - Criar Cilindro de Energia");
        System.out.println("6 - Mostrar informações");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        return opcao;
    }

    public static int menu(Agencia agencia) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            opcao = mostrar_opcoes(scanner);

            switch (opcao) {
                //1 - Criar Monstro
                case 1:
                    System.out.println("\n--- CRIAÇÃO DE MONSTRO ---");
                    System.out.print("Digite o nome do monstro: ");
                    String nomeMonstro = scanner.nextLine();

                    System.out.println("Escolha o tipo de monstro:");
                    System.out.println("1 - Monstro dos Risos");
                    System.out.println("2 - Monstro do Susto");
                    System.out.println("3 - Monstro de Suporte");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (tipo < 1 || tipo > 3) { System.out.println("Tipo inválido!"); }

                    else {
                        Monstro monstro = null;

                        if (tipo == 1) {
                            monstro = new MonstroDoRiso(nomeMonstro);
                            System.out.println("Monstro dos Risos criado com sucesso!");
                        }
                        else if (tipo == 2) {
                            monstro = new MonstroDoSusto(nomeMonstro);
                            System.out.println("Monstro do Susto criado com sucesso!");
                        }
                        else if (tipo == 3) {
                            monstro = new MonstroDeSuporte(nomeMonstro);
                            System.out.println("Monstro de Suporte criado com sucesso!");
                        }

                        if (monstro == null) {
                            System.out.println("Erro ao criar o monstro.");
                        }
                        else {
                            agencia.addMonstro(monstro);
                        }
                    }
                    
                    break;


                //2 - Criar Porta - 2BE or not 2BE      
                case 2:
                    System.out.print("Digite o ID do cilindro: ");
                    int IDporta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Selecione a Criança:");
                    agencia.mostrarCriancas();
                    int indexCrianca = scanner.nextInt();
                    scanner.nextLine();


                    break;


                //3 - Criar Gabinete
                case 3:
                    System.out.print("TODO");
                    break;


                //4 - Criar Criança
                case 4:
                    System.out.print("Digite o nome da criança: ");
                    String nomeCrianca = scanner.nextLine();
                    scanner.nextLine();

                    Crianca crianca = new Crianca(nomeCrianca);
                    agencia.addCrianca(crianca);

                    break;

                //5 - Criar Cilindro de Energia
                case 5:
                    System.out.print("Digite o ID do cilindro: ");
                    int IDcilindro = scanner.nextInt();
                    scanner.nextLine();

                    Cilindro cilindro = new Cilindro(IDcilindro);

                    agencia.addCilindro(cilindro);

                    break;

                case 6:
                    break;

                case 7:
                    scanner.close();
                    return 0;

                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;

            }
        }
    }
}












































