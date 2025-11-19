package src;

public final class Cilindro {
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

    public int armazenarEnergia(int energia) { 
        if (this.armazenado + energia >= 100) {
            this.armazenado = 100;
            return 1;
        }
        
        else {
            this.armazenado += energia; 
            return 0;
        }
    }

    @Override
    public String toString() { 
        return "Cilindro ID: " + id + " | Energia Armazenada: " + armazenado;
    }
}
