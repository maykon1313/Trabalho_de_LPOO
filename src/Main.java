package src;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        carregarDados(agencia);

        menuInterativo(agencia);
        
    }

    public static int mostrarOpcoes(Scanner scanner) {
        System.out.println("\n=== MENU MONSTROS S.A. ===");

        System.out.println("1 - Cadrastrar nova entidade.");
        System.out.println("2 - Manipular informações das entidades cadastradas.");
        System.out.println("3 - Mostrar entidades cadastradas.");
        System.out.println("4 - Trabalhar."); // TODO
        System.out.println("5 - Sair.");

        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao < 1 || opcao > 5) { return -1; }
        else { return opcao; }
    }

    public static int validarOpcao(Scanner scanner, int min, int max) {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao < min || opcao > max) {
                System.out.println("Entrada inválida.");
                return -1;
            }
            else { return opcao; }
        }

        catch (Exception e)  {
            System.out.println("Entrada inválida. Erro:" + e.getMessage());
            return -1;
        }
    }

    public static int validarInt(Scanner scanner) {
        try {
            int entrada = scanner.nextInt();
            scanner.nextLine();

            if (entrada < 0) {
                throw new IllegalArgumentException("Valor deve ser não negativo.");
            }

            return entrada; // TODO: Verificar valor repetido.
        }

        catch (Exception e)  {
            System.out.println("Entrada inválida. Erro:" + e.getMessage());
            return -1;
        }
    }

    public static String validarString(Scanner scanner) {
        try {
            String entrada = scanner.nextLine();

            if (entrada == null || entrada.trim().isEmpty()) {
                throw new IllegalArgumentException("Entrada inválida.");
            }

            return entrada.trim(); // TODO: Verificar valor repetido.
        }

        catch (Exception e)  {
            System.out.println("Entrada inválida. Erro:" + e.getMessage());
            return null;
        }
    }

    private static int perguntarSimNao(Scanner scanner, String pergunta) {
        System.out.println(pergunta + " (s/n)");
        String resposta = validarString(scanner);
        if (resposta == null) return -1;
        if (resposta.equalsIgnoreCase("s")) return 1;
        if (resposta.equalsIgnoreCase("n")) return 0;
        System.out.println("Resposta inválida.");
        return -1;
    }

    public static int cadrastrarNovaEntidade(Scanner scanner) {
        System.out.println("\n=== MENU CADRASTRAR NOVA ENTIDADE ===");

        System.out.println("1 - Cadrastrar Cilindro.");
        System.out.println("2 - Cadrastrar Criança.");
        System.out.println("3 - Cadrastrar Gabinete.");
        System.out.println("4 - Cadrastrar Monstro.");
        System.out.println("5 - Cadrastrar Porta.");
        System.out.println("6 - Retornar.");

        System.out.print("Escolha uma opção: ");

        return validarOpcao(scanner, 1, 6);
    }

    public static int cadrastrarCilindro(Scanner scanner, Agencia agencia) {
        System.out.println("\n=== CADASTRAR CILINDRO ===");
        
        System.out.print("Digite o ID do cilindro: ");
        int id = validarInt(scanner);
        if (id == -1) { return -1; }

        try {
            agencia.setCilindro(id);
            System.out.println("Cilindro cadastrado com sucesso!");
            return 0;
        }

        catch (Exception e) {
            System.out.println("Erro ao cadastrar cilindro: " + e.getMessage());
            return -1;
        }
    }

    public static int cadrastrarCrianca(Scanner scanner, Agencia agencia) {
        System.out.println("\n=== CADASTRAR CRIANÇA ===");

        System.out.print("Digite o nome da criança: ");
        String nome = validarString(scanner);
        if (nome == null) { return -1; }

        try {
            agencia.setCrianca(nome);
            System.out.println("Criança cadastrada com sucesso!");
            return 0;
        }

        catch (Exception e) {
            System.out.println("Erro ao cadastrar criança: " + e.getMessage());
            return -1;
        }
    }

    public static int cadrastrarGabinete(Scanner scanner, Agencia agencia) {
        System.out.println("\n=== CADASTRAR GABINETE ===");
        
        System.out.print("Digite o ID do gabinete: ");
        int id = validarInt(scanner);
        if (id == -1) { return -1; }

        System.out.println("Selecione a porta:");
        agencia.mostrarPortas();

        System.out.print("Digite o índice da porta: ");
        int indexPorta = validarInt(scanner);
        if (indexPorta == -1) { return -1; }

        Porta porta = agencia.getPorta(indexPorta);
        if (porta == null) {
            System.out.println("Porta não encontrada.");
            return -1;
        }

        System.out.println("Selecione o monstro principal:");
        agencia.mostrarMonstrosPrincipal();

        System.out.print("Digite o índice do monstro principal: ");
        int indexMonstroPrincipal = validarInt(scanner);
        if (indexMonstroPrincipal == -1) { return -1; }

        Monstro monstroPrincipal = agencia.getMonstroPrincipal(indexMonstroPrincipal);
        if (monstroPrincipal == null) {
            System.out.println("Monstro principal não encontrado.");
            return -1;
        }

        System.out.println("Selecione o monstro auxiliar:");
        agencia.mostrarMonstrosAuxiliar();

        System.out.print("Digite o índice do monstro auxiliar: ");
        int indexMonstroAuxiliar = validarInt(scanner);
        if (indexMonstroAuxiliar == -1) { return -1; }

        Monstro monstroAuxiliar = agencia.getMonstroAuxiliar(indexMonstroAuxiliar);
        if (monstroAuxiliar == null) {
            System.out.println("Monstro auxiliar não encontrado.");
            return -1;
        }

        try {
            agencia.setGabinete(id, porta, monstroPrincipal, monstroAuxiliar);
            System.out.println("Gabinete cadastrado com sucesso!");
            return 0;
        }

        catch (Exception e) {
            System.out.println("Erro ao cadastrar gabinete: " + e.getMessage());
            return -1;
        }
    }

    public static int cadrastrarMonstro(Scanner scanner, Agencia agencia) {
        System.out.println("\n=== CADASTRAR MONSTRO ===");

        System.out.println("Digite o nome do monstro: ");
        String nome = validarString(scanner);
        if (nome == null) { return -1; }

        System.out.print("Digite o tipo do monstro (1 - Susto, 2 - Riso, 3 - Suporte): ");
        int tipo = validarInt(scanner);
        if (tipo == -1) { return -1; }

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de monstro inválido.");
            return -1;
        }
        
        String tipoMonstro = tipo == 1 ? "susto" : tipo == 2 ? "riso" : "suporte";

        try {
            agencia.setMonstro(nome, tipoMonstro);
            System.out.println("Monstro cadastrado com sucesso!");
            return 0;
        }

        catch (Exception e) {
            System.out.println("Erro ao cadastrar monstro: " + e.getMessage());
            return -1;
        }
    }

    public static int cadrastrarPorta(Scanner scanner, Agencia agencia) {
        System.out.println("\n=== CADASTRAR PORTA ===");

        agencia.mostrarPortas();

        System.out.print("Digite o ID da porta: ");
        int id = validarInt(scanner);
        if (id == -1) { return -1; }

        System.out.println("Selecione a criança para associar à porta:");
        agencia.mostrarCriancas();

        System.out.print("Digite o índice da criança: ");
        int indexCrianca = validarInt(scanner);
        if (indexCrianca == -1) { return -1; }

        Crianca crianca = agencia.getCrianca(indexCrianca);
        
        if (crianca == null) {
            System.out.println("Criança não encontrada.");
            return -1;
        }

        try {
            agencia.setPorta(id, crianca);
            System.out.println("Porta cadastrada com sucesso!");
            return 0;
        }

        catch (Exception e) {
            System.out.println("Erro ao cadastrar porta: " + e.getMessage());
            return -1;
        }
    }

    public static int manipularEntidade(Scanner scanner) {
        System.out.println("\n=== MENU MANIPULAR ENTIDADE ===");

        System.out.println("1 - Manipular Cilindro.");
        System.out.println("2 - Manipular Criança.");
        System.out.println("3 - Manipular Gabinete.");
        System.out.println("4 - Manipular Monstro.");
        System.out.println("5 - Manipular Porta.");
        System.out.println("6 - Retornar.");

        System.out.print("Escolha uma opção: ");

        return validarOpcao(scanner, 1, 6);
    }

    public static int manipularCilindro(Scanner scanner, Agencia agencia) {
        System.out.println("\n=== MANIPULAR CILINDRO ===");

        agencia.mostrarCilindros();
        System.out.print("Digite o índice do cilindro a ser manipulado: ");
        int indexCilindro = validarInt(scanner);
        if (indexCilindro == -1) { return -1; }

        Cilindro cilindro = agencia.getCilindro(indexCilindro);
        if (cilindro == null) {
            System.out.println("Cilindro não encontrado.");
            return -1;
        }

        int resp = perguntarSimNao(scanner, "Mudar ID do cilindro (atual: " + cilindro.getId() + ")?");
        if (resp == -1) return -1;
        if (resp == 1) {
            System.out.print("Digite o novo ID do cilindro: ");
            int novoId = validarInt(scanner);
            if (novoId == -1) { return -1; }

            try {
                cilindro.setId(novoId);
                System.out.println("ID do cilindro alterado com sucesso!");
                return 0;
            }

            catch (Exception e) {
                System.out.println("Erro ao alterar ID do cilindro: " + e.getMessage());
                return -1;
            }
        } else {
            System.out.println("Alteração de ID cancelada.");
            return 0;
        }
    }

    public static int manipularCrianca(Scanner scanner, Agencia agencia) {
        System.out.println("\n=== MANIPULAR CRIANÇA ===");

        agencia.mostrarCriancas();
        System.out.print("Digite o índice da criança a ser manipulada: ");
        int indexCrianca = validarInt(scanner);
        if (indexCrianca == -1) { return -1; }

        Crianca crianca = agencia.getCrianca(indexCrianca);
        if (crianca == null) {
            System.out.println("Criança não encontrada.");
            return -1;
        }

        int resp = perguntarSimNao(scanner, "Mudar nome da criança (atual: " + crianca.getNome() + ")?");
        if (resp == -1) return -1;
        if (resp == 1) {
            System.out.print("Digite o novo nome da criança: ");
            String novoNome = validarString(scanner);
            if (novoNome == null) { return -1; }

            try {
                crianca.setNome(novoNome);
                System.out.println("Nome da criança alterado com sucesso!");
                return 0;
            }

            catch (Exception e) {
                System.out.println("Erro ao alterar nome da criança: " + e.getMessage());
                return -1;
            }
        } else {
            System.out.println("Alteração de nome cancelada.");
            return 0;
        }
    }

    public static int manipularGabinete(Scanner scanner, Agencia agencia) {
        System.out.println("\n=== MANIPULAR GABINETE ===");

        System.out.println("Selecione o gabinete:");
        agencia.mostrarGabinetes();

        System.out.print("Digite o índice do gabinete: ");
        int gabineteIndex = validarInt(scanner);

        Gabinete gabinete = agencia.getGabinete(gabineteIndex);
        if (gabinete == null) {
            System.out.println("Gabinete não encontrado.");
            return -1;
        }

        int resp = perguntarSimNao(scanner, "Mudar ID do gabinete (atual: " + gabinete.getId() + ")?");
        if (resp == -1) return -1;
        if (resp == 1) {
            System.out.print("Digite o novo ID do gabinete: ");
            int novoId = validarInt(scanner);
            if (novoId == -1) { return -1; }

            try {
                gabinete.setId(novoId);
                System.out.println("ID do gabinete alterado com sucesso!");
                return 0;
            }

            catch (Exception e) {
                System.out.println("Erro ao alterar ID do gabinete: " + e.getMessage());
                return -1;
            }
        } else {
            System.out.println("Alteração de nome cancelada.");
            return 0;
        }
    }

    public static int manipularMonstro(Scanner scanner, Agencia agencia) {
        System.out.println("\n=== MANIPULAR MONSTRO ===");
        System.out.println("TODO");
        return 0;
    }

    public static int manipularPorta(Scanner scanner, Agencia agencia) {
        System.out.println("\n=== MANIPULAR PORTA ===");

        System.out.print("Digite o índice da porta a ser manipulada: ");
        int portaIndex = validarInt(scanner);

        Porta porta = agencia.getPorta(portaIndex);

        if (porta == null) {
            System.out.println("Porta não encontrada.");
            return -1;
        }

        int resp = perguntarSimNao(scanner, "Mudar o ID da porta?");
        if (resp == -1) return -1;
        if (resp == 1) {
            System.out.print("Digite o novo ID da porta: ");
            int novoId = validarInt(scanner);
            if (novoId == -1) { return -1; }

            try {
                porta.setId(novoId);
                System.out.println("ID da porta alterado com sucesso!");
            }

            catch (Exception e) {
                System.out.println("Erro ao alterar ID da porta: " + e.getMessage());
                return -1;
            }
        } else {
            System.out.println("Alteração de ID cancelada.");
        }

        resp = perguntarSimNao(scanner, "Mudar a criança associada da porta?");
        if (resp == -1) return -1;
        if (resp == 1) {
            System.out.println("Selecione a nova criança para associar à porta:");
            agencia.mostrarCriancas();

            System.out.print("Digite o índice da criança: ");
            int indexCrianca = validarInt(scanner);
            if (indexCrianca == -1) { return -1; }

            Crianca crianca = agencia.getCrianca(indexCrianca);
            
            if (crianca == null) {
                System.out.println("Criança não encontrada.");
                return -1;
            }

            try {
                porta.setCrianca(crianca);
                System.out.println("Criança associada à porta alterada com sucesso!");
                return 0;
            }

            catch (Exception e) {
                System.out.println("Erro ao alterar criança da porta: " + e.getMessage());
                return -1;
            }
        } else {
            System.out.println("Alteração de criança cancelada.");
            return 0;
        }
    }

    public static void menuInterativo(Agencia agencia) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            opcao = mostrarOpcoes(scanner);

            switch (opcao) {
                case 1:
                    opcao = cadrastrarNovaEntidade(scanner);

                    if (opcao == -1) { break; }

                    else {
                        if (opcao == 1) { cadrastrarCilindro(scanner, agencia); }
                        else if (opcao == 2) { cadrastrarCrianca(scanner, agencia); }
                        else if (opcao == 3) { cadrastrarGabinete(scanner, agencia); }
                        else if (opcao == 4) { cadrastrarMonstro(scanner, agencia); }
                        else if (opcao == 5) { cadrastrarPorta(scanner, agencia); }
                    }

                    break;

                case 2:
                    opcao = manipularEntidade(scanner);

                    if (opcao == -1) { break; }

                    else {
                        if (opcao == 1) { manipularCilindro(scanner, agencia); }
                        else if (opcao == 2) { manipularCrianca(scanner, agencia); }
                        else if (opcao == 3) { manipularGabinete(scanner, agencia); }
                        else if (opcao == 4) { manipularMonstro(scanner, agencia); }
                        else if (opcao == 5) { manipularPorta(scanner, agencia); }
                    }
                    
                    break;

                case 3:
                    agencia.mostrarEntidadesCadastradas();
                    break;

                case 4:
                    System.out.println("TODO: Trabalhar");
                    break;

                case 5:
                    salvarDados(agencia);
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        }
    }

    public static void salvarDados(Agencia agencia) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data/agencia.csv"))) {
            // Salvar Criancas
            writer.println("Criancas");
            writer.println("nome,energiaSusto,energiaRiso");
            for (Crianca c : agencia.getCriancas()) {
                writer.println(c.getNome() + "," + c.getEnergia("susto") + "," + c.getEnergia("riso"));
            }
            writer.println();

            // Salvar Monstros Principais
            writer.println("MonstrosPrincipais");
            writer.println("nome,eficiencia,tipo");
            for (Monstro m : agencia.getMonstrosPrincipal()) {
                writer.println(m.getNome() + "," + m.getEficiencia() + "," + m.getTipoMonstro());
            }
            writer.println();

            // Salvar Monstros Auxiliares
            writer.println("MonstrosAuxiliares");
            writer.println("nome,eficiencia,tipo");
            for (Monstro m : agencia.getMonstrosAuxiliares()) {
                writer.println(m.getNome() + "," + m.getEficiencia() + "," + m.getTipoMonstro());
            }
            writer.println();

            // Salvar Portas
            writer.println("Portas");
            writer.println("id,criancaNome");
            for (Porta p : agencia.getPortas()) {
                writer.println(p.getId() + "," + (p.getCrianca() != null ? p.getCrianca().getNome() : ""));
            }
            writer.println();

            // Salvar Gabinetes
            writer.println("Gabinetes");
            writer.println("id,portaId,monstroPrincipalNome,monstroAuxiliarNome");
            for (Gabinete g : agencia.getGabinetes()) {
                String portaId = g.getPorta() != null ? String.valueOf(g.getPorta().getId()) : "";
                String mpNome = g.getMonstroPrincipal() != null ? g.getMonstroPrincipal().getNome() : "";
                String maNome = g.getMonstroAuxiliar() != null ? g.getMonstroAuxiliar().getNome() : "";
                writer.println(g.getId() + "," + portaId + "," + mpNome + "," + maNome);
            }
            writer.println();

            // Salvar Cilindros
            writer.println("Cilindros");
            writer.println("id,armazenado");
            for (Cilindro c : agencia.getCilindros()) {
                writer.println(c.getId() + "," + c.getArmazenado());
            }

            System.out.println("Dados salvos com sucesso em data/agencia.csv");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static Monstro createMonstro(String nome, String tipo) {
        if ("susto".equals(tipo)) return new MonstroDoSusto(nome);
        else if ("riso".equals(tipo)) return new MonstroDoRiso(nome);
        else if ("suporte".equals(tipo)) return new MonstroDeSuporte(nome);
        else return null;
    }

    public static void carregarDados(Agencia agencia) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/agencia.csv"))) {
            String line;
            Map<String, Crianca> criancasMap = new HashMap<>();
            Map<String, Monstro> monstrosMap = new HashMap<>();
            Map<Integer, Porta> portasMap = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                if (line.equals("Criancas")) {
                    reader.readLine(); // skip header
                    while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                        String[] parts = line.split(",");
                        if (parts.length == 3) {
                            Crianca c = new Crianca(parts[0]);
                            c.setEnergiaSusto(Integer.parseInt(parts[1]));
                            c.setEnergiaRiso(Integer.parseInt(parts[2]));
                            agencia.addCrianca(c);
                            criancasMap.put(c.getNome(), c);
                        }
                    }
                } else if (line.equals("MonstrosPrincipais")) {
                    reader.readLine(); // skip header
                    while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                        String[] parts = line.split(",");
                        if (parts.length == 3) {
                            Monstro m = createMonstro(parts[0], parts[2]);
                            if (m != null) {
                                m.setEficiencia(Integer.parseInt(parts[1]));
                                agencia.addMonstroPrincipal(m);
                                monstrosMap.put(m.getNome(), m);
                            }
                        }
                    }
                } else if (line.equals("MonstrosAuxiliares")) {
                    reader.readLine(); // skip header
                    while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                        String[] parts = line.split(",");
                        if (parts.length == 3) {
                            Monstro m = createMonstro(parts[0], parts[2]);
                            if (m != null) {
                                m.setEficiencia(Integer.parseInt(parts[1]));
                                agencia.addMonstroAuxiliar(m);
                                monstrosMap.put(m.getNome(), m);
                            }
                        }
                    }
                } else if (line.equals("Portas")) {
                    reader.readLine(); // skip header
                    while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                        String[] parts = line.split(",");
                        if (parts.length == 2) {
                            int id = Integer.parseInt(parts[0]);
                            Crianca c = criancasMap.get(parts[1]);
                            Porta p = new Porta(id, c);
                            agencia.addPorta(p);
                            portasMap.put(id, p);
                        }
                    }
                } else if (line.equals("Gabinetes")) {
                    reader.readLine(); // skip header
                    while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                        String[] parts = line.split(",");
                        if (parts.length == 4) {
                            int id = Integer.parseInt(parts[0]);
                            Porta porta = portasMap.get(Integer.parseInt(parts[1]));
                            Monstro mp = monstrosMap.get(parts[2]);
                            Monstro ma = monstrosMap.get(parts[3]);
                            Gabinete g = new Gabinete(id, porta, mp, ma);
                            agencia.addGabinete(g);
                        }
                    }
                } else if (line.equals("Cilindros")) {
                    reader.readLine(); // skip header
                    while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                        String[] parts = line.split(",");
                        if (parts.length == 2) {
                            int id = Integer.parseInt(parts[0]);
                            Cilindro c = new Cilindro(id);
                            c.setArmazenado(Integer.parseInt(parts[1]));
                            agencia.addCilindro(c);
                        }
                    }
                }
            }
            System.out.println("Dados carregados com sucesso de data/agencia.csv");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}
