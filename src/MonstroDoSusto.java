package src;

// Subclasse Monstro do Susto
public final class MonstroDoSusto extends Monstro {
    public MonstroDoSusto(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + " | Eficiência: " + String.format("%.4f", this.getEficiencia()) + " | Tipo: Susto";
    }
}
