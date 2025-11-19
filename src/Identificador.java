package src;

public abstract class Identificador {
    private static int proximoId = 1;
    private final int id;

    public Identificador(){
        this.id = proximoId;
        proximoId++;
    }

    public int getId() {
        return id;
    }
}
