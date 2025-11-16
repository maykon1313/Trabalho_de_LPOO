package src;

public class Crianca {
    private String nome;
    private int energiaSusto;
    private int energiaRiso;
    private Porta porta;

    Crianca(String nome) {
        this.nome = nome;
        this.energiaSusto = (int)(Math.random() * 101);
        this.energiaRiso = (int)(Math.random() * 101);
    }

    public Porta getPorta(){ return this.porta; }
    public void setPorta(Porta porta){ this.porta = porta; }

    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return this.nome; }

    public void setEnergiaSusto(int energia) { this.energiaSusto = energia; }
    public void setEnergiaRiso(int energia) { this.energiaRiso = energia; }
        
    public int getEnergia(String tipo) {
        if (tipo.equals("susto")) return this.energiaSusto;
        else if (tipo.equals("riso")) return this.energiaRiso;
        else return -1;
    }

    public String toString() { return "Criança: " + nome + " | Energia de Susto: " + energiaSusto + " | Energia de Riso: " + energiaRiso; }
}
