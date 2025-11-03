package src;

import java.util.*;

public class Agencia {
    ArrayList<Monstro> monstros;
    ArrayList<Porta> portas;
    ArrayList<Gabinete> gabinetes;
    ArrayList<Crianca> criancas;
    ArrayList<Cilindro> cilindros;

    public Agencia() {
        monstros = new ArrayList<Monstro>();
        portas = new ArrayList<Porta>();
        gabinetes = new ArrayList<Gabinete>();
        criancas = new ArrayList<Crianca>();
        cilindros = new ArrayList<Cilindro>();
    }

    public void addMonstro(Monstro m) { monstros.add(m); }
    public void addPorta(Porta p) { portas.add(p); }
    public void addGabinete(Gabinete g) { gabinetes.add(g); }
    public void addCrianca(Crianca c) { criancas.add(c); }
    public void addCilindro(Cilindro ce) { cilindros.add(ce); }
    
    private void mostrarLista(List<?> lista) {
        if (lista == null || lista.isEmpty()) { System.out.println("A lista está vazia."); return; }
        int i = 0; for (Object item : lista) { System.out.println(i + " - " + item); i++; }
    }

    public void mostrarMonstros() { mostrarLista(monstros); }
    public void mostrarPortas() { mostrarLista(portas); }
    public void mostrarGabinetes() { mostrarLista(gabinetes); }
    public void mostrarCriancas() { mostrarLista(criancas); }
    public void mostrarCilindros() { mostrarLista(cilindros); }

    private <T> T encontrarPorIndex(List<T> lista, int index) {
        if (lista == null || index < 0 || index >= lista.size()) return null;
        return lista.get(index);
    }

    public Monstro getMonstro(int index) { return encontrarPorIndex(monstros, index); }
    public Porta getPorta(int index) { return encontrarPorIndex(portas, index); }
    public Gabinete getGabinete(int index) { return encontrarPorIndex(gabinetes, index); }
    public Crianca getCrianca(int index) { return encontrarPorIndex(criancas, index); }
    public Cilindro getCilindro(int index) { return encontrarPorIndex(cilindros, index); }

    public void setMonstro(String nome, String tipo) {
    }

    public void setPorta(int id, Crianca crianca) {
        Porta porta = new Porta(id, crianca);
        portas.add(porta);
    }

    public void setGabinete(int id, Porta porta, Monstro m_principal, Monstro m_auxiliar) {
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

    public void criarPortaInterativa(Scanner scanner) {
        System.out.print("Digite o ID da porta: ");
        try {
            int IDporta = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            if (criancas.isEmpty()) {
                System.out.println("Nenhuma criança cadastrada. Cadastre uma antes de criar a porta.");
                return;
            }

            System.out.println("Selecione a Criança pelo índice:");
            mostrarCriancas();

            int indexCrianca = scanner.nextInt();
            scanner.nextLine(); // limpa buffer
            Crianca selected = getCrianca(indexCrianca);
            if (selected == null) {
                System.out.println("Índice de criança inválido.");
                return;
            }
            setPorta(IDporta, selected);
            System.out.println("Porta criada e vinculada à criança: " + selected.getNome());
        } catch (InputMismatchException ex) {
            System.out.println("Entrada inválida. Operação cancelada.");
            scanner.nextLine();
        }
    }
}
