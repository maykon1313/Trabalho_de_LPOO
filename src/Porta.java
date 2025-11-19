package src;

public class Porta extends Identificador{
    
    private Crianca cotocos;

    public Porta() {
        
    }

    public void setCrianca(Crianca cotocos) { this.cotocos = cotocos; }
    

    public void changeCrianca(Crianca c) {
        Crianca cri = this.getCrianca();
        cri.setPorta(null);

        this.cotocos = c;
        c.setPorta(this);
    }

    public Crianca getCrianca() { return this.cotocos; }
    

    public String toString() { return "Porta ID: " + this.getId() + ", Criança: " + cotocos; }
}
