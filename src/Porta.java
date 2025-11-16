package src;

public class Porta {
    private int id;
    private Crianca cotocos;

    public Porta(int id) {
        this.id = id;
    }

    public void setCrianca(Crianca cotocos) { this.cotocos = cotocos; }
    public void setId(int id) { this.id = id; }

    public void changeCrianca(Crianca c) {
        Crianca cri = this.getCrianca();
        cri.setPorta(null);

        this.cotocos = c;
        c.setPorta(this);
    }

    public Crianca getCrianca() { return this.cotocos; }
    public int getId() { return this.id; }

    public String toString() { return "Porta ID: " + id + ", Criança: " + cotocos; }
}
