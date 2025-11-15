package src;

public abstract class Monstro {
    private String nome;
    private int eficiencia;

    public Monstro(String nome){
        this.nome = nome;
        this.eficiencia = (int)(Math.random()); 
        // 0.0 - 1.0
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEficiencia(int eficiencia) { this.eficiencia = eficiencia; }

    public String getTipoMonstro() {
        if (this instanceof MonstroDoSusto) return "susto";
        else if (this instanceof MonstroDoRiso) return "riso";
        else if (this instanceof MonstroDeSuporte) return "suporte";
        return null;
    }

    // Método único para gerar energia
    public int getEficiencia() {

        // Riso gera mais energia 
        if (this instanceof MonstroDoRiso) {
            return eficiencia;
        }

        // Susto médio
        else if (this instanceof MonstroDoSusto){
            return eficiencia * 2/3;
        }

        return 0;
    } 

    public int coletarEnergiaDaCrianca(Crianca c) {
        if (c == null) return 0;

        String tipo = getTipoMonstro(); // “susto” ou “riso”
        int energiaBase = c.getEnergia(tipo);  // energia da criança
        int eficiencia = getEficiencia(); // eficiência do monstro

        return energiaBase * eficiencia;
    }

    public String toString() {
        return "Nome: " + nome + "| Eficiencia: " + eficiencia + "| Tipo: " + getTipoMonstro();
    }

    public abstract void trabalhar();
}