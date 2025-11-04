package src;
import java.util.ArrayList;

public class MonstroDeSuporte extends Monstro {
    // Agora guardamos IDs das portas corretamente como inteiros
    private ArrayList<Integer> portas = new ArrayList<>();
    private int energiaGerenciada = 0;

    public MonstroDeSuporte(String nome){
        super(nome);
    }

    public void registrarPorta(int id) {
        portas.add(id);
        System.out.println(getNome() + " registrou a porta " + id);
    }

    // Pega o id da porta do gabinete da forma correta
    public void registrarPortaDoGabinete(Gabinete g) {
        if (g == null) {
            System.out.println(getNome() + ": gabinete não definido.");
            return;
        }

        Porta p = g.getPorta();
        if (p == null) {
            System.out.println(getNome() + ": gabinete " + g.getId() + " não tem porta definida.");
            return;
        }

        registrarPorta(p.getId());
    }

    public void receberEnergia(int energia, Cilindro c) {
        c.armazenarEnergia(energia);
        System.out.println(getNome() + " amazenou " + energia + " unidades de energia para gerenciamento no cilindro " + c.getId() + ".");
    }


    public void mostrarRelatorio() {
        System.out.println("\n --- Relatório do Suporte ---");
        System.out.println("Monstro: " + getNome());
        System.out.println("Portas Administradas: " + portas);
        System.out.println("Energia Total Administrada: " + energiaGerenciada);
        System.out.println("-----------------------\n");
    }

    @Override
    public void trabalhar() {
        System.out.println(getNome() + " está administrando as portas e energia. ");
    }
}
