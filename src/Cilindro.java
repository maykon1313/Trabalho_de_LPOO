package src;

public class Cilindro extends Identificador{
    
    private int armazenado;

    public Cilindro() {
        this.armazenado = 0;
    }

    
    public void setArmazenado(int armazenado) { this.armazenado = armazenado; }
    
    
    public int getArmazenado() { return this.armazenado; }

    public void armazenarEnergia(int energia) { 
        if (this.armazenado + energia >= 100) {
            System.out.println("Cilindro " + this.getId() + " está cheio. Armazenamento máximo atingido.");
            this.armazenado = 100;
            return;
        }
        else {
            this.armazenado += energia; 
        }
    }

    public String toString() { return "Cilindro ID: " + this.getId() + ", Energia Armazenada: " + armazenado; }
}
