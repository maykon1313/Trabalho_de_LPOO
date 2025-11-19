package src;

// SubClasse Monstro do Susto
public class MonstroDoSusto extends Monstro {
    public MonstroDoSusto(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + " | Eficiencia: " + String.format("%.4f", this.getEficiencia()) + " | Tipo: Susto";
    }
}
