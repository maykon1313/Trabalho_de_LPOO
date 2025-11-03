package src;

public class Cilindro {
    private int id;
    private int armazenado;

    public Cilindro(int id) {
        this.id = id;
        this.armazenado = 0;
    }

    public void setId(int id) { this.id = id; }
    public void setArmazenado(int armazenado) { this.armazenado = armazenado; }
    
    public int getId() { return this.id; }
    public int getArmazenado() { return this.armazenado; }
}