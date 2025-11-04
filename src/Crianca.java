package src;

public class Crianca {
    private String nome;
    private int energiaSusto;
    private int energiaRiso;

    Crianca(String nome) {
        this.nome = nome;
        this.energiaSusto = (int)(Math.random() * 101);
        this.energiaRiso = (int)(Math.random() * 101);
    }

    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return this.nome; }
    
    public void setEnergiaSusto(int energia) { this.energiaSusto = energia; }
    public void setEnergiaRiso(int energia) { this.energiaRiso = energia; }
    
    public int getEnergia(String tipo) {
        if (tipo == "susto") return this.energiaSusto;
        else if (tipo == "riso") return this.energiaRiso;
        else return -1;
    }

    public String toString() { return "Criança: " + nome; }
}
