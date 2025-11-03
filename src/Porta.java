package src;

public class Porta {
    private int id;
    private Crianca cotocos;

    public Porta(int id, Crianca cotocos) {
        this.id = id;
        this.cotocos = cotocos;
    }

    public void setCrianca(Crianca cotocos) { this.cotocos = cotocos; }
    public void setId(int id) { this.id = id; }

    public Crianca getCrianca() { return this.cotocos; }
    public int getId() { return this.id; }  
}
