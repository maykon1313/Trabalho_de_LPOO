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

    public void armazenarEnergia(int energia) { 
        if (this.armazenado + energia >= 100) {
            System.out.println("Cilindro " + id + " está cheio. Armazenamento máximo atingido.");
            this.armazenado = 100;
            return;
        }
        else {
            this.armazenado += energia; 
        }
    }

    public String toString() { return "Cilindro ID: " + id + ", Energia Armazenada: " + armazenado; }
}
