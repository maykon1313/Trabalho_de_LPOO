package src;

// SubClasse Monstro de Riso
public class MonstroDoRiso extends Monstro {
    public MonstroDoRiso(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + " | Eficiencia: " + String.format("%.4f", this.getEficiencia()) + " | Tipo: Riso";
    }
}
