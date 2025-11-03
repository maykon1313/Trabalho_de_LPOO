package src;

public class TipoMonstro {
    public enum Tipo {
        RISO,
        SUSTO,
        SUPORTE;

        @Override
        public String toString() {
            switch (this) {
                case RISO: return "Monstro dos Risos";
                case SUSTO: return "Monstro do Susto";
                case SUPORTE: return "Monstro de Suporte";
                default: return name();
            }
        }
    }

    private String nome;
    private int eficiencia;
    private Tipo tipo;

    // Construtor que gera eficiencia aleatoriamente
    public TipoMonstro(String nome, Tipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.eficiencia = (int) (Math.random() * 101);
    }

    // Construtor com eficiencia fornecida
    public TipoMonstro(String nome, Tipo tipo, int eficiencia) {
        this.nome = nome;
        this.eficiencia = eficiencia;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(int eficiencia) {
        this.eficiencia = eficiencia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | eficiencia: " + eficiencia + " | tipo: " + tipo.toString();
    }

    // Cria um TipoMonstro a partir de uma instância de Monstro existente
    public static TipoMonstro fromMonstro(Monstro m) {
        Tipo detected = Tipo.RISO;
        if (m instanceof MonstroDoRiso) detected = Tipo.RISO;
        else if (m instanceof MonstroDoSusto) detected = Tipo.SUSTO;
        else if (m instanceof MonstroDeSuporte) detected = Tipo.SUPORTE;
        return new TipoMonstro(m.getNome(), detected, m.getEficiencia());
    }
}
