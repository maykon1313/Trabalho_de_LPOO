package src;

// SubClasse Monstro do Susto
public class MonstroDoSusto extends Monstro {
    public MonstroDoSusto(String nome) {
        super(nome);
    }

    @Override
    public void trabalhar() {
        System.out.println(getNome() + " Energia do susto coletada.");
    }
}
