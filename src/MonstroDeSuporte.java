package src;

// SubClasse Monstro de Suporte
public class MonstroDeSuporte extends Monstro {
    public MonstroDeSuporte(String nome) {
        super(nome);
    }

    @Override
    public void trabalhar() {
        System.out.println(getNome() + " Suporte fornecido.");
    }
}

