package src;

// SubClasse Monstro de Riso
public class MonstroDoRiso extends Monstro {
    public MonstroDoRiso(String nome) {
        super(nome);
    }

    @Override
    public void trabalhar() {
        System.out.println(getNome() + " Energia do riso coletada.");
    }
}
