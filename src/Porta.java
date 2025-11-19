package src;

public final class Porta {
    private int id;
    private Crianca cotocos;

    public Porta(int id) {
        this.id = id;
    }

    public Porta(int id, Crianca cotocos) {
        this.id = id;
        this.cotocos = cotocos;
    }

    public void setCrianca(Crianca cotocos) { this.cotocos = cotocos; }
    public void setId(int id) { this.id = id; }

    public void changeCrianca(Crianca c) {
    if (cotocos != null) { cotocos.setPorta(null); }
    this.cotocos = c;
    if (c != null) { c.setPorta(this); }
    }

    public Crianca getCrianca() { return this.cotocos; }
    public int getId() { return this.id; }

    @Override
    public String toString() { return "Porta ID: " + id + " | Criança: " + (cotocos != null ? cotocos.getNome() : "Nenhuma"); }
}
