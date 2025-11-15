package src;

import java.util.*;

public class Agencia {
    ArrayList<Monstro> monstrosPrincipal;
    ArrayList<Monstro> monstrosAuxiliares;
    ArrayList<Porta> portas;
    ArrayList<Gabinete> gabinetes;
    ArrayList<Crianca> criancas;
    ArrayList<Cilindro> cilindros;

    public Agencia() {
        monstrosPrincipal = new ArrayList<Monstro>();
        monstrosAuxiliares = new ArrayList<Monstro>();
        portas = new ArrayList<Porta>();
        gabinetes = new ArrayList<Gabinete>();
        criancas = new ArrayList<Crianca>();
        cilindros = new ArrayList<Cilindro>();
    }

    public void addMonstroPrincipal(Monstro m) { monstrosPrincipal.add(m); }
    public void addMonstroAuxiliar(Monstro m) { monstrosAuxiliares.add(m); }
    public void addPorta(Porta p) { portas.add(p); }
    public void addGabinete(Gabinete g) { gabinetes.add(g); }
    public void addCrianca(Crianca c) { criancas.add(c); }
    public void addCilindro(Cilindro ce) { cilindros.add(ce); }

    private int mostrarLista(List<?> lista) {
        if (lista == null || lista.isEmpty()) { System.out.println("A lista está vazia."); return -1; }
        int i = 0; for (Object item : lista) { System.out.println(i + " - " + item); i++; }
        return 0;
    }

    public int mostrarMonstros() {
        try {
            System.out.println("\nMonstros Principais:");
            mostrarLista(monstrosPrincipal);
            System.out.println("\nMonstros Auxiliares:");
            mostrarLista(monstrosAuxiliares);
            return 0;
        }

        catch (Exception e) {
            System.out.println("Erro ao mostrar monstros: " + e.getMessage());
            return -1;
        }
    }

    public int mostrarMonstrosPrincipal() { return mostrarLista(monstrosPrincipal); }
    public int mostrarMonstrosAuxiliar() { return mostrarLista(monstrosAuxiliares); }

    public int mostrarPortas() { return mostrarLista(portas); }
    public int mostrarGabinetes() { return mostrarLista(gabinetes); }
    public int mostrarCriancas() { return mostrarLista(criancas); }
    public int mostrarCilindros() { return mostrarLista(cilindros); }

    public int mostrarEntidadesCadastradas() {
        System.out.println("\n--- Entidades Cadastradas ---");
        mostrarMonstros();

        System.out.println("\nPortas Cadastradas");
        mostrarPortas();

        System.out.println("\nGabinetes Cadastradas");
        mostrarGabinetes();

        System.out.println("\nCriancas Cadastradas");
        mostrarCriancas();

        System.out.println("\nCilindros Cadastradas");
        mostrarCilindros();

        System.out.println("-----------------------------\n");
        return 0;
    }

    private <T> T encontrarPorIndex(List<T> lista, int index) {
        if (lista == null || index < 0 || index >= lista.size()) return null;
        return lista.get(index);
    }

    public Monstro getMonstroPrincipal(int index) { return encontrarPorIndex(monstrosPrincipal, index); }
    public Monstro getMonstroAuxiliar(int index) { return encontrarPorIndex(monstrosAuxiliares, index); }
    public Porta getPorta(int index) { return encontrarPorIndex(portas, index); }
    public Gabinete getGabinete(int index) { return encontrarPorIndex(gabinetes, index); }
    public Crianca getCrianca(int index) { return encontrarPorIndex(criancas, index); }
    public Cilindro getCilindro(int index) { return encontrarPorIndex(cilindros, index); }

    public ArrayList<Monstro> getMonstrosPrincipal() { return monstrosPrincipal; }
    public ArrayList<Monstro> getMonstrosAuxiliares() { return monstrosAuxiliares; }
    public ArrayList<Porta> getPortas() { return portas; }
    public ArrayList<Gabinete> getGabinetes() { return gabinetes; }
    public ArrayList<Crianca> getCriancas() { return criancas; }
    public ArrayList<Cilindro> getCilindros() { return cilindros; }

    public void setMonstro(String nome, String tipo) {
        Monstro monstro = null;
        
        if (tipo.equalsIgnoreCase("susto")) {
            monstro = new MonstroDoSusto(nome);
            monstrosPrincipal.add(monstro);
        } 
        else if (tipo.equalsIgnoreCase("riso")) {
            monstro = new MonstroDoRiso(nome);
            monstrosPrincipal.add(monstro);
        } 
        else if (tipo.equalsIgnoreCase("suporte")) {
            monstro = new MonstroDeSuporte(nome);
            monstrosAuxiliares.add(monstro);
        } 
        else {
            System.out.println("Tipo de monstro inválido: " + tipo);
            return;
        }
        
        System.out.println("Monstro " + nome + " (" + tipo + ") adicionado com sucesso.");
    }

    public void setPorta(int id, Crianca crianca) {
        Porta porta = new Porta(id, crianca);
        portas.add(porta);
    }

    public void setGabinete(int id, Porta porta, Monstro m_principal, MonstroDeSuporte m_auxiliar) {
        Gabinete g = new Gabinete(id, porta, m_principal, m_auxiliar);
        gabinetes.add(g);
    }
    
    public void setCrianca(String nome) {
        Crianca crianca = new Crianca(nome);
        criancas.add(crianca);
    }

    public void setCilindro(int id) {
        Cilindro cilindro = new Cilindro(id);
        cilindros.add(cilindro);
    }


    // nova função para processar o gabinete com o cilindro
    public void processarGabinete(int indexGabinete) {
        Gabinete g = getGabinete(indexGabinete);
        Cilindro c = g.getCilindro();
        Porta p = g.getPorta();
        Monstro m_principal = g.getMonstroPrincipal();
        MonstroDeSuporte m_auxiliar = g.getMonstroAuxiliar();

        //Caso seja inserido alguma informação errada
        if (g == null) {
            System.out.println("Erro: Gabinete inválido.");
            return;
        }
        if (c == null){
            System.out.println("Erro: Cilindro inválido.");
            return;
        }
        if (p == null){
            System.out.println("Erro: Porta inválida.");
            return;
        }
        if (m_principal == null){
            System.out.println("Erro: Monstro principal inválido.");
            return;
        }
        if (m_auxiliar == null){
            System.out.println("Erro: Monstro auxiliar inválido.");
            return;
        }

        // Chama o fluxo completo
        g.processarEnergia(c, p, m_principal, m_auxiliar);
    }
}
