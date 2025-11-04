package src;

public class Gabinete {
    private int id;
    private Porta abracadabra;
    private Monstro monstroPrincipal;
    private Monstro monstroAuxiliar;
    private Cilindro cilindro;

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
    public Cilindro getCilindro() { return this.cilindro; }

    public String toString() { return "Gabinete ID: " + id + ", Porta: " + abracadabra + ", Monstro Principal: " + monstroPrincipal + ", Monstro Auxiliar: " + monstroAuxiliar + ", Cilindro: " + cilindro; }

    public static void processarEnergia(Cilindro c, Porta p, Monstro m_principal, Monstro m_auxiliar) {
        if (c == null || p == null || m_principal == null || m_auxiliar == null) {
            System.out.println("Erro: Cilindro, Porta ou Monstros inválidos.");
            return;
        }

        Crianca crianca = p.getCrianca();
        if (crianca == null) {
            System.out.println("Erro: Não há criança na porta.");
            return;
        }

        int energiaPrincipal = m_principal.coletarEnergiaDaCrianca(crianca);
        int energiaAuxiliar = m_auxiliar.coletarEnergiaDaCrianca(crianca);
        int energiaTotal = energiaPrincipal + energiaAuxiliar;

        //c.armazenarEnergia(energiaTotal);

        System.out.println("Processamento concluído:");
        System.out.println("Criança: " + crianca.getNome());
        System.out.println("Energia coletada pelo Monstro Principal (" + m_principal.getNome() + "): " + energiaPrincipal);
        System.out.println("Energia coletada pelo Monstro Auxiliar (" + m_auxiliar.getNome() + "): " + energiaAuxiliar);
        System.out.println("Energia total adicionada ao Cilindro (" + c.getId() + "): " + energiaTotal);
    }
}
