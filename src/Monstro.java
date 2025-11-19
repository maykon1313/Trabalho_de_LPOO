package src;

public abstract class Monstro {
    private String nome;
    private double eficiencia;

    public Monstro(String nome){
        this.nome = nome;
        this.eficiencia = (Math.random()); // 0.0 - 1.0
    }

    public void setNome(String nome) { this.nome = nome; }
    public void setEficiencia(double eficiencia) { this.eficiencia = eficiencia; }

    public String getNome() { return nome; }
    public String getTipoMonstro() {
        if (this instanceof MonstroDoSusto) return "susto";
        else if (this instanceof MonstroDoRiso) return "riso";
        else if (this instanceof MonstroDeSuporte) return "suporte";
        else throw new IllegalStateException("Tipo de monstro desconhecido.");
    }

    // Riso gera mais energia 
    public final double getEficiencia() {
        if (this instanceof MonstroDoRiso) {
            return eficiencia;
        }
        else if (this instanceof MonstroDoSusto){
            return eficiencia * 2/3;
        }
        else if (this instanceof MonstroDeSuporte){
            return eficiencia;
        }
        else {
            return -1;
        }
    }

    public final double getRawEficiencia() {
        return eficiencia;
    }

    public final int coletarEnergiaDaCrianca(Crianca c) {
        if (c == null) return 0;

        String tipo = getTipoMonstro(); // “susto” ou “riso”
        int energiaBase = c.getEnergia(tipo);  // energia da criança
        double eficiencia = getEficiencia(); // eficiência do monstro

        return (int) (energiaBase * eficiencia);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Eficiência: " + String.format("%.4f", eficiencia);
    }
}