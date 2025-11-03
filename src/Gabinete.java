package src;

public class Gabinete {
    private int id;
    private Porta abracadabra;
    private Monstro monstroPrincipal;
    private Monstro monstroAuxiliar;

    public Gabinete(int id, Porta abracadabra, Monstro monstroPrincipal, Monstro monstroAuxiliar) {
        this.id = id;
        this.abracadabra = abracadabra;
        this.monstroPrincipal = monstroPrincipal;
        this.monstroAuxiliar = monstroAuxiliar;
    }

    public void setId(int id) { this.id = id; }
    public void setPorta(Porta abracadabra) { this.abracadabra = abracadabra; }
    public void setMonstroPrincipal(Monstro monstroPrincipal) { this.monstroPrincipal = monstroPrincipal; }
    public void setMonstroAuxiliar(Monstro monstroAuxiliar) { this.monstroAuxiliar = monstroAuxiliar; }

    public int getId() { return this.id; }
    public Porta getPorta() { return this.abracadabra; }
    public Monstro getMonstroPrincipal() { return this.monstroPrincipal; }
    public Monstro getMonstroAuxiliar() { return this.monstroAuxiliar; }
}
