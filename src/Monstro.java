package src;

public abstract class Monstro {
    private String nome;
    private int eficiencia;

    public Monstro(String nome) {
        this.nome = nome;
        this.eficiencia = (int)(Math.random() * 101);
    }

    public String getNome() {
        return nome;
    }

    public int getEficiencia() {
        return eficiencia;
    }

    public TipoMonstro getTipoMonstro() {
        return TipoMonstro.fromMonstro(this);
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome + " | eficiencia: " + eficiencia + " | tipo: " + getTipoMonstro().getTipo().toString());
    }

    public abstract void trabalhar();
}
